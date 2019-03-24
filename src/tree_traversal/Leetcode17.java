package tree_traversal;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author He.H
 * @date 2019/3/20 22:55
 **/


public class Leetcode17 {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> list = new LinkedList<List<Integer>>();
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        if(root == null)
            return list;
        queue.offer(root);
        while(!queue.isEmpty()){
            int num = queue.size();
            List<Integer> levelList = new LinkedList<Integer>();
            for(int i = 0; i < num; i++){
                if(queue.peek().left != null)
                    queue.offer(queue.peek().left);
                if(queue.peek().right != null)
                    queue.offer(queue.peek().right);
                levelList.add(queue.poll().val);
            }
            list.add(0, levelList);
        }
        return list;
    }
}
