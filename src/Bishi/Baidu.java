package Bishi;

import java.util.Scanner;

/**
 * @author He.H
 * @date 2019/4/2 20:15
 **/


public class Baidu {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String A = scanner.nextLine();
        String B = scanner.nextLine();
        int Q = scanner.nextInt();
        int[][] in = new int[Q][2];
        for (int i = 0; i < Q; i++) {
            for (int j = 0; j < 2; j++) {
                in[i][j] = scanner.nextInt();
            }
        }
        int[] res = new int[Q];
        for (int i = 0; i < Q; i++) {
            res[i] = solve(A,B,in[i][0],in[i][1]);
        }
        for (int i: res){
            System.out.println(i);
        }
    }
    public static int solve(String A, String B, int l, int r) {
        int res = 0;
        String tmp = A.substring(l-1,r);
        for (int i = 0; i <= tmp.length()-B.length(); i++) {
            if(helper(tmp.substring(i,i+B.length()),B)){
                res++;
            }
        }
        return res;
    }
    public static boolean helper(String A, String B){
        return (A.equals(B));
    }
}
