import org.apache.commons.math3.util.Pair;

/**
 * leetcoe  494
 *
 * @author He.H
 * @date 2018/12/19 19:29
 *
 *
 * 思路来源：  https://blog.csdn.net/hit0803107/article/details/54894227
 **/


public class FinfTargetSumWays {
    public static int findTargetSumWays(int[] nums, int S) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) sum += nums[i];
        if (S > sum || (sum + S) % 2 == 1) {
            return 0;
        }
        return subsetSum(nums, (sum + S) / 2);
    }

    private static int subsetSum(int[] nums, int S) {
        int[] dp = new int[S + 1];
        dp[0] = 1;//C(0,0)=1
        for (int i = 0; i < nums.length; i++) {
            for (int j = S; j >= nums[i]; j--) {
                dp[j] += dp[j - nums[i]];
            }
        }
        return dp[S];
    }


    /*
    *
    public int findTargetSumWays(int[] nums, int S) {
        return findTargetSumWays(nums, 0, S, 0);
    }

    private int findTargetSumWays(int[] nums, int index, int S, int sum) {
        int res = 0;
        if (index == nums.length) {
            return sum == S ? ++res : res;
        }
        res += findTargetSumWays(nums, index + 1, S, sum + nums[index]);
        res += findTargetSumWays(nums, index + 1, S, sum - nums[index]);
        return res;
    }
    * */
    public static void main(String[] args){
        int[] nums = {1,2,3,4,5};
        int s = 3;
        int res = findTargetSumWays(nums, s);
        System.out.println(res);
        //Pair pa = new Pair(1,2);
    }
}
