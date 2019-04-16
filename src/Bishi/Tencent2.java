package Bishi;

import java.util.Scanner;

/**
 * @author He.H
 * @date 2019/4/7 20:40
 **/


public class Tencent2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] pr = new int[n];
        for (int i = 0; i < n; i++) {
            pr[i] = sc.nextInt();
        }
        System.out.println(solve(pr, n));
    }
    public static int solve(int[] in, int n) {
        int res = 0;
        while (!check(in)) {
            int[] re = find(in);
            int P = re[0];
            int N = re[1];
            if(in[P] >= Math.abs(in[N])){
                res += Math.abs(in[N])*(Math.abs(P-N));
                in[P] += in[N];
                in[N] = 0;
                continue;
            }
            if(in[P] < Math.abs(in[N])){
                res += Math.abs(in[P])*(Math.abs(P-N));
                in[N] += in[P];
                in[P] = 0;
                continue;
            }
        }
        return res;
    }
    public static int[] find (int[] in) {
        int[] res = new int[2];
        for (int i = 0; i < in.length; i++) {
            if (in[i]>0) {
                res[0] = i;
                break;
            }
        }
        for (int i = 0; i < in.length; i++) {
            if (in[i]<0) {
                res[1] = i;
                break;
            }
        }
        return res;
    }

    public static boolean check(int[] in){
        for(int i: in) {
            if (i != 0){
                return false;
            }
        }
        return true;
    }
}
