package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author He.H
 * @date 2019/2/15 9:47
 **/


public class Leetcode46 {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        //ArrayList<Integer> temp = new ArrayList<Integer>();
        dfs(res, nums, 0);
        return res;
    }
    private void dfs(List<List<Integer>> res, int[] nums, int j) {
        if (j == nums.length) {
            List<Integer> temp = new ArrayList<Integer>();
            for (int num : nums) temp.add(num);
            res.add(temp);
        }
        for (int i = j; i < nums.length; i++) {
            swap(nums, i, j);
            dfs(res, nums, j+1);
            swap(nums, i, j);
        }
    }
    private void swap(int[] nums, int m, int n) {
        int temp = nums[m];
        nums[m] = nums[n];
        nums[n] = temp;
    }

    public static void main(String[] args){
        Leetcode46 m = new Leetcode46();
        int[] tes = {1, 2, 3, 4};
        List<List<Integer>> res = m.permute(tes);
        System.out.println(res.size());
    }
}
