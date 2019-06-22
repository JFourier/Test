package jianzhioffer;

/**
 * @author He.H
 * @date 2019/6/18 10:43
 **/


//跳台阶
public class Offer8 {
    public int JumpFloor(int target) {
        if (target == 1)
            return 1;
        if (target == 2)
            return 2;
        int[] dp = new int[target+1];
        dp[1] = 1;
        dp[2] = 2;
        for(int i=3; i<=target; i++){
            dp[i] = dp[i-1]+dp[i-2];
        }
        return dp[target];
    }
}
