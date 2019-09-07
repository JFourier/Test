package Bishi;

import java.util.Scanner;

/**
 * @author He.H
 * @date 2019/8/23 20:02
 **/


public class WMSJ2 {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        String i = in.nextLine();
        String[] h = i.split(" ");
        int n = h.length;
        int[][] graph = new int[n][n];
        for (int j = 0; j < n; j++) {
            graph[0][j] = Integer.parseInt(h[j]);
        }
        for (int j = 1; j < n; j++) {
            for (int k = 0; k < n; k++) {
                graph[j][k] = in.nextInt();
            }
        }

        for (int j = 0; j < n; j++) {
            for (int k = 0; k < n; k++) {
                if (graph[j][k] == -1) {
                    graph[j][k] = Integer.MAX_VALUE;
                }
            }
        }

        int[] dis = new int[n];
        boolean[] visited = new boolean[n];
        visited[0] = true;
        for (int j = 0; j < n; j++) {
            dis[j] = graph[0][j];
        }
        solve(graph, dis, visited);
        for (int j = 1; j < n; j++) {
            System.out.println(dis[j]);
        }
    }

    public static void  solve(int[][] graph,int[] dis,boolean[] visited){
        while(true){
            int min=Integer.MAX_VALUE;
            int index=-1;
            for(int i=0;i<dis.length;i++){
                if(visited[i])
                    continue;
                else{
                    if(dis[i]<min){
                        index=i;
                        min=dis[i];
                    }
                }
            }
            if(index==-1) break;
            visited[index]=true;
            for(int i=0;i<graph.length;i++){
                if(graph[index][i]!=Integer.MAX_VALUE){
                    dis[i]=dis[i]<(min+graph[index][i])?dis[i]:min+graph[index][i];
                }
            }
        }
    }

}
