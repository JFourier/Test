package leetcode;

/**
 * @author He.H
 * @date 2018/11/28 15:42
 **/


public class Leetcode111 {
    public static int minDepth(TreeNode root) {
        if(root == null)
            return 0;
        if(root.left == null) {
            return minDepth(root.right)+1;
        }
        if(root.right == null) {
            return minDepth(root.left)+1;
        }
        else {
            int left = minDepth(root.left);
            int right = minDepth(root.right);
            return left>right?right+1:left+1;
        }
    }
    public static void main(String[] args){

    }
}
