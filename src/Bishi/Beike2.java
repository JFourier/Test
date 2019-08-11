package Bishi;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 2019/8/10
 *
 * @author He.H
 * @date 2019/8/10 18:38
 **/


public class Beike2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double[] nums = new double[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextDouble();
        }
        System.out.println(solve(nums));
    }

    public static int solve(double[] nums){
        int len = nums.length;
        Arrays.sort(nums);
        int res = 0;
        for (int i = 0; i < len; i++) {
            res += cnt(nums, i);
        }
        return res;
    }

    public static int cnt(double[] nums, int index) {
        int res = 0;
        if (index == nums.length-1) {
            return res;
        }

        for (int i = index+1; i < nums.length; i++) {
            if ((nums[index]>= nums[i]*0.9)) {
                res++;
            } else {
                break;
            }
        }
        return res;
    }
}
