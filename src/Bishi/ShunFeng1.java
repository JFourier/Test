package Bishi;

import java.util.Scanner;

/**
 * @author He.H
 * @date 2019/8/29 18:51
 **/


public class ShunFeng1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int k = sc.nextInt();
        int[][] input = new int[k][2];
        for (int i = 0; i < k; i++) {
            for (int j = 0; j < 2; j++) {
                input[i][j] = sc.nextInt()-1;
            }
        }
        int[][] map = new int[n][n];
        for (int i = 0; i < k; i++) {
            for (int j = i; j < k-1; j++) {
                if (input[i][1] == input[j][1]) {
                    map[i][j] = 1;
                    map[j][i] = 1;
                }
            }
        }
        int ans = findCircleNum(map);
        System.out.println(ans-1);
    }

    public static void dfs(int[][] M, int[] visited, int i) {
        for (int j = 0; j < M.length; j++) {
            if (M[i][j] == 1 && visited[j] == 0) {
                visited[j] = 1;
                dfs(M, visited, j);
            }
        }
    }
    public static int findCircleNum(int[][] M) {
        int[] visited = new int[M.length];
        int count = 0;
        for (int i = 0; i < M.length; i++) {
            if (visited[i] == 0) {
                dfs(M, visited, i);
                count++;
            }
        }
        return count;
    }
}
