package Bishi;
/**
 * @author He.H
 * @date 2019/3/26 19:47
 *
 * NxN 网格中左上至右下走两趟，和最大的sum，每一个点最多计入一次
 * 当做俩个人同时在矩阵中走；
 * i1,j1,表示第一个人的位置；
 * i2,j2，表示第二个人的位置；
 * dp[i1][j1][i2][j2]表示俩个人在对应的方格中时候取得的最大的数；
 * 到达i1,j1有(i1-1,j1)(i1,j1-1)俩种状态；
 * 到达i2,j2有(i2-1,j2)(i2,j2-1)俩种状态；
 * 因此dp[i1][j1][i2][j2]就是这四种dp[][][][]里的最大值加上对应maze[i1][j1],maze[i2][j2]中的值即可，
 * 但是，要注意，如果俩个人站在同一个位置，则只加一个maze即可，因为一个人取走后该位置就变为0了
 **/


public class Huya {
    public static void main(String[] args){
        int[][] map = {{1,2,3},{1,2,3},{3,2,1}};
        int res = solve(map);
        System.out.println(res);
    }
    public static int solve(int[][] map){
        int res = 0;
        int n = map[0].length;
        int[][][][] dp = new int[n+1][n+1][n+1][n+1];
        for(int i1=1;i1<=n;i1++) {
            for(int j1=1;j1<=n;j1++) {
                for(int i2=1;i2<=n;i2++) {
                    for(int j2=1;j2<=n;j2++) {
                        dp[i1][j1][i2][j2]=Math.max(Math.max(dp[i1-1][j1][i2-1][j2],dp[i1-1][j1][i2][j2-1]),Math.max(dp[i1][j1-1][i2-1][j2],dp[i1][j1-1][i2][j2-1]));
                        dp[i1][j1][i2][j2]+=map[i1-1][j1-1];
                        if(i1!=i2||j1!=j2)
                            dp[i1][j1][i2][j2]+=map[i2-1][j2-1];
                    }
                }
            }
        }
        res = dp[n][n][n][n];
        return res;
    }
}
