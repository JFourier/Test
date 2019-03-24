package Bishi;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author He.H
 * @date 2019/3/17 20:21
 **/


public class ZhaoYin2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] l = new int[n];
        int[] d = new int[n];
        for (int i = 0; i < n; i++) {
            l[i] = in.nextInt();
        }
        for (int i = 0; i < n; i++) {
            d[i] = in.nextInt();
        }
        ArrayList<Integer[]> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            Integer[] tmp = new Integer[2];
            tmp[0] = l[i];
            tmp[1] = d[i];
            list.add(tmp);
        }
        list.sort((Integer[] a, Integer[] b) -> a[1] - b[1]);


    }
}
