package jianzhioffer;

/**
 * @author He.H
 * @date 2019/6/18 10:44
 **/


//变态跳台阶
public class Offer9 {
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
