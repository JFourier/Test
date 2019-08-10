package Bishi.BeikeOld;

import java.util.Scanner;

/**
 * @author He.H
 * @date 2019/8/8 18:12
 **/
//贝壳19--开发备用A卷
//有n块磁石组成了一个环，每块的磁力值w[i]，总和为n-1
//使得环断开成为一个链，对于前i块总和小于i/
// 输入第一行一个整数n，第二行n个整数w1-wn
// 输出切开后第一块的编号

public class Beike1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] w = new int[2*n+1];
        for (int i = 1; i < n; i++) {
            w[i+n] = scanner.nextInt();
            w[i] = w[i+n];
        }

        int sum = 0, len = 0;
        for (int i = 1; i <= (n<<1) ; i++) {
            if (sum+w[i] <= len){
                sum+=w[i];
                len++;
            } else {
                sum = 0;
                len = 0;
            }
            if (len == n){
                System.out.println(i-len+1);
                System.exit(0);
            }
        }
        System.out.println("NO SOLUTION");
    }
}
