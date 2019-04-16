package Bishi;

import java.util.Scanner;

/**
 * @author He.H
 * @date 2019/4/11 9:42
 **/


public class Huawei3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[][] map = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                map[i][j] = scanner.nextInt();
            }
        }
        boolean[][] used = new boolean[n][m];
        int X = scanner.nextInt();
        int Y = scanner.nextInt();
        int Z = scanner.nextInt();
        int W = scanner.nextInt();
        int res = dfs(map,used,X,Y,Z,W);
        System.out.print(res);

    }
    public static int dfs(int[][] map, boolean[][] used, int x, int y, int z, int w) {
        if (x == z && y == w) {
            return 1;
        }
        int res = 0;
        used[x][y] = true;
        if (x-1>=0 && map[x-1][y]>map[x][y]) {
            res += dfs(map,used,x-1,y,z,w);
        }
        if (y-1>=0 && map[x][y-1]>map[x][y]) {
            res += dfs(map,used,x,y-1,z,w);
        }
        if (x+1<=map.length-1 && map[x+1][y]>map[x][y]) {
            res += dfs(map,used,x+1,y,z,w);
        }
        if (y+1<=map[0].length-1 && map[x][y+1]>map[x][y]) {
            res += dfs(map,used,x,y+1,z,w);
        }
        used[x][y] = false;
        return res;
    }

}
