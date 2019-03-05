package leetcode;

/**
 * @author He.H
 * @date 2019/3/4 11:22
 **/


public class Leetcode718 {
    public int findLength(int[] A, int[] B) {
        int n = A.length, m = B.length, res = 0;
        int[][] dp = new int[n+1][m+1];
        for(int i = 0; i<n; i++) {
            for(int j = 0; j<n; j++) {
                if(A[i] == B[j]) {
                    dp[i+1][j+1] = dp[i][j]>0?dp[i][j]+1:1;
                    res = Math.max(res, dp[i+1][j+1]);
                }
            }
        }
        return res;
    }
    public int findLength2(int[] A, int[] B) {
        int n = A.length, m = B.length, max = 0;
        int[] dp = new int[m+1];
        for(int i = 1; i <= n; i++)
            for(int j = m; j > 0; j--)
                max = Math.max(max, dp[j] = A[i-1] == B[j-1] ? dp[j-1] + 1 : 0);
        return max;
    }
}
