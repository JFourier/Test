package Bishi;

import java.util.Scanner;

/**
 * @author He.H
 * @date 2019/9/12 20:15
 **/


public class Tongcheng581 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str=sc.nextLine();
        String[] chars=str.split(",");
        int n = solve(chars);
        System.out.println(n);

    }

    static int solve(String  C[]) {
        int i = 0;
        int j;
        int n = C.length;
        if (n <=1 ) return n;
        for (j = 1; j < n; j++) {
            if (!C[j] .equals(C[i]) ) {
                C[++i] = C[j];
            }
        }
        return i+1;
    }
}