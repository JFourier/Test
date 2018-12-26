/**
 * 最大子数组
 *
 * @author He.H
 * @date 2018/12/26 14:56
 **/


public class Leetcode643 {
    private static double findMaxAverage(int[] nums, int k) {
        int  result, sum = 0;
        for (int i = 0; i < k; i++) {
            sum += nums[i];
        }
        result = sum;
        for (int i = 1; i <= nums.length - k; i++){
            sum = sum - nums[i - 1] + nums[i + k - 1];
            result = Math.max(sum, result);
        }
        return (double)result / k;
    }
    public static void main(String[] args){
        int [] nums = {0, 4, 0, 3, 2};
        int k = 1;
        double res = findMaxAverage(nums, k);
        System.out.println(res);
    }
}
