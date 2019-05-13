package Bishi;


import java.util.*;

/**
 * @author He.H
 * @date 2019/4/24 19:36
 **/


public class san60No1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] in = new int[n];
        for (int i = 0; i < n; i++) {
            in[i] = scanner.nextInt();
        }
        Map<Integer,Integer> record = new HashMap<>();
        for (int i : in) {
            Integer num = record.get(i);
            record.put(i,num == null? 1: num+1);
        }
        ArrayList<Integer> c = new ArrayList<>();
        for (Integer k : record.keySet()) {
            c.add(record.get(k));
        }
        int div = help(c);
        if (div == -1) {
            System.out.println(0);
        }else{
            int res = 0;
            for (int i : c) {
                res += i/div;
            }
            System.out.println(res);
        }
    }
    public static int help(ArrayList<Integer> arr) {
        int[] a = new int[arr.size()];
        for (int i = 0; i < arr.size(); i++) {
            a[i] = arr.get(i);
        }
        Arrays.sort(a);
        int min = a[0];
        for (int j = min; j >=2 ; j--) {
            int cnt = 0;
            for (int i = 0; i < a.length; i++) {
                if (a[i]%j == 0){
                    cnt++;
                }
            }
            if (cnt == a.length) {
                return j;
            }
        }
        return -1;
    }
}
