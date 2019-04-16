package Bishi;

import java.util.Scanner;

/**
 * @author He.H
 * @date 2019/4/7 20:07
 **/


public class Tencent1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        System.out.println(solve(n,k));
    }
    public static int solve(int n, int k){
        int res = 0;
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        if (k == 0) {
            return n;
        }
        while (n > 1) {
            if (n % 2 == 0 && k > 0) {
                n = n/2;
                res++;
                k--;
            } else {
                n = n - 1;
                res++;
            }
        }
        if (n == 1) {
            res++;
        }
        return res;
    }
}
