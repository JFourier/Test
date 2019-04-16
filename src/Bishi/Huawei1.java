package Bishi;

import polymorphism.A;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * @author He.H
 * @date 2019/4/10 18:19
 **/


public class Huawei1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String in0 = scanner.nextLine();
        String[] in = in0.split(" ");
        ArrayList<String> res = new ArrayList<>();
        for (int i = 1; i <= Integer.parseInt(in[0]); i++) {
            ArrayList<String> tmp = split(in[i]);
            res.addAll(tmp);
        }
        Collections.sort(res);
        for (int i = 0; i < res.size(); i++) {
            if (i<res.size()-1){
                System.out.print(res.get(i)+" ");
            }else {
                System.out.print(res.get(i));
            }

        }
    }
    public static ArrayList<String> split(String str) {
        ArrayList<String> res = new ArrayList<>();
        String[] zero = {"0","00","000","0000","00000","000000","0000000"};
        int length = str.length();
        int cnt = length/8;
        int tail = length%8;
        if (cnt == 0) {
            int append = 8-tail-1;

            res.add(str.concat(zero[append]));
            return res;
        }else {
            for (int i = 0; i < cnt; i++) {
                res.add(str.substring(i*8,(i+1)*8));
                }
            if (tail > 0){
                int append = 8-tail-1;
                res.add(str.substring(cnt*8, length).concat(zero[append]));
            }
            return res;
        }
    }
}
