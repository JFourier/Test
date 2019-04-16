package Bishi;


import java.util.*;

/**
 * @author He.H
 * @date 2019/4/13 20:22
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

        HashMap<Integer, HashSet<Integer>> map = new HashMap<>();
        for (int i = 0; i < n-1; i++) {
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



    }

}
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val,List<Node> _children) {
        val = _val;
        children = _children;
    }
}
