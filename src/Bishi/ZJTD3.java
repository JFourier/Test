package Bishi;

import java.util.Scanner;

/**
 * 头条8-11
 *
 * @author He.H
 * @date 2019/8/11 17:08
 **/


public class ZJTD3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        int res = minNum(nums);
        System.out.println(res*100);
    }

    public static int minNum(int[] nums){
        if (nums.length==0) {
            return 0;
        }
        if (nums.length==1) {
            return 1;
        }
        int[] res = new int[nums.length];
        res[0]=1;
        for(int i=1;i<nums.length;i++){
            if (nums[i]>nums[i-1]) {
                res[i]=res[i-1]+1;
            }
            else{
                res[i]=1;
            }
        }
        for(int i=nums.length-2;i>=0;i--){
            if (nums[i]>nums[i+1] && res[i]<=res[i+1]) {
                res[i]=Math.max(res[i], res[i+1]+1);
            }
        }

        return sumArray(res);
    }
    public static int sumArray(int[] arr){
        int res=0;
        for(int ele:arr){
            res+=ele;
        }
        return res;
    }
}
