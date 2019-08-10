package Bishi.BeikeOld;

import java.util.Scanner;

/**
 * @author He.H
 * @date 2019/8/8 21:23
 **/
//贝壳19--开发备用A卷
//河中有无限块石头，只能看见前两块。每块石头熵有一个数字f(i),对于i>2,f(i) = abs(f(i-1)-f(i-2))。
// 河流中一共有多少不同的数字。
// 输入为两个整数，表示前两位。3 5
// 输出整数，无穷则输出-1。 5

public class Beike2 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int ans = 0;

        if (a<b) {
            int tmp = a;
            a = b;
            b = tmp;
        }

        int c = a%b;
        while (c>0){
            ans += a/b;
            a = b;
            b = c;
            c = a % b;
        }
        ans += a/b;
        ans++;
        System.out.println(ans);
    }

    public static void swap(int a, int b) {
        int tmp = a;
        a = b;
        b = tmp;
    }
}
