package Bishi;

import java.util.Scanner;

/**
 * @author He.H
 * @date 2019/8/25 16:27
 **/


public class Kuaishou4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[][] map = new int[n][n];
        for (int i = 0; i < n-1; i++) {
           int n1 = sc.nextInt()-1;
           int n2 = sc.nextInt()-1;
           int value = sc.nextInt();
           if (value == 1) {
               map[n1][n2] = 1;
               map[n2][n1] = 1;
           }else {
               map[n1][n2] = -1;
               map[n2][n1] = -1;
           }
        }


        System.out.println((Math.pow(n,k)-n)%(Math.pow(10,9)+7));
    }

    public static void findPath(int[][] graph, int start, int end, int[] used) {

    }
}
