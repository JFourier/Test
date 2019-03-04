package leetcode;

/**
 * @author He.H
 * @date 2019/1/7 9:29
 **/


public class Leetcode565 {
    public int arrayNesting(int[] nums) {
        int num, res = 1, count = 1, temp;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != -1) {
                num = nums[i];
                while (num != i) {
                    temp = num;
                    num = nums[num];
                    nums[temp] = -1;
                    count++;
                }
                res = Math.max(res, count);
                count = 1;
            }
        }
        return res;
    }
}
