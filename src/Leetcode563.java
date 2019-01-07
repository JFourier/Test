/**
 * @author He.H
 * @date 2019/1/5 16:04
 **/


public class Leetcode563 {
    private int tiltSum;
    public int findTilt(TreeNode root) {
        findSubTilt(root);
        return tiltSum;
    }
    public int findSubTilt(TreeNode root){
        if(root == null)
            return 0;
        int leftTilt = findSubTilt(root.left);
        int rightTilt = findSubTilt(root.right);
        tiltSum += Math.abs(leftTilt - rightTilt);
        return root.val + leftTilt + rightTilt;
    }
}
