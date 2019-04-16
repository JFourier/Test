package Bishi;

import java.util.Scanner;

/**
 * @author He.H
 * @date 2019/4/7 21:23
 **/


public class Tencent3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] in = new int[n];
        for (int i = 0; i < n; i++) {
            in[i] = sc.nextInt();
        }
        option(in,k);
    }
    public static void option(int[] in, int k){
        for (int i = 0; i < k; i++) {
            if(checkZero(in)){
                System.out.println(0);
                continue;
            }
            int min = findMin(in);
            System.out.println(min);
            for (int j = 0; j < in.length; j++) {
                if (in[j] != 0){
                    in[j] -= min;
                }
            }
        }
    }
    public static int findMin(int[] in) {
        int tmp = Integer.MAX_VALUE;
        for (int i = 0; i < in.length; i++) {
            if (in[i] < tmp && in[i] != 0) {
                tmp = in[i];
            }
        }
        return tmp;
    }
    public static boolean checkZero(int[] in) {
        for (int i : in){
            if(i!=0){
                return false;
            }
        }
        return true;
    }
}
