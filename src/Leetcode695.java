/**
 * 最大联通子图
 *
 * @author He.H
 * @date 2018/12/26 10:56
 **/


public class Leetcode695 {
    private static int m, n;
    private static int[][] direction = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    public static int maxAreaOfIsland(int[][] grid) {
        if (grid == null || grid.length ==0) {
            return 0;
        }
        m = grid.length;
        n = grid[0].length;
        int maxArea = 0;
        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                maxArea = Math.max(maxArea, dfs(grid, i, j));
            }
        }
        return maxArea;
    }

    private  static int dfs(int[][] grid, int r, int c){
        if(r < 0 || r >= m || c < 0 || c >= n || grid[r][c] == 0){
            return 0;
        }
        //将当前搜索点置为0， 避免重复搜索
        grid[r][c] = 0;
        int area = 1;
        for (int[] d : direction){
            area += dfs(grid, r + d[0], c + d[1]);
        }
        return area;
    }
    public static void main(String[] args){
        int[][] island = {{0,0,1,0,0,0,0,1,0,0,0,0,0}, {0,0,0,0,0,0,0,1,1,1,0,0,0}, {0,1,1,0,1,0,0,0,0,0,0,0,0},
                {0,1,0,0,1,1,0,0,1,0,1,0,0}, {0,1,0,0,1,1,0,0,1,1,1,0,0}, {0,0,0,0,0,0,0,0,0,0,1,0,0},
                {0,0,0,0,0,0,0,1,1,1,0,0,0}, {0,0,0,0,0,0,0,1,1,0,0,0,0}};
        int res = maxAreaOfIsland(island);
        System.out.println(res);
    }
}
