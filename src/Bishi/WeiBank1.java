package Bishi;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * @author He.H
 * @date 2019/9/19 16:38
 **/


public class WeiBank1 {
    public static void main(String[] args) {
        BigInteger num = new BigInteger("1");
        Scanner sc = new Scanner(System.in);
        int input = sc.nextInt();
        if (input == 0 || input == 1) {
            System.out.println(1);
            return;
        }

        for (int i = 1; i <= input; i++) {
            num = num.multiply(new BigInteger(i + ""));
        }

        char[] c = num.toString().toCharArray();
        for (int b = num.toString().length() - 1; b >= 0; b--) {
            if (c[b] != '0') {
                System.out.println(c[b]);
                return;
            }
        }
    }
}
