package leetcode;

import javax.swing.text.MutableAttributeSet;

/**
 * @author He.H
 * @date 2019/3/5 11:03
 **/


public class Leetcode53 {
    public static int maxSubArray(int[] nums) {
        int sum=nums[0];
        int n=nums[0];
        for(int i=1;i<nums.length;i++) {
            if(n>0)
                n+=nums[i];
            else
                n=nums[i];
            if(sum<n)
                sum=n;
        }
        return sum;
    }

    public static int maxSubArray2(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int res = dp[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(dp[i-1]+nums[i], nums[i]);
            res = Math.max(res,dp[i]);
        }
        return res;
    }

    public static void main(String[] args){
        int[] test = new int[]{-2,1,-3,4,-1,2,1,-5,4};
        int res = maxSubArray(test);
        int res2 = maxSubArray2(test);
        System.out.println(res);
        System.out.println(res2);
    }
}
