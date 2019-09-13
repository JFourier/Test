package Bishi;

import java.util.Scanner;

/**
 * @author He.H
 * @date 2019/8/16 17:29
 **/


public class Kedaxunfei {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        String[] strings = s.split("\\S+");
        String s1 = strings[0];
        String s2 = strings[1];
        String ans = add(s1, s2);
        System.out.println(ans);
    }
    public static String add(String s1, String s2) {

        StringBuffer result = new StringBuffer();
        s1 = new StringBuffer(s1).reverse().toString();
        s2 = new StringBuffer(s2).reverse().toString();
        int les1 = s1.length();
        int les2 = s2.length();
        int maxLen = les1 > les2 ? les1 : les2;
        int c = 0;
        if (les1 < les2) {
            for (int i = les1; i < les2; i++) {
                s1 += "0";
            }
        } else if (les1 > les2) {
            for (int i = les2; i < les1; i++) {
                s2 += "0";
            }
        }
        for (int i = 0; i < maxLen; i++) {
            int nSum = Integer.parseInt(s1.charAt(i) + "") + Integer.parseInt(s2.charAt(i) + "") + c;
            int ap = nSum % 10;
            result.append(ap);
            c = nSum / 10;
        }
        if (c > 0) {
            result.append(c);
        }
        return result.reverse().toString();
    }
}
