package Bishi;

import java.util.Scanner;

/**
 * @author He.H
 * @date 2019/8/3 14:53
 **/


public class wangyi1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int ans = 0;
        int min = n<m?n:m;

        for (int i = min; i >=1 ; i--) {
            if (n%i==0 && m%i==0){
                ans = i;
                break;
            }
        }
        System.out.println(ans);
    }
}
