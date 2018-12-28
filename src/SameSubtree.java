import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * leetcode652 寻找相同结构的子树
 * @author He.H
 * @date 2018/12/28 14:56
 **/


public class SameSubtree {
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        /**
         后续遍历二叉树, 先考虑子树的结构才能了解这颗树的结构, 用map保存二叉树后序遍历字符串出现的次数,
         未出现过则存入map, 重复出现就加1, 但只在次数等于1时加入返回序列中以避免重复.
         **/
        List<TreeNode> ret = new ArrayList<>();
        if(root == null) return ret;
        postorder(root, new HashMap<>(), ret);
        return ret;
    }

    private String postorder(TreeNode r, Map<String, Integer> map, List<TreeNode> ret) {
        if(r == null) return "#";
        String serial = r.val + "," + postorder(r.left, map, ret) + "," + postorder(r.right, map, ret);
        if(map.getOrDefault(serial, 0) == 1)
            ret.add(r);
        map.put(serial, map.getOrDefault(serial, 0)+1);
        return serial;
    }
}
