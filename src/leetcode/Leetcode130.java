package leetcode;

/**
 * @author He.H
 * @date 2019/8/17 16:19
 **/


public class Leetcode130 {
    public void solve(char[][] board) {
        if (board == null || board.length<3 || board[0].length<3) {
            return;
        }
        int row = board.length;
        int col = board[0].length;

        for (int i = 0; i <row ; i++) {
            dfs(board,i,0,row,col);
            dfs(board,i,col-1,row,col);
        }

        for (int i = 0; i <col ; i++) {
            dfs(board,0,i,row,col);
            dfs(board,row-1,i,row,col);
        }

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (board[i][j] == 'O')
                    board[i][j] = 'X';
                if (board[i][j] == '#')
                    board[i][j] = 'O';
            }
        }

    }

    private static void dfs(char[][] board, int i, int j, int row, int col) {
        if (i<0 || j<0 || i>=row || j>= col || board[i][j]!='O') {
            return;
        }
        board[i][j] = '#';
        dfs(board,i-1, j, row, col);
        dfs(board,i+1, j, row, col);
        dfs(board,i, j-1, row, col);
        dfs(board,i, j+1, row, col);
    }

    public static void main(String[] args) {
        Leetcode130 test = new Leetcode130();
        char[][] board = {{'X','X','X'},{'X','O','X'},{'X','X','X'}};
        test.solve(board);
        for (int i = 0; i < 3; i++) {
            System.out.println(board[i]);
        }

    }
}
