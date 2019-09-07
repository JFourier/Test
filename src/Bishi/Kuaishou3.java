package Bishi;

/**
 * @author He.H
 * @date 2019/8/25 16:27
 **/


import java.util.Scanner;

public class Kuaishou3 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s1 = sc.nextLine();
        String s2 = sc.nextLine();
        String[] str1 = s1.split(" ");
        String[] str2 = s2.split(" ");
        StringBuilder sb = new StringBuilder();
        int n = str1.length;
        int index1 = 0;
        int index2 = 0;
        while(index1 < n){
            for(int i =0; index1+i<n&& i<4; i++){
                sb.append(str1[index1+i]);
            }
            if(index2<str2.length)
                sb.append(str2[index2++]);
            index1 += 4;
        }

        if(index2<str2.length){
            while(index2<str2.length)
                sb.append(str2[index2++]);
        }
        String ans = sb.toString();
        for(int i =0; i<ans.length()-1; i++) System.out.print(sb.charAt(i)+" ");
        System.out.println(ans.charAt(ans.length()-1));

    }

}