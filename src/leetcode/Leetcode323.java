package leetcode;

/**
 * @author He.H
 * @date 2019/8/10 9:54
 **/

//Given n nodes labeled from 0 to n - 1 and a list of undirected edges (each edge is a pair of nodes),
// write a function to find the number of connected components in an undirected graph.
// 找出连通子图的数量
// input:[[1,2][0,1][3,4]]; output:2

public class Leetcode323 {

    //并查集来标记图的连通分量。
    private int root(int[] roots, int i) {
        while (roots[i] != i) i = roots[roots[i]];
        return i;
    }
    public int countComponents(int n, int[][] edges) {
        int count = n;
        int[] roots = new int[n];
        for(int i=0; i<n; i++) {
            //初始化
            roots[i] = i;
        }
        for(int i=0; i<edges.length; i++) {
            int r1 = root(roots, edges[i][0]);
            int r2 = root(roots, edges[i][1]);
            if (r1 != r2) {
                roots[r2] = r1;
                count --;
            }
        }
        return count;
    }
}
