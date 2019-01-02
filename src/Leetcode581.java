/**
 * 寻找最短无序子数组
 * @author He.H
 * @date 2019/1/2 10:45
 **/


public class Leetcode581 {
    public int findUnsortedSubarray(int[] nums) {
        int len = nums.length;
        int max = nums[0];
        int min = nums[len - 1];
        int beg = -1;
        int end = -2;
        for (int i = 1; i < len; i++) {
            max = Math.max(max, nums[i]);
            min = Math.min(min, nums[len - i - 1]);
            if (max > nums[i]) {
                end = i;
            }
            if (min < nums[len - i - 1]) {
                beg = len - i - 1;
            }
        }
        return end - beg + 1;
    }
}
