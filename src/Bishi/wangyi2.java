package Bishi;

import java.util.Scanner;

/**
 * @author He.H
 * @date 2019/8/3 15:29
 **/


public class wangyi2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] input = new int[n];
        for (int i = 0; i < n; i++) {
            input[i] = sc.nextInt();
        }

        int[] res = new int[n];
        int maxnum = input[0];
        int j = 0;
        while (j<input.length) {
            if (maxnum < input[j]){
                maxnum = input[j];
            }
            res[j] = maxnum;
            j++;
        }
        for (int i = 0; i < res.length; i++) {
            if (i<res.length-1){
                System.out.print(res[i]);
                System.out.print(" ");
            } else {
                System.out.print(res[res.length-1]);
            }
        }
    }
}
