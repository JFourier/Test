package Bishi;

import java.util.*;

/**
 * @author He.H
 * @date 2019/4/13 19:43
 **/


public class Jingdong {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
//        int[][] nodes = new int[n][2];
//        for (int i = 0; i < n-1; i++) {
//            for (int j = 0; j < 2; j++) {
//                nodes[i][j] = scanner.nextInt();
//            }
//        }
//
//        for (int i = 0; i < n; i++) {
//            edges[nodes[i][0]][nodes[i][1]] = 1;
//            edges[nodes[i][1]][nodes[i][0]] = 1;
//        }
        int[][] edges = new int[n+1][n+1];
        while (scanner.hasNextInt()) {
            int row = scanner.nextInt();
            int col = scanner.nextInt();
            edges[row][col] = 1;
            edges[col][row] = 1;
        }

        Graph11 graph = new Graph11(edges);

        int start = 1;
        int end = 10000;
        boolean[] marked = new boolean[n+1];
        int[] edgeTo = new int[n+1];

        BFS(graph, start, end, edgeTo, marked);

        int res = 0;
        for (int i = 2; i <= n ; i++) {
            if (hasPathTo(marked,i)) {
                res = Math.max(res, pathTo(edgeTo, start, i));
            }
        }
        System.out.println(res);
    }

    public static int pathTo(int[] pathTo, int start, int end) {
        Stack<Integer> path = new Stack<>();
        for (int x = end; x != start; x = pathTo[x]) {
            path.push(x);
        }
        path.push(start);
        return path.size();
    }

    public static boolean hasPathTo(boolean[] marked, int v) {
        return marked[v];
    }

    public static void BFS(Graph11 graph, int start, int end, int[]edgeTo, boolean[] marked) {
        Queue<Integer> queue = new LinkedList();
        marked[start] = true;
        queue.add(start);
        outloop : while(!queue.isEmpty()) {
            int v = queue.poll();
            for(int w : graph.adj(v)) {
                if (!marked[w]) {
                    edgeTo[w] = v;
                    marked[w] = true;
                    queue.add(w);
                }
            }
        }
    }
}

class Graph11{
    private final int V;
    private int E;
    private HashSet<Integer>[] adj;

    public Graph11(int V) {
        this.V = V;
        this.E = 0;
        adj = (HashSet<Integer>[]) new HashSet[V];
        for (int v = 0; v < V; v++) {
            adj[v] = new HashSet();
        }
    }

    public Graph11(int[][] edges) {
        this.V = edges.length;
        this.E = 0;
        adj = (HashSet<Integer>[]) new HashSet[V];
        for (int v = 0; v < V; v++) {
            adj[v] = new HashSet<Integer>();
        }
        for (int i = 0; i < edges.length; i++) {
            for (int j = i; j < edges[0].length; j++) {
                if (edges[i][j] == 1) {
                    E++;
                    addEdge(i,j);
                }
            }
        }
    }
    public Iterable<Integer> adj(int v) {
        return adj[v];
    }

    public void addEdge(int v, int w) {
        adj[v].add(w);
        adj[w].add(v);
    }
}


