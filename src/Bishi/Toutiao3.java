package Bishi;

import java.util.Scanner;

/**
 * @author He.H
 * @date 2019/6/30 19:53
 **/


public class Toutiao3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] A=new int [n];
        for (int i = 0; i < n; ++i) {
            A[i]=in.nextInt();
        }
        int[] res = new int[A.length];
        for (int i = 0; i < n; ++i) {
            res[i] = solve(A[i]);
        }
        for (int i = 0; i < n; ++i) {
            System.out.println(res[i]);
        }

    }

    public static int solve(int N) {
        if (N<150) {
            return N;
        }
        int max = N/150+1;
        int[][] dp = new int[max][max];
        for (int i = 0; i < max; i++) {
            for (int j = 0; j < max; j++) {
                dp[i][j] = N-i*150-j*200;
            }
        }
        int res = 150;
        for (int i = 0; i < max; i++) {
            for (int j = 0; j < max; j++) {
                if (dp[i][j] == 0){
                    return 0;
                }else if (dp[i][j] < 0) {
                    continue;
                }else {
                    if (dp[i][j]<res) {
                        res = dp[i][j];
                    }
                }
            }
        }
        return res;
    }

    public static int solve2(int N) {
        int res = 0;
        if (N<150) {
            return N;
        }


        return res;

    }
}
