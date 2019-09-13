package Bishi;

import java.util.Scanner;

/**
 * @author He.H
 * @date 2019/9/11 16:02
 **/


public class Vivo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String string = scanner.nextLine();
        int ans = 0;
        int flag = string.indexOf("0");
        for (int i = 0; i < flag; i++) {
            if (string.charAt(i) == '(') {
                ans++;
            } else {
                ans--;
            }
        }
        System.out.println(ans);
    }
}
