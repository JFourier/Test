package leetcode;

import java.util.Scanner;

/**
 * @author He.H
 * @date 2018/12/4 20:12
 **/


public class Leetcode375 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        System.out.println(getMoneyAmount(n));
    }
    public static int getMoneyAmount(int n) {
        int [][] dp = new int[n+1][n+1];
        for(int len = 2; len<=n; len++){
            for(int start = 1; start<=n-len+1; start++){
                int minPay = Integer.MAX_VALUE;
                for(int pivot = start; pivot < start+len-1; pivot++){
                    int temp = pivot + Math.max(dp[start][pivot-1], dp[pivot+1][start+len-1]);
                    minPay = Math.min(minPay, temp);
                }
                dp[start][start+len-1] = minPay;
            }
        }
        return dp[1][n];
    }
}
