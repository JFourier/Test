package Bishi;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author He.H
 * @date 2019/4/8 20:10
 **/


public class LLQ {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String i = scanner.nextLine();
        String[] h = i.split(",");
        int[] in = new int[h.length];
        for (int j = 0; j < h.length; j++) {
            in[j] = Integer.parseInt(h[j]);
        }
        ArrayList<Integer> used = new ArrayList<>();
        int res1 = minSubArray(in);
        int index = findMin(in);
        for (int j = index; j > 0 ; j--) {
            if (in[j]<=0){
                used.add(j);
            }else {
                break;
            }
        }
        int res2 = in[findSecondMin(in,used)];
        System.out.println(res1+res2);
    }
    public static int minSubArray(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            nums[i] = nums[i]+Math.min(nums[i-1],0);
        }
        return nums[findMin(nums)];
    }
    public static int findMin(int[] nums) {
        int tmp = 0;
        for (int i = 1; i < nums.length; i++) {
            tmp = (nums[tmp]<nums[i])? tmp:i;
        }
        return tmp;
    }
    public static int findSecondMin(int[] nums,ArrayList<Integer> used ) {
        int tmp = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i]<nums[tmp] && !used.contains(i)){
                tmp = i;
            }
        }
        if (nums[tmp]<=0){
            return tmp;
        }else {
            return 0;
        }
    }

}