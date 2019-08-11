package Bishi;

import java.util.Scanner;

/**
 * @author He.H
 * @date 2019/8/10 18:38
 **/


public class Beike4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long[] nums = new long[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextLong();
        }

        long[] ans = new long[2];
        long res = Long.MAX_VALUE;
        for (int i = 0; i < n-1; i++) {
            long temp = Math.abs(nums[i]-nums[i+1]);
            if (temp<res){
                ans[0] = nums[i];
                ans[1] = nums[i+1];
                res = temp;
            }
        }
        System.out.print(ans[0]);
        System.out.print(" ");
        System.out.println(ans[1]);
    }
}
