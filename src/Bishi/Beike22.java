package Bishi;

import java.util.Scanner;

/**
 * @author He.H
 * @date 2019/8/23 14:41
 **/


public class Beike22 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int l=sc.nextInt();
        int times=sc.nextInt();
        String t=sc.next();
        int[] next=new int[l];
        help(t,next);
        String temp=t.substring(next[l-1]+1,l);
        StringBuilder sb=new StringBuilder();
        sb.append(t);
        for (int i = 0; i <times-1 ; i++) {
            sb.append(temp);
        }
        System.out.println(sb);
    }
    public static int[] help(String str,int[] a) {
        char[] c = str.toCharArray();
        int length=str.length();
        int i,j;
        a[0] = -1;
        i = 0;
        for(j=1;j<length;j++) {
            i = a[j - 1];
            while(i>=0&&c[j]!=c[i+1]) {
                i = a[i];
            }
            if(c[j]==c[i+1]) {
                a[j] = i+1;
            }
            else {
                a[j] = -1;
            }
        }
        return a;
    }
}

