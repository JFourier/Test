package Bishi;

import java.util.Scanner;

/**
 * @author He.H
 * @date 2019/8/27 19:36
 **/


public class Didi1 {
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
    public static int solve(int[][] nums) {
        int ans = 0;
        for (int i = 0; i < nums[0].length; i++) {
            int tmp = 0;
            for (int j = 0; j < nums.length; j++) {
                tmp = Math.max(tmp, nums[j][i]);
            }
            ans += tmp;
        }
        return ans;
    }
}
