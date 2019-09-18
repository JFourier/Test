package Bishi;

import java.util.Scanner;

/**
 * @author He.H
 * @date 2019/9/15 21:08
 **/


public class Zhaoshangcard1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n+1];
        for (int i = 0; i <= n ; i++) {
            a[i] = sc.nextInt();
        }
        int[] b = new int[n+1];
        b[0] = 0;
        for (int i = 0; i < n; i++) {
            b[i+1] = sc.nextInt();
        }

        int ans = solve(a,b,n);
        System.out.println(ans);
    }

    public static int solve(int[] a, int[] b, int n) {
        int ans = 0;
        for (int i = 1; i <= n; i++) {
            if (b[i] >= a[i-1]) {
                b[i] -= a[i-1];
                ans += a[i-1];
                a[i-1] = 0;
                if (b[i] > 0) {
                    if (b[i]>= a[i]) {
                        ans += a[i];
                        b[i] -=a[i];
                        a[i] = 0;
                    } else {
                        a[i] -= b[i];
                        ans += b[i];
                    }
                }
            } else {
                ans += b[i];
                b[i] = 0;
            }
        }

        return ans;
    }
}
