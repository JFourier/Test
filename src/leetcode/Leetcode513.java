package leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author He.H
 * @date 2019/6/14 9:34
 **/


public class Leetcode513 {
    public int findBottomLeftValue(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            root = q.poll();
            if (root.right != null)
                q.add(root.right);
            if (root.left != null)
                q.add(root.left);
            /*此处为寻找左下角则先入右节点，若寻找右下角则先入左节点*/
        }
        return root.val;
    }
}
