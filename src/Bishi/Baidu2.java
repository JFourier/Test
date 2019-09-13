package Bishi;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author He.H
 * @date 2019/9/10 19:32
 **/


public class Baidu2 {
    static class Money {
        int ant;
        int cnt;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        Money[] b = new Money[n];
        for(int i = 0; i < n; ++i) {
            b[i] = new Money();
            b[i].ant = sc.nextInt();
            b[i].cnt = sc.nextInt();
        }
        Arrays.sort(b, (b1, b2) -> {return b1.ant == b2.ant ? b1.cnt-b2.cnt : b2.ant - b1.ant;});
        int flag = 0;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (b[i].ant < m) continue;
            ans += b[i].cnt;
            flag = i;
        }

    }
}
