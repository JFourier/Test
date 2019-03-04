package leetcode;

/**
 * @author He.H
 * @date 2018/12/28 20:15
 **/


public class Leetcode700 {
    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null) {
            return null;
        }

        if (root.val == val) {
            return root;
        } else if (root.val > val) { // 在左子树中查找
            return searchBST(root.left, val);
        } else { // 在右子树中查找
            return searchBST(root.right, val);
        }
    }
}
