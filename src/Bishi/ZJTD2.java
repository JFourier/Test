package Bishi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 头条8-11
 *
 * @author He.H
 * @date 2019/8/11 17:08
 **/


public class ZJTD2 {
      public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        int n = Integer.parseInt(str[0]);
        int k = Integer.parseInt(str[1]);
        String s = br.readLine();
        StringBuilder sb = new StringBuilder();
        int start = 0;
        for(int i =0; i<k-1;i++) {
            sb.append((s.charAt(i) - '0') ^ start);
            start = s.charAt(i) - '0';
        }
        for(int i = k-1; i<n; i++){
            sb.append((s.charAt(i)-'0')^start);
            start = s.charAt(i)-'0';
            int flag = sb.toString().charAt(i-k+1)-'0';
            start = start^flag;
        }
        System.out.println(sb.toString());

    }
}



