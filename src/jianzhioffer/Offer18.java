package jianzhioffer;

/**
 * @author He.H
 * @date 2019/6/18 11:04
 **/


//二叉树的镜像
public class Offer18 {
    public void Mirror(TreeNode root) {
        if (root == null)
            return;
        TreeNode tmp = null;
        tmp = root.right;
        root.right = root.left;
        root.left = tmp;
        Mirror(root.right);
        Mirror(root.left);
    }
}
