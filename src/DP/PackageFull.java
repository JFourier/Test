package DP;

/**
 * @author He.H
 * @date 2019/7/1 14:34
 **/


public class PackageFull {
    public static void main(String[] args) {
        int N = 3;
        int W = 340;
        int[] value = {150, 200, 350};
        int[] weight = {150, 200, 350};

        int res = dp(value,weight,N,W);
        System.out.println(W-res);
    }
    private static int dp(int[] w, int[] v, int n, int W){
        int dp[][] = new int[n][W + 1];
        for(int i = 0; i <= W; i++){
            dp[0][i] = i / w[0] * v[0];
        }
        for(int i = 0; i < n; i++){
            dp[i][0] = 0;
        }
        int max = 0;
        for(int i = 1; i < n; i++){
            for(int j = 1; j <= W; j++){
                for(int k = 0; k * w[i] <= j; k++){
                    int t = k * v[i] + dp[i - 1][j - k * w[i]];
                    if(max < t){
                        max = t;
                    }
                }
                dp[i][j] = max;
                 //特别要注意max要重置为零,否则dp数组里面的值是错误的
                max = 0;
            }
        }
        return dp[n - 1][W];
    }
}
