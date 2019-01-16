package DP;

/**
 * @author He.H
 * @date 2018/12/29 15:28
 **/


public class Leetcode486 {
    public boolean PredictTheWinner(int[] nums) {
        //DP1
        if (nums.length%2 == 0)
            return (nums.length%2 == 0);
        int[][] dp = new int[nums.length][nums.length];
        dp[dp.length - 1][dp.length - 1] = nums[nums.length - 1];
        for (int left = dp.length - 2; left >= 0; left--) {
            for (int right = left; right < dp.length; right++) {
                if (left == right) {
                    dp[left][right] = nums[left];
                } else {
                    int pickLeft = nums[left] - dp[left + 1][right];
                    int pickRight = nums[right] - dp[left][right - 1];
                    dp[left][right] = Math.max(pickLeft, pickRight);
                }
            }
        }
        return dp[0][nums.length - 1] >= 0;
    }

    public boolean PredictTheWinner2(int[] nums) {
        //DP2
        if (nums == null || nums.length == 0) {
            return false;
        }
        int[][] dp = new int[nums.length][nums.length];
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        for (int i = 0; i < nums.length; i++) {
            dp[i][i] = nums[i];
        }
        for (int i = nums.length - 2; i >= 0; i--) {
            for (int j = i + 1; j < nums.length; j++) {
                dp[i][j] = Math.max(nums[i] - dp[i + 1][j], nums[j] - dp[i][j - 1]);
            }
        }
        return dp[0][nums.length - 1] >= 0;
    }


    public boolean PredictTheWinner3(int[] nums) {
        //循环
        int ret = partition(nums, 0, nums.length - 1, new Integer[nums.length][nums.length]);
        return ret >= 0;
    }
    private int partition(int[] nums, int beg, int end, Integer[][] cache) {
        if (cache[beg][end] == null) {
            cache[beg][end] = beg == end ? nums[beg] : Math.max(nums[beg] - partition(nums, beg + 1, end, cache), nums[end] - partition(nums, beg, end - 1, cache));
        }
        return cache[beg][end];
    }
}
