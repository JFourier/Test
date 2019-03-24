package tree_traversal;

/**
 * @author He.H
 * @date 2019/3/24 16:41
 **/


public class CommonAncestor {
    //BST
    public TreeNode lowestCommonAncestorBST(TreeNode root, TreeNode p, TreeNode q) {
        while(root != null){
            if(root.val > p.val && root.val > q.val)
                root = root.left;
            else if (root.val < p.val && root.val < q.val)
                root = root.right;
            else
                return root;
        }
        return null;
    }


    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null)
            return null;
        if(root==p||root==q)
            return root;
        TreeNode left=lowestCommonAncestor(root.left,p,q);
        TreeNode right=lowestCommonAncestor(root.right,p,q);
        if(left!=null&&right!=null)
            return root;
        return left!=null?left:right;
    }

    public static void main(String[] args){
        TreeNode root = new TreeNode(4);
        TreeNode l1 = new TreeNode(1);
        TreeNode r1 = new TreeNode(2);
        TreeNode l21 = new TreeNode(3);
        TreeNode l22 = new TreeNode(5);
        TreeNode r21 = new TreeNode(6);
        TreeNode r22 = new TreeNode(7);

        root.left = l1;
        root.right = r1;
        l1.left = l21;
        l1.right =l22;
        r1.left = r21;
        r1.right = r22;

        System.out.println(lowestCommonAncestor(root, l21, r21).val);
    }
}
