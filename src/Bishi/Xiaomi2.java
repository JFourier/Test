package Bishi;

import java.util.Scanner;

/**
 * @author He.H
 * @date 2019/9/6 19:24
 **/


public class Xiaomi2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String[] tmp = str.trim().split(" ");
        int[] nums = new int[tmp.length];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = Integer.parseInt(tmp[i]);
        }
        boolean res = solve(nums);
        if(res) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }

    public static boolean solve(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            dp[i][i] = nums[i];
        }
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i + 1; j < n; j++) {
                dp[i][j] = Math.max(nums[i] - dp[i + 1][j], nums[j] - dp[i][j - 1]);
            }
        }
        return dp[0][n - 1] >= 0;
    }
}
