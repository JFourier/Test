import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author He.H
 * @date 2019/3/5 20:22
 **/


public class PrintLinesForTree {
    public ArrayList<ArrayList<Integer> > Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> result=new ArrayList<ArrayList<Integer>>();
        if(pRoot==null)
            return result;
        //result返回结果
        //queue队列用来层序遍历二叉树
        Queue<TreeNode> queue=new LinkedList<>();
        queue.add(pRoot);
        //记录每一行的最后一个节点
        TreeNode lastNodeOfThisLine=pRoot;
        //当前遍历的节点
        TreeNode temp=null;
        //记录队列中最后一个节点
        TreeNode lastNode=null;
        //记录每一行的节点
        ArrayList<Integer> line=new ArrayList<Integer>();
        while(!queue.isEmpty()){
            temp=queue.remove();
            if(temp.left!=null){
                queue.add(temp.left);
                lastNode=temp.left;
            }

            if(temp.right!=null){
                queue.add(temp.right);
                lastNode=temp.right;
            }
            line.add(temp.val);
            if(temp==lastNodeOfThisLine){
                result.add(line);
                //如果当前行的最后节点为树的最后节点，跳出循环
                if(lastNode==lastNodeOfThisLine)
                    break;
                //获取队列的最尾元素
                lastNodeOfThisLine=lastNode;
                line=new ArrayList<Integer>();
            }
        }
        return result;
    }
}
