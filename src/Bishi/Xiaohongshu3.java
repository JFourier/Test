package Bishi;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * @author He.H
 * @date 2019/9/3 19:36
 **/


public class Xiaohongshu3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[][] map = new String[n][n];
        for (int i = 0; i < n; i++) {
            String tmp = sc.nextLine();
            map[i] = tmp.trim().split("");
        }
        int row0 = 0, col0 = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] == "S") {
                    row0 = i;
                    col0 = j;
                }
            }
        }
        int ans = 1;
        boolean[][] used = new boolean[n][n];
        used[row0][col0] = true;
        int[][] flag = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                flag[i][j] = Integer.MAX_VALUE;
            }
        }
        flag[row0][col0] = 1;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{row0,col0});
        while (!queue.isEmpty()) {
            int[] tmp = queue.poll();
            int r = tmp[0];
            int c = tmp[1];
            if (map[r][c] == "E" || map[r][c] == "S") break;
            if (map[r][c] == "#") continue;
            ArrayList<int[]> neighber = getNeighber(r,c,n);
            for (int[] point: neighber) {
                queue.add(point);
                int i = point[0];
                int j = point[1];
                if (map[i][j] == "#") {
                    continue;
                }
                flag[i][j] = Math.min(Math.min(flag[(i-1+n)%n][j], flag[(i+1)%n][j]), Math.min(flag[i][(j-1+n)%n], flag[i][(j+1)%n])) +1;
            }
        }

        int row1 = 0, col1 = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] == "E") {
                    row1 = i;
                    col1 = j;
                }
            }
        }
        ans = flag[row1][col1] == Integer.MAX_VALUE? -1: flag[row1][col1]+1;
        System.out.println(ans);
    }

    public static ArrayList<int[]> getNeighber(int r, int c, int n) {
        ArrayList<int[]> res = new ArrayList<>();
        int i = (r-1+n)%n;
        int ii = (r+1)%n;
        int j = (c-1+n)%n;
        int jj = (c+1)%n;
        res.add(new int[]{i,c});
        res.add(new int[]{ii,c});
        res.add(new int[]{r,j});
        res.add(new int[]{r,jj});
        return res;
    }
}
