/**
 * @author He.H
 * @date 2019/1/3 20:09
 **/


public class Leetcode529 {
    public char[][] updateBoard(char[][] board, int[] click) {
        if(board == null || board.length == 0)
            return board;
        int x = click[0], y = click[1];
        if(board[x][y] == 'M'){
            board[x][y] = 'X';
            return board;
        }

        dfs(board, x, y);
        return board;
    }

    private void dfs(char[][] board, int x, int y) {
        //判断给定的坐标点是否在二维数组界限内
        if(x < 0 || y < 0 || x >= board.length || y >= board[0].length || board[x][y] != 'E')
            return;
        //记录八邻域内有多少个炸弹
        int count = 0;
        //查看当前点的八邻域有多少个炸弹
        for(int i = -1 ; i < 2; i++)
            for (int j = -1; j < 2; j++) {
                if (x + i < 0 || x + i >= board.length || j + y < 0 || y + j >= board[0].length) continue;
                //记录炸弹的个数
                if (board[x + i][y + j] == 'M' || board[x + i][y + j] == 'X') count++;
            }
        //如果当前节点八邻域内没有炸弹，则将该节点的值设置为`B`
        if(count == 0) {
            board[x][y] = 'B';
            for(int i = -1 ; i < 2; i++) {
                for(int j = -1; j < 2; j++) {
                    dfs(board, x + i, y + j);
                }
            }
        }else {
            board[x][y] = (char)('0' + count);
        }
    }
}
