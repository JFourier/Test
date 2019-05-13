package Bishi;

import java.util.Scanner;

/**
 * @author He.H
 * @date 2019/4/24 19:26
 **/


public class san60No2 {
    /*请完成下面这个函数，实现题目要求的功能
当然，你也可以不按照下面这个模板来作答，完全按照自己的想法来 ^-^
******************************开始写代码******************************/
    static int longpath(int[][] matrix) {
        if(matrix.length ==0 || matrix[0].length == 0)
            return 0;
        boolean[][] visited = new boolean[matrix.length][matrix[0].length];
        int[][] len = new int[matrix.length][matrix[0].length];
        int max = 0;

        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                max = Math.max(max,find(matrix,visited,len,i,j));
            }
        }
        return max;

    }
    /******************************结束写代码******************************/
    private static int[] row = {-1,1,0,0};
    private static int[] col = {0,0,-1,1};
    private static int find(int[][] matrix,boolean[][] visited,int[][] len,int x,int y){
        if(visited[x][y])
            return len[x][y];
        len[x][y] = 1;
        for(int i=0;i<4;i++){
            int curX = x + row[i];
            int curY = y + col[i];
            if(curX >=0 && curX < matrix.length && curY >=0 && curY<matrix[0].length && matrix[curX][curY] < matrix[x][y]){
                len[x][y] = Math.max(len[x][y],find(matrix,visited,len,curX,curY)+1);
            }
        }
        visited[x][y] = true;
        return len[x][y];
    }

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int res;

        int _matrix_rows = 0;
        int _matrix_cols = 0;
        _matrix_rows = Integer.parseInt(in.nextLine().trim());
        _matrix_cols = Integer.parseInt(in.nextLine().trim());

        int[][] _matrix = new int[_matrix_rows][_matrix_cols];
        for(int _matrix_i=0; _matrix_i<_matrix_rows; _matrix_i++) {
            for(int _matrix_j=0; _matrix_j<_matrix_cols; _matrix_j++) {
                _matrix[_matrix_i][_matrix_j] = in.nextInt();

            }
        }

        if(in.hasNextLine()) {
            in.nextLine();
        }

        res = longpath(_matrix);
        System.out.println(String.valueOf(res));

    }
}
