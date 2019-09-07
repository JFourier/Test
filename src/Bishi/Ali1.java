package Bishi;

import java.util.Scanner;

/**
 * @author He.H
 * @date 2019/8/30 18:09
 **/


public class Ali1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] map = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                map[i][j] = sc.nextInt();
            }
        }
        int ans = solve(map);
        System.out.println(ans);
    }
    public static int solve(int[][] map) {
        int ans = 0;
        int n = map.length;
        int m = map[0].length;
        boolean[][] used = new boolean[n][m];
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < m - 1; j++) {
                if (!used[i][j]) {
                    if (map[i][j] == 1 && map[i + 1][j] == 1 && map[i][j + 1] == 1 && map[i + 1][j + 1] == 1) {
                        ans++;
                        used[i][j] = true;
                        used[i + 1][j] = true;
                        used[i][j + 1] = true;
                        used[i + 1][j + 1] = true;
                    }
                }
            }
        }
        return ans;
    }
}
