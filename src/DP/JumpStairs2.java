package DP;

/**
 * 一次可能1个，2个、、、n个
 *f(n) = 2*f(n-1)
 * @author He.H
 * @date 2019/1/8 19:26
 **/


public class JumpStairs2 {
    public int JumpFloorII(int target) {
        int[] dp = new int[target+1];
        dp[0] = 0;
        dp[1] = 1;
        for(int i = 2; i<=target; i++){
            dp[i] = 2*dp[i-1];
        }
        return dp[target];
    }
}
