package Bishi;

import java.util.Scanner;

/**
 * @author He.H
 * @date 2019/8/17 19:49
 **/


public class TengXun5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] board = new int[n][3];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = sc.nextInt();
            }
        }

        int[][] dp = new int[n][3];
        for (int i = 0; i < 3; i++) {
            dp[0][i] = board[0][i];
        }

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < 3; j++) {
                if (j == 0 && board[i][j]!=0) {
                    dp[i][j] = Math.max(board[i-1][j], board[i-1][j+1]) + board[i][j];
                } else if (j == 1 && board[i][j]!=0) {
                    dp[i][j] = Math.max(board[i-1][j-1] ,Math.max(board[i-1][j], board[i-1][j+1])) + board[i][j];
                } else if (j == 2 && board[i][j]!=0) {
                    dp[i][j] = Math.max(board[i-1][j], board[i-1][j-1]) + board[i][j];
                }
            }
        }
    }
}
