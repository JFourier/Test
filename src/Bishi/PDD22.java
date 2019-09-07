package Bishi;

import java.util.Scanner;

/**
 * 寻梦计划
 *
 * @author He.H
 * @date 2019/9/1 13:38
 **/


public class PDD22 {


    static String res="";
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        for (int i = 0; i < n; i++) {
            String num1 = in.next();
            String num2 = in.next();
            res += "{\n";
            dfs(num1,"",num2,' ',"", num1.length());
            if (i!=2*n-1) res += "}\n";
            else res += "}\n";
        }
        System.out.println(res);
    }

    private static void dfs(String num1, String newStr, String num2, char opeate, String step, int n) {
        if (n == 0 && newStr.equals(num2)) {
            res += step+"\n";
            return;
        }
        if (num1.length() != 0) {
            char head = num1.charAt(0);
            step += "d ";
            dfs(num1.substring(1),newStr,num2,'d',step, n-1);
            step = step.substring(0,step.length()-2);
            step += "l ";
            dfs(num1.substring(1),head+newStr,num2,'l',step, n-1);
            step = step.substring(0,step.length()-2);
            step += "r ";
            dfs(num1.substring(1),newStr+head,num2,'r',step, n-1);
            step = step.substring(0,step.length()-2);
        }
    }
}
