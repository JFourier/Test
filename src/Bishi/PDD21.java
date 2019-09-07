package Bishi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * 寻梦计划
 *
 * @author He.H
 * @date 2019/9/1 13:38
 **/


public class PDD21 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String tmp1 = sc.nextLine();
        String[] tmp2 = tmp1.split("[,;]");
        int n = Integer.parseInt(tmp2[tmp2.length-1]);
        int[] arr = new int[tmp2.length-1];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(tmp2[i]);
        }
        Arrays.sort(arr);
        List<Integer> ans = new ArrayList<>();
        int cnt = 0;
        for (int i = arr.length-1; i >= 0; i--) {
            if (cnt == n) break;
            if (arr[i]%2 == 0) {
                ans.add(arr[i]);
                cnt++;
            }
        }
        if (cnt < n) {
            int diff = n - cnt;
            int t = 0;
            for (int i = arr.length-1; i >= 0 ; i--) {
                if (t == diff) break;
                if (arr[i]%2 == 1) {
                    ans.add(arr[i]);
                    t++;
                }
            }
        }
        for (int i = 0; i < ans.size(); i++) {
            if (i == ans.size()-1) {
                System.out.print(ans.get(i));
            } else {
                System.out.print(ans.get(i)+",");
            }
        }

    }
}
