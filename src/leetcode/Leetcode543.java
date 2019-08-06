package leetcode;

/**
 * @author He.H
 * @date 2019/8/1 14:40
 **/


public class Leetcode543 {
    int max = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        helper(root);
        return max;
    }

    int helper(TreeNode root){
        if(root == null) return 0;
        int left = helper(root.left);
        int right = helper(root.right);
        max = Math.max(max, left + right);
        return Math.max(left, right) + 1;
    }
}
