package leetcode;

/**
 * @author He.H
 * @date 2019/4/24 20:17
 **/


public class Leetcode329 {
    int m, n;
    int [][] visited;

    public int longestIncreasingPath(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        m = matrix.length;
        n = matrix[0].length;
        int res = 1;
        visited = new int[m][n];
        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                if (visited[i][j] != 0) {
                    continue;
                }
                res = Math.max(res, dfs(matrix, i, j, Integer.MIN_VALUE));
            }
        }
        return res;
    }

    private int dfs(int[][] matrix, int i, int j, int oldVal){
        if (i < 0 || i >= m || j < 0 || j >= n || matrix[i][j] <= oldVal) {
            return 0;
        }
        if (visited[i][j] == 0){
            int curVal = matrix[i][j];
            int up = dfs(matrix, i + 1, j, curVal);
            int down = dfs(matrix, i - 1, j, curVal);
            int right = dfs(matrix, i, j + 1, curVal);
            int left = dfs(matrix, i, j - 1, curVal);
            visited[i][j] = 1 + Math.max(Math.max(up, down), Math.max(right, left));
        }
        return visited[i][j];
    }
}
