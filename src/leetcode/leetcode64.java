package leetcode;

/**
 * DP
 *
 * @author He.H
 * @date 2019/3/14 9:21
 **/


public class leetcode64 {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        for(int i = 1; i < m; i++){
            grid[i][0] += grid[i-1][0];
        }
        for(int i = 1; i < n; i++){
            grid[0][i] +=grid[0][i-1];
        }
        for(int i = 1; i < m; i++){
            for(int j = 1; j < n; j++){
                grid[i][j] += Math.min(grid[i-1][j], grid[i][j-1]);
            }
        }
        return grid[m-1][n-1];
    }
//先处理最左边和最上边两条边，因为只有一条路。接下来每一点的值等于它上边和左边的较小值加上该点的数值~即为到达该点的最短路径
}
