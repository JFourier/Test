package leetcode;

/**
 * @author He.H
 * @date 2019/1/14 9:37
 **/


public class Leetocde530 {
    int min=Integer.MAX_VALUE;
    TreeNode prenode=null;
    public int getMinimumDifference(TreeNode root) {
        inOrder(root);
        return min;

    }
    public void inOrder(TreeNode t) {
        if (t == null) {
            return;
        }
        inOrder(t.left);
        if (prenode != null) {
            min = Math.min(min, Math.abs(t.val - prenode.val));
        }
        prenode = t;
        inOrder(t.right);
    }
}
