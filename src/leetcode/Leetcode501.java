package leetcode;


import java.util.ArrayList;
import java.util.List;

/**
 * 搜索二叉树的众数
 *
 * @author He.H
 * @date 2018/12/29 14:51
 **/


public class Leetcode501 {
    private int lastNum=Integer.MIN_VALUE;
    private int cur=lastNum;
    private int count=0;
    private int maxCount=Integer.MIN_VALUE;
    private List<Integer> res;
    public int[] findMode(TreeNode root) {
        res=new ArrayList<>();
        traversal(root);
        int[] arr=new int[res.size()];
        int i=0;
        for(Integer num:res)
            arr[i++]=num;
        return arr;
    }


    public void traversal(TreeNode root) {
        if(root==null)
            return ;
        traversal(root.left);
        cur=root.val;
        count=cur==lastNum?count+1:0;
        if(maxCount==count) {
            res.add(cur);
        } else if(maxCount<count) {
            res.clear();
            maxCount=count;
            res.add(cur);
        }
        lastNum=cur;
        traversal(root.right);
    }
}
