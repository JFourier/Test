package Bishi;



import java.util.*;

/**
 * @author He.H
 * @date 2019/4/13 20:22
 * N叉树的最大深度
 **/


public class JD2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[][] nodes = new int[n-1][2];
        for (int i = 0; i < n-1; i++) {
            for (int j = 0; j < 2; j++) {
                nodes[i][j] = scanner.nextInt();
            }
        }
        int res = maxDepth(makeTree(nodes));
        System.out.println(res);
    }

    public static NTreeNode makeTree(int[][] nodes) {

        HashMap<Integer, HashSet<Integer>> map = new HashMap<>();
        for (int i = 0; i < nodes.length; i++) {
            if (!map.keySet().contains(nodes[i][0])) {
                map.put(nodes[i][0], new HashSet<>());
                map.get(nodes[i][0]).add(nodes[i][1]);
            }
            if (!map.keySet().contains(nodes[i][1])) {
                map.put(nodes[i][1], new HashSet<>());
                map.get(nodes[i][1]).add(nodes[i][0]);
            }
            map.get(nodes[i][0]).add(nodes[i][1]);
            map.get(nodes[i][1]).add(nodes[i][0]);
        }

        //修改map，每个key下只包括他的子节点
        Queue<Integer> queue = new LinkedList<>();
        HashSet<Integer> eleset = new HashSet<>();
        queue.offer(1);
        eleset.add(1);
        while(!queue.isEmpty()) {
            int tmpkey = queue.poll();
            Iterator<Integer> iter = map.get(tmpkey).iterator();
            while (iter.hasNext()) {
                Integer i = iter.next();
                if (!eleset.contains(i)) {
                    queue.offer(i);
                    eleset.add(i);
                } else {
                    iter.remove();
                }
            }
        }

        NTreeNode root = new NTreeNode(1);
        Queue<NTreeNode> nodeQueue = new LinkedList<>();
        nodeQueue.offer(root);
        while (!nodeQueue.isEmpty()) {
            NTreeNode node = nodeQueue.poll();
            for(int i : map.get(node.val)) {
                NTreeNode tmp = new NTreeNode(i);
                node.children.add(tmp);
                nodeQueue.offer(tmp);
            }
        }
        return root;
    }

    public static int maxDepth(NTreeNode root) {
        if(root == null){
            return 0;
        }else{
            return deep(root,1);
        }
    }

    public static int deep(NTreeNode root ,int d){
        List<NTreeNode> childer = root.children;
        int size=childer==null?0:childer.size();
        if(size==0){
            return d;
        }else{
            int [] tag = new int[size];
            for(int i=0;i<size;i++){
                NTreeNode x = childer.get(i);
                tag[i] = deep(x,d+1);
            }
            int max = 0;
            for(int i=0;i<size;i++){
                if(tag[i]>tag[max]){
                    max = i;
                }
            }
            return tag[max];
        }
    }

}
class NTreeNode {
    public int val;
    public ArrayList<NTreeNode> children;

    public NTreeNode(int _val) {
        val = _val;
        children = new ArrayList<>();
    }

    public NTreeNode(int _val,ArrayList<NTreeNode> _children) {
        val = _val;
        children = _children;
    }
}
