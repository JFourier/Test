/**
 * @author He.H
 * @date 2018/12/29 16:10
 **/


public class Leetcode566 {
    public int[][] matrixReshape(int[][] nums, int r, int c) {
        int ro = nums.length;
        int rc = nums[0].length;
        if (ro * rc != r * c )
            return nums;
        int tr=0;
        int tc=0;
        int[][] res=new int[r][c];
        for (int i = 0; i < ro; i++) {
            for (int j = 0; j < rc; j++) {
                res[tr][tc]=nums[i][j];
                tc++;
                if (tc==c){
                    tc=0;
                    tr++;
                    if (tr==r){
                        tr=0;
                    }
                }
            }
        }
        return res;
    }
}
