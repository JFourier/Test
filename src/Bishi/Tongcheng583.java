package Bishi;

import java.util.Scanner;

/**
 * @author He.H
 * @date 2019/9/12 20:39
 **/


public class Tongcheng583 {
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
        System.out.println(solve(map));
    }

    public static int solve(int[][] map) {
        int m = map.length;
        int n = map[0].length;
        for(int i = 1; i < m; i++){
            map[i][0] += map[i-1][0];
        }
        for(int i = 1; i < n; i++){
            map[0][i] +=map[0][i-1];
        }
        for(int i = 1; i < m; i++){
            for(int j = 1; j < n; j++){
                map[i][j] += Math.min(map[i-1][j], map[i][j-1]);
            }
        }
        return map[m-1][n-1];
    }
}
