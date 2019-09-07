package Bishi;

import java.util.Scanner;

/**
 * @author He.H
 * @date 2019/9/6 19:15
 **/


public class Xiaomi1 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String str;
        str = sc.nextLine();
        char a[]=str.toCharArray();
        int i;
        boolean flag=true;
        for(i=str.length()-1;i>=0;i--){
            if(a[i]==a[str.length()-1-i]) {
                flag=true;
            }
            else {
                flag=false;
                break;
            }
        }
        if(flag) {
            System.out.println("True");
        } else {
            System.out.println("False");
        }
    }

}
