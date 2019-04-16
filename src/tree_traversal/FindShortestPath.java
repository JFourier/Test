package tree_traversal;

import java.util.Stack;

/**
 * @author He.H
 * @date 2019/3/24 15:00
 **/


public class FindShortestPath {
    //查找指定节点的标记
    boolean bLeafIsFound = false;
    String path1;
    public String findPath(TreeNode root, Stack<Integer> path, TreeNode nodeToFind){
        if (root == null) {
            return null;
        }
        //将路径节点添加到栈中
        path.push(root.val);
        //如果到达了子节点
        if (!bLeafIsFound && root.val == nodeToFind.val) {
            //打印路径
            path1 = printPath(path);
            bLeafIsFound = true;
            return path1;
        }
        //查询左子树
        if (!bLeafIsFound && root.left != null) {
            findPath(root.left,path, nodeToFind);
        }
        //查询右子树
        if (!bLeafIsFound && root.right != null) {
            findPath(root.right, path, nodeToFind);
        }
        //如果没找到则弹栈
        if (!bLeafIsFound) {
            path.pop();
        }
        return path1;
    }

    public String printPath(Stack<Integer> path){
        int len = path.size();
        String s = ""+ path.pop();
        for (int i = 1; i < len; i++) {
            if (path.peek() != null) {
                s += "->" + path.pop();
            }
        }
        System.out.println(s);
        return s;
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q){
        //发现目标节点则通过返回值标记该子树发现了某个目标节点
        if (root == null || root == p || root == q) {
            return root;
        }
        //查看左子树中是否有目标节点，没有为null
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        //查看右子树中是否有目标节点，没有为null
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        //都不为空，则说明左右子树都有目标节点，则公共祖先就是本身。
        if (left != null && right != null) {
            return root;
        }
        return left == null ? right : left;
    }

    public void findPathOfTwoNode(TreeNode root,TreeNode p, TreeNode q){
        Stack<Integer> path1 = new Stack<>();
        Stack<Integer> path2 = new Stack<>();
        //寻找两个路径的交点，即最小公共祖先
        TreeNode lca = lowestCommonAncestor(root, p, q);
        //得到p节点的路径
        System.out.println("最小公共祖先节点" + lca.val + "和节点" + p.val + "之间的路径");
        String s1 = findPath(lca, path1, p);
        bLeafIsFound = false;//全局变量复位
        //得到q节点的路径
        System.out.println("最小公共祖先节点" + lca.val + "和节点" + q.val + "之间的路径");
        String s2 = findPath(lca, path2, q);
        bLeafIsFound = false;//全局变量复位
        //合并两条路径去掉重复的最小公共祖先
        String[] split = s2.split("->");
        String s3 = s1 + "->" + split[0];
        for (int i = 1; i < split.length; i++) {
            if (Integer.parseInt(split[i]) != lca.val) {
                s3 += "->" + split[i];
            }
        }
        System.out.println("归并后的路径为：" + s3);
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(7);
        TreeNode node8 = new TreeNode(8);

        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node3.left = node5;
        node3.right = node6;
        node4.right = node7;
        node6.left = node8;

        FindShortestPath findShortestPath = new FindShortestPath();
        findShortestPath.findPathOfTwoNode(node1, node7, node3);
    }
}

