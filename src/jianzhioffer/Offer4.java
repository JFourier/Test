package jianzhioffer;

/**
 * @author He.H
 * @date 2019/6/18 10:28
 **/


//重建二叉树（前序&中序）
public class Offer4 {
    public TreeNode reConstructBinaryTree(int [] pre,int [] in) {
        return build(pre ,in ,0 ,0 ,in.length-1);
    }
    public TreeNode build(int[] pre, int[] in,int preStart,int inStart,int inEnd){
        if(preStart > pre.length - 1||inStart>inEnd)
            return null;
        TreeNode root = new TreeNode(pre[preStart]);//确定根节点的值
        int index = 0;//记录根节点在中序遍历中的位置，为每次遍历的根节点的相对位置
        for(int i=inStart;i<=inEnd;i++){
            if(root.val == in[i]){
                index = i;
                break;
            }
        }
        root.left = build(pre,in,preStart+1,inStart,index-1);//找出左子树的各个位置，index-1为左子树的结束值位置
        root.right = build(pre,in,preStart+index-inStart+1,index+1,inEnd);//找出右子树的各个位置
        return root;
    }
}
