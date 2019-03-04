package leetcode;

/**
 * 对角线遍历
 *
 * @author He.H
 * @date 2018/12/29 15:45
 **/


public class Leetcode498 {
    public int[] findDiagonalOrder(int[][] matrix) {
        if(matrix.length == 0){
            return new int[]{};
        }
        int m = matrix.length;
        int n = matrix[0].length;
        int r = 0;
        int c = 0;
        int[] nums = new int[m * n];
        for (int i=0;i< nums.length;i++) {
            nums[i] = matrix[r][c];
            // 决定方向
            // 斜向下
            if ((r + c) % 2 == 0) {
                if (c == n - 1) { // 元素在最后一列，往下走
                    r++;
                } else if (r == 0) { // 元素在第一行，往右走
                    c++;
                } else { // 其他情况，往右上走
                    r--;
                    c++;
                }
            } else {
                if (r == m - 1) { //元素在最后一行，往右走
                    c++;
                } else if (c == 0) { // //元素在第一列，往下走
                    r++;
                } else { //其他情况，往左下走
                    r++;
                    c--;
                }
            }
        }
        return nums;
    }
}
