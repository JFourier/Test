package jianzhioffer;

/**
 * @author He.H
 * @date 2019/6/18 10:46
 **/


//矩形覆盖
public class Offer10 {
    public int RectCover(int target) {
        if(target == 0)
            return 0;
        if(target == 1)
            return 1;
        if(target == 2)
            return 2;
        int[] dp = new int[target];
        dp[0] = 1;
        dp[1] = 2;
        for(int i = 2; i<target; i++){
            dp[i] = dp[i-1]+dp[i-2];
        }
        return dp[target-1];
    }
}
