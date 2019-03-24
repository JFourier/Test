package Bishi;

import java.util.Scanner;

/**
 * @author He.H
 * @date 2019/3/17 20:04
 **/


public class ZhaoYin {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] min = new int[3];
        int[] max = new int[3];
        for (int i = 0; i < 3; i++) {
            min[i] = in.nextInt();
            max[i] = in.nextInt();
        }
        int[] res = {min[0], min[1], min[2]};
        while (sum(res)<n) {
            if (res[0]<max[0]){
                res[0]++;
            } else if (res[1]< max[1]) {
                res[1]++;
            }else if (res[2]< max[2]){
                res[2]++;
            }
        }
        for (int i : res) {
            System.out.print(i+" ");
        }
    }

    public static int sum(int[] tmp) {
        int res = 0;
        for (int i: tmp) {
            res += i;
        }
        return res;
    }
}
