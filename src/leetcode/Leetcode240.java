package leetcode;

/**
 * @author He.H
 * @date 2019/1/8 19:40
 *
 * 先从左上角判断
 **/


public class Leetcode240 {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix.length==0 || matrix[0].length==0) return false;
        int i=0, j=matrix[0].length-1;
        while(i<matrix.length && j>=0) {
            int x = matrix[i][j];
            if(target == x) return true;
            else if(target < x) --j;
            else ++i;
        }
        return false;
    }
}
