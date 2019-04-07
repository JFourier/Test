package Bishi;

import java.util.Scanner;

/**
 * @author He.H
 * @date 2019/4/7 14:14
 **/


public class WangYi {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        double x = scanner.nextFloat();
        double y = scanner.nextFloat();
        System.out.println(solve(x,y));
    }
    public static int solve(double x, double y) {
        int res = 0;
        for (double i = 0; i < x; i++) {
            for (double j = 0; j < y ; j++) {
                if (check(i,j,y/x));
                res++;
            }
        }

        return res;
    }

    public static boolean check(double x, double y, double k){
        if (k*x>=y && k*x<y+1){
            return true;
        }
        if (k*x<=y && k*(x+1)>y){
            return true;
        }
        return false;
    }
}
