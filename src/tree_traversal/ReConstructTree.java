package tree_traversal;

/**
 * @author He.H
 * @date 2019/1/9 9:11
 **/


public class ReConstructTree {
    //根据前序和中序可以确定唯一一棵二叉树。解法：理解是比较简单的，前序确定根节点的值，中序找到根节点的位置，根节点的前半部分是左子树，根的后半部分是右子树，再构建左子树，右子树
    public TreeNode buildTree1(int[] preorder, int[] inorder) {
        return build(preorder,inorder,0,0,inorder.length-1);
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

    //中序与后序
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return build(postorder.length-1,0,inorder.length-1,inorder,postorder);
    }
    private TreeNode build(int poststart,int instart,int inend,int[] inorder, int[] postorder){
        if(poststart<0||instart>inend){
            return null;
        }
        TreeNode root=new TreeNode(postorder[poststart]);
        int inindex=0;
        for(int i=instart;i<=inend;i++){
            if(inorder[i]==root.val){
                inindex=i;
                break;
            }
        }
        root.right=build(poststart-1,inindex+1,inend,inorder,postorder);
        root.left=build(poststart-(inend-inindex)-1,instart,inindex-1,inorder,postorder);
        return root;
    }



}
