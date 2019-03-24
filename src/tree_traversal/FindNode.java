package tree_traversal;

import java.util.ArrayList;

/**
 * @author He.H
 * @date 2019/3/24 15:00
 **/


public class FindNode {
    public static boolean findPath(TreeNode root, int target, ArrayList<Integer> path) {
        path.add(root.val);
        if(root.val == target){
            return true;
        }
        boolean found = false;
        if(root.left!=null) {
            found = findPath(root.left,target,path);
        }
        if(!found && root.right!=null) {
            found = findPath(root.right,target,path);
        }
        if(!found) {
            path.remove(path.size()-1);
        }
        return found;
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
        ArrayList<Integer> res = new ArrayList<>();
        findPath(root, 7, res);
        for (Integer tmp:res
        ) {
            System.out.println(tmp);
        }
    }

}
