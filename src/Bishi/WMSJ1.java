package Bishi;

import java.util.Scanner;

/**
 * @author He.H
 * @date 2019/4/15 19:47
 **/


public class WMSJ1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] score = new int[n];
        int[] times = new int[n];
        for (int i = 0; i < n; i++) {
            score[i] = scanner.nextInt();
        }
        for (int i = 0; i < n; i++) {
            times[i] = scanner.nextInt();
        }
        int time = scanner.nextInt();
        int res = Solve(time,n,times,score);
        System.out.println(res);

    }
    public static int Solve(int time, int n, int[] times, int[] score) {
        int[] dp = new int[time+1];
        for (int i = 1; i < n+1; i++) {
            for (int j = time; j >= times[i-1]; j--) {
                dp[j] = Math.max(dp[j-times[i-1]]+score[i-1], dp[j]);
            }
        }
        return dp[time];
    }
}
