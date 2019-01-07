/**
 * @author He.H
 * @date 2019/1/7 21:26
 **/


public class Leetcode572 {
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if(s == null)
            return false;

        return issubtree(s,t) || isSubtree(s.right, t) || isSubtree(s.left, t);
    }
    public boolean issubtree(TreeNode s, TreeNode t)
    {
        if(s == null && t != null)
            return false;
        if(t == null && s == null)
            return true;
        if(t == null && s != null)
            return false;
        if(s.val == t.val)
            return issubtree(s.left, t.left) && issubtree(s.right, t.right)||issubtree(s.left, t)||issubtree(s.right,t);
        else
            return false;
    }
}
