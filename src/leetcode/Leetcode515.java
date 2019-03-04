package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author He.H
 * @date 2018/12/30 14:39
 **/


public class Leetcode515 {
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> list = new ArrayList();
        if(root==null)return list;
        Queue<TreeNode> q = new LinkedList();
        q.add(root);
        int max;
        while(!q.isEmpty()){
            int size=q.size();//当前层的size
            max=q.peek().val;
            while(size>0){
                TreeNode tem = q.poll();
                if(tem.val > max) {
                    max=tem.val;
                }
                if(tem.left != null) {
                    q.add(tem.left);
                }
                if(tem.right != null) {
                    q.add(tem.right);
                }
                size--;
            }
            list.add(max);
        }
        return list;
    }
}
