package leetcode;

import java.util.ArrayList;

/**
 * @author He.H
 * @date 2019/8/10 10:06
 **/

//冗余链接
public class Leetcode684 {
    //去掉入度为1的点，然后把这条边上的点的入度都减1.直到没有入度为1的点。剩下的点就是环。然后把所有边从后往前遍历。返回在环上的边。
    public int[] findRedundantConnection1(int[][] edges) {
        int n = edges.length;
        int[] inDegrees = new int[n];
        for(int[] edge: edges){
            inDegrees[edge[0]-1]++;
            inDegrees[edge[1]-1]++;
        }
        while (true) {
            //System.out.println(Arrays.toString(inDegrees));
            int flag = -1;
            //System.out.println(flag);
            for (int i = 0; i < n; i++) {
                if (inDegrees[i] == 1) {
                    flag = 1;
                    for (int[] edge : edges) {
                        if (edge[0] == i+1 || edge[1] == i+1) {
                            inDegrees[edge[0] - 1]--;
                            inDegrees[edge[1] - 1]--;
                        }
                    }
                }
            }
            if(flag==-1){
                break;
            }
        }
        ArrayList<Integer> list = new ArrayList<>();
        for (int i=0;i<n;i++){
            if(inDegrees[i]==2){
                list.add(i+1);
            }
        }
        for(int i=edges.length-1;i>=0;i--){
            if(list.contains(edges[i][0])&&list.contains(edges[i][1])){
                return edges[i];
            }
        }
        return new int[2];
    }


    //并查集
    public static class UnionFind {
        int[] parent;
        int[] rank;

        public UnionFind(int total) {
            parent = new int[total];
            rank = new int[total];

            for (int i = 0; i < total; i++) {
                parent[i] = i;
                rank[i] = 1;
            }
        }

        public int find(int x) {
            while (x != parent[x]) {
                parent[x] = parent[parent[x]];
                x = parent[x];
            }
            return x;
        }

        public void unionElements(int p, int q) {
            int pRoot = find(p);
            int qRoot = find(q);

            if (pRoot == qRoot) {
                return;
            }

            if (rank[pRoot] < rank[qRoot]) {
                parent[pRoot] = qRoot;
            } else if (rank[pRoot] > rank[qRoot]) {
                parent[qRoot] = pRoot;
            } else {
                parent[pRoot] = qRoot;
                rank[qRoot] += 1;
            }
        }
    }
    public int[] findRedundantConnection(int[][] edges) {
        int[] res = new int[2];
        UnionFind unionFind = new UnionFind(edges.length);
        // 第一条边肯定未记录至树中，可直接合并节点
        unionFind.unionElements(edges[0][0] - 1, edges[0][1] - 1);
        for (int i = 1; i < edges.length; i++) {
            if (unionFind.find(edges[i][0] - 1) == unionFind.find(edges[i][1] - 1)) {
                res[0] = edges[i][0];
                res[1] = edges[i][1];
            } else {
                unionFind.unionElements(edges[i][0] - 1, edges[i][1] - 1);
            }
        }
        return res;
    }

}
