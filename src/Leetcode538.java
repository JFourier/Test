/**
 * @author He.H
 * @date 2018/12/29 16:28
 **/


public class Leetcode538 {
    ////以右->根->左的顺序遍历二叉树，将遍历顺序的前一个结点的累加值记录起来，和当前结点相加，得到当前结点的累加值
    public int preNum = 0;
    //递归写法
    public TreeNode convertBST(TreeNode root) {
        unPreOrder(root);
        return root;
    }
    public void unPreOrder(TreeNode root){
        if(root == null)
            return;
        unPreOrder(root.right);
        root.val += preNum;
        preNum = root.val;
        unPreOrder(root.left);
    }
    //非递归写法
    /*public TreeNode convertBST(TreeNode root) {
        if(root == null)
            return root;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        //stack.add(root);
        TreeNode node = root;
        while(node != null || !stack.isEmpty()){
            while(node != null){
                stack.add(node);
                node = node.right;
            }
            node = stack.pop();
            node.val += preNum;
            preNum = node.val;
            if(node.left != null)
                node = node.left;
            else
                node = null;
        }
        return root;
    }*/
}
