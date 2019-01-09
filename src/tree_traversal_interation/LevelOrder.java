package tree_traversal_interation;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author He.H
 * @date 2019/1/9 15:34
 **/


public class LevelOrder {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ret = new ArrayList<>();
        if (root == null)
            return ret;
        levelOrderCore(root, ret);
        return ret;
    }
    public void levelOrderCore(TreeNode root, List<List<Integer>> ret) {
        // 用来标记下一行有多少元素
        int nextCount = 0;
        // 当前层有多少结点，为1 是根节点初始化
        int curCount = 1;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        List<Integer> tmp = new ArrayList<>();
        while (!q.isEmpty()) {
            TreeNode node = q.poll();
            tmp.add(node.val);
            // 遍历结点当前个数减去1
            curCount--;
            if (node.left != null) {
                q.offer(node.left);
                // 左右孩子属于下一层结点
                nextCount++;
            }
            if (node.right != null) {
                q.offer(node.right);
                nextCount++;
            }
            // 如果当前层遍历完，加入结果集合
            if (curCount == 0) {
                curCount = nextCount;
                nextCount = 0;
                ret.add(new ArrayList<>(tmp));
                tmp.clear();

            }
        }
    }


    //从底至顶
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
