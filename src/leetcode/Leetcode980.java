package leetcode;

/**
 * @author He.H
 * @date 2019/4/11 9:14
 **/


public class Leetcode980 {
    public int uniquePathsIII(int[][] grid) {
        int startI = 0;
        int startJ = 0;
        int needToGo = 1;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    startI =i;
                    startJ =j;
                }
                if (grid[i][j] == 0) {
                    needToGo++;
                }
            }
        }
        return dfs(grid,startI,startJ,needToGo);

    }

    private int dfs(int[][] grid, int i, int j, int needToGo) {
        if (i<0 || i>=grid.length || j<0 || j>=grid[0].length || grid[i][j] == -1) {
            return 0;
        }
        if (grid[i][j] == 2 ) {
            return  needToGo == 0 ? 1 : 0;
        }
        grid[i][j] = -1;
        int res = dfs(grid, i+1, j, needToGo -1) + dfs(grid, i-1, j, needToGo-1)+dfs(grid, i, j+1, needToGo-1)+dfs(grid, i, j-1, needToGo-1);
        grid[i][j] = 0;
        return res;
    }
}
