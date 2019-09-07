package Bishi;

import java.util.LinkedList;
import java.util.Scanner;

/**
 * @author He.H
 * @date 2019/8/24 18:43
 **/


public class Jingdong1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String f = sc.nextLine();
        int n = Integer.parseInt(f);
        String t = sc.nextLine();
        char[] input = t.toCharArray();
        boolean flag = Character.isUpperCase(input[0]);

        LinkedList<Integer> upper = new LinkedList<>();
        LinkedList<Integer> lower = new LinkedList<>();
        int cnt = 1;
        for (int i = 1; i < n; i++) {
            if (Character.isUpperCase(input[i]) == flag) {
                cnt++;
            } else {
                if (flag) {
                    upper.add(cnt);
                } else {
                    lower.add(cnt);
                }
                cnt = 1;
                flag  = !flag;
            }
        }
        boolean last = Character.isUpperCase(input[n-1]);
        cnt = 1;
        for (int i = n-2; i > 0 ; i--) {
            if (last == Character.isUpperCase(input[i])){
                cnt++;
                continue;
            } else {
                if (last) {
                    upper.add(cnt);
                    break;
                } else {
                    lower.add(cnt);
                    break;
                }
            }
        }

        int ans = 0;
        if (Character.isUpperCase(input[0])) {
            while (lower.size()>=0 || upper.size()>=0) {
                if (lower.size()>0 && upper.size()>0) {
                    int u = upper.poll();
                    int l = lower.poll();
                    if (u == 1) {
                        cnt += 1;
                    }
                    if (u >= 2) {
                        cnt += 2;
                    }
                    if (l == 1) {
                        cnt += 1;
                    }
                    if (l >= 2) {
                        cnt += 2;
                    }
                } else {
                    cnt += 1;
                }
            }
        }



        System.out.println(cnt+n);
    }
}

