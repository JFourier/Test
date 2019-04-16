package Bishi;


import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

/**
 * @author He.H
 * @date 2019/3/24 18:38
 **/


public class Main324 {
    public static void main(String[] args){
        ArrayList<ArrayList<Integer[]>> INPUT = new ArrayList<>();
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        int[] record = new int[T];
        for (int i = 0; i < T; i++) {
            int N = in.nextInt();
            int K = in.nextInt();
            record[i] = N;
            ArrayList<Integer[]> input = new ArrayList<>();
            for (int j = 0; j < K; j++) {
                Integer[] tmp = new Integer[2];
                tmp[0] = in.nextInt();
                tmp[1] = in.nextInt();
                input.add(tmp);
            }
            INPUT.add(input);
        }
        int[] res = new int[T];
        for (int i = 0; i <T ; i++) {
            res[i] = solve(INPUT.get(i),record[i]);
        }
        for (int r: res) {
            System.out.println(r);
        }
    }


    public static int solve(ArrayList<Integer[]> input, int N) {
        int res = 0;
        input.sort(Comparator.comparingInt((Integer[] a) -> a[1]));
        input.sort((Integer[] a, Integer[] b) -> b[0]-a[0]);
        for (int i = 0; i < input.size(); i++) {
           if (input.get(i)[0]>N) {
               res += input.get(i)[0]-N;
               N += input.get(i)[0]-N;
           }
           if (input.get(i)[1]>N) {
               res += input.get(i)[1]-N;
               N = 0;
           }else{
               N = N-input.get(i)[1];
           }
        }
        return res;
    }
}
