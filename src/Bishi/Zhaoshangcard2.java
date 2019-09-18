package Bishi;

import java.util.Scanner;

/**
 * @author He.H
 * @date 2019/9/15 20:53
 **/


public class Zhaoshangcard2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] map = new int[n][n];
        for (int i = 0; i < n-1; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            int c = sc.nextInt();
            map[u-1][v-1] = c;
        }


    }

    public static int solve(int i, int[][] map) {
        int ans = 0;


        return ans;
    }
}
