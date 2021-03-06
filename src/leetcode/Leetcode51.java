package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * N queen
 *
 * @author He.H
 * @date 2019/1/23 20:20
 **/


public class Leetcode51 {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        int[] queenList = new int[n]; //第i个位置存放的数表示i行时，Q的列，int[2]=3表示在Q放在第3行的第4列
        placeQueen(queenList, 0, n, res); //在第0行放Q
        return res;
    }

    private void placeQueen(int[] queenList, int row, int n, List<List<String>> res) {
        //如果已经填满，就生成结果
        if (row == n) {
            ArrayList<String> list = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                StringBuilder str = new StringBuilder();
                for (int col = 0; col < n; col++) {
                    if (queenList[i] == col) {
                        str.append("Q");
                    } else {
                        str.append(".");
                    }
                }
                list.add(str.toString());
            }
            res.add(list);
        }
        for (int col = 0; col < n; col++) { //循环每一列
            if (isValid(queenList, row, col)) { //如果在该列放入Q不冲突的话
                queenList[row] = col;
                placeQueen(queenList, row + 1, n, res);
            }
        }
    }

    private boolean isValid(int[] queenList, int row, int col) {
        for (int i = 0; i < row; i++) {
            int pos = queenList[i];
            if (pos == col) { //和新加入的Q处于同一列
                return false;
            }
            if (pos - i == col - row) { //在新加入的Q的右对角线上
                return false;
            }
            if (pos + i == col + row) { //在新加入的Q的左对角线上
                return false;
            }
        }
        return true;
    }
}

class GIest{
    public static void main(String[] args) {
        long STARTTIME = System.currentTimeMillis();
        Leetcode51 test = new Leetcode51();
        List<List<String>> result = test.solveNQueens(4);
        long ENDTIME = System.currentTimeMillis();
        System.out.println(result.size());
        System.out.println((ENDTIME- STARTTIME)+"ms");

    }
}
