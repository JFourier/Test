package Bishi;

import java.util.Scanner;

/**
 * @author He.H
 * @date 2019/8/16 17:29
 **/


public class Kedaxunfei2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String string = scanner.next();
        int low=0;
        int high=0;
        int count=0;
        int len=string.length();
        char c;
        StringBuilder sb = new StringBuilder();
        while (low < len) {
            high=low;
            c = string.charAt(low);
            while ((high < len) && (string.charAt(high) == c)) {
                high++;
            }
            count=high-low;
            if (count > 1) {
                sb.append(count);
                sb.append(c);
            } else {
                sb.append(c);
            }

            low=high;
        }
        System.out.println(sb.toString());
    }
}