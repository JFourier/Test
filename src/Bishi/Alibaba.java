package Bishi;

import java.util.Stack;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author He.H
 * @date 2019/4/12 19:52
 **/

public class Alibaba {
    public static void main(String[] args) {
        int[][] edges = new int[10][10];
        edges[0][1] = 1;
        edges[0][2] = 1;
        edges[1][3] = 1;
        edges[1][4] = 1;
        edges[2][5] = 1;
        edges[2][6] = 1;
        edges[6][7] = 1;
        edges[5][7] = 1;
        int start = 0;
        int end = 5;

        Graph1 graph = new Graph1(edges);

        boolean[] marked = new boolean[10];
        int[] edgeTo = new int[10];

        BFS(graph, start, end, edgeTo, marked);

        if (!hasPathTo(marked,end)) {
            System.out.println(0);
        }
        Stack<Integer> path = pathTo(edgeTo, start, end);
        System.out.println(path.size()-1);
    }

    public static Stack<Integer> pathTo(int[] pathTo, int start, int end) {
        Stack<Integer> path = new Stack<>();
        for (int x = end; x != start; x = pathTo[x]) {
            path.push(x);
        }
        path.push(start);
        return path;
    }

    public static boolean hasPathTo(boolean[] marked, int v) {
        return marked[v];
    }

    public static void BFS(Graph1 graph, int start, int end, int[]edgeTo, boolean[] marked) {
        Queue<Integer> queue = new LinkedList();
        marked[start] = true;
        queue.add(start);
        outloop : while(!queue.isEmpty()) {
            int v = queue.poll();
            for(int w : graph.adj(v)) {
                if (!marked[w]) {
                    edgeTo[w] = v;
                    marked[w] = true;
                    if (w == end) {
                        //找到终点，立即跳出
                        break outloop;
                    }
                    queue.add(w);
                }
            }
        }
    }


    public static void DFS(Graph1 graph, int start, int end, int[]edgeTo, boolean[] marked) {
        marked[start] = true;
        outloop : for (int w : graph.adj(start)) {
            if (!marked[w]) {
                edgeTo[w] = start;
                if (w == end) {
                    break outloop;
                }
                DFS(graph, w, end, edgeTo, marked);
            }
        }
    }
}

class Graph1{
    private final int V;
    private int E;
    private HashSet<Integer>[] adj;

    public Graph1(int V) {
        this.V = V;
        this.E = 0;
        adj = (HashSet<Integer>[]) new HashSet[V];
        for (int v = 0; v < V; v++) {
            adj[v] = new HashSet();
        }
    }

    public Graph1(int[][] edges) {
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

    public int V() {
        return V;
    }
    public int E() {
        return E;
    }
    public Iterable<Integer> adj(int v) {
        return adj[v];
    }

    public int degree(int v) {
        return adj[v].size();
    }

    public void addEdge(int v, int w) {
        adj[v].add(w);
        adj[w].add(v);
    }
}

