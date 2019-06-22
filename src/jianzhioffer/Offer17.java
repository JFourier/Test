package jianzhioffer;

/**
 * @author He.H
 * @date 2019/6/18 11:00
 **/


//树的子结构
public class Offer17 {
    public boolean HasSubtree(TreeNode root1,TreeNode root2) {
        if(root1 == null || root2 == null)
            return false;
        boolean res = false;
        if(root1.val == root2.val)
            res = helper(root1, root2);
        if(res) {
            return true;
        } else {
            return (helper(root1.left, root2) || helper(root1.right,root2));
        }
    }

    public boolean helper(TreeNode root1,TreeNode root2) {
        if(root2 == null) {
            return true;
        } else if(root1 == null) {
            return false;
        } else if(root1.val != root2.val) {
            return false;
        } else {
            return (helper(root1.left, root2.left) && helper(root1.right,root2.right));
        }
    }
}
