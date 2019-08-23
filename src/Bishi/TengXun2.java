package Bishi;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author He.H
 * @date 2019/8/17 19:49
 **/


public class TengXun2 {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = Integer.valueOf(scanner.nextLine().split(" ")[0]);

        int a[][] = new int[2*T][2];
        ArrayList<ArrayList<String>> input = new ArrayList<ArrayList<String>>();
        for(int i = 0;i < T;i++){
            String[] wh = scanner.nextLine().split(" ");
            int w = Integer.valueOf(wh[0]);
            int h = Integer.valueOf(wh[1]);
            input.add(new ArrayList<String>());
            for(int j = 0;j != w;j++){
                input.get(i).add(scanner.nextLine());
            }
            String[] aString = scanner.nextLine().split(" ");
            a[2*i][0] = Integer.valueOf(aString[0]);
            a[2*i][1] = Integer.valueOf(aString[1]);
            String[] bString = scanner.nextLine().split(" ");
            a[2*i+1][0] = Integer.valueOf(bString[0]);
            a[2*i+1][1] = Integer.valueOf(bString[1]);
        }

        for (int i = 0; i < T ; i++) {
            if (i<T-1){
                if (solve(input.get(i), a[2*i], a[2*i+1])) {
                    System.out.println("YES");
                } else {
                    System.out.println("NO");
                }
            }else {
                if (solve(input.get(i), a[2*i], a[2*i+1])){
                    System.out.print("YES");
                } else {
                    System.out.print("NO");
                }

            }

        }
    }


    public static boolean solve(ArrayList<String> input, int[] start, int[] end) {
        int n = input.size();
        int m = input.get(0).length();
        int[][] board= new int[n][m];
        for (int i = 0; i < n; i++) {
            char[] tmp = input.get(i).toCharArray();
            for (int j = 0; j < m; j++) {
                if (tmp[j]=='.') {
                    board[i][j] = 2;
                } else if (tmp[j] == 'X'){
                    board[i][j] = 1;
                }
            }
        }
        return dfs(board, start[0], start[1]-1, end[0]-1, end[1]-1, start[0]-1, start[1]-1);

    }
    public static boolean dfs(int[][] board, int si, int sj, int ei, int ej, int i, int j) {
        if (i<0 || j<0 || i>=board.length || j>=board[0].length || board[i][j]<=0) {
            return false;
        }

        board[i][j]--;
        if (i == ei && j == ej && board[i][j] == 0) {
            return true;
        }

        boolean res1 = dfs(board, si, sj, ei, ej, i+1, j);
        boolean res2 = dfs(board, si, sj, ei, ej, i-1, j);
        boolean res3 = dfs(board, si, sj, ei, ej, i, j+1);
        boolean res4 = dfs(board, si, sj, ei, ej, i, j-1);
        board[i][j]++;
        return (res1 || res2 || res3 || res4);
    }
}
