package Bishi;

import java.util.*;

/**
 * @author He.H
 * @date 2019/4/13 9:08
 **/


public class Graph {
    private final int V;
    private int E;
    private HashSet<Integer>[] adj;

    public Graph(int V) {
        if (V < 0) throw new IllegalArgumentException("Number of vertices must be nonnegative");
        this.V = V;
        this.E = 0;
        adj = (HashSet<Integer>[]) new HashSet[V];
        for (int v = 0; v < V; v++) {
            adj[v] = new HashSet();
        }
    }

    public Graph(int[][] edges) {
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

    public Graph(Graph G) {
        this(G.V());
        this.E = G.E();
        for (int v = 0; v < G.V(); v++) {
            // reverse so that adjacency list is in same order as original
            Stack<Integer> reverse = new Stack<Integer>();
            for (int w : G.adj[v]) {
                reverse.push(w);
            }
            for (int w : reverse) {
                adj[v].add(w);
            }
        }
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
