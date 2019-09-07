package Bishi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @author He.H
 * @date 2019/8/30 18:09
 **/


public class Ali2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        String tmp = sc.nextLine();
        String[] tmp1 = tmp.trim().split(" ");
        int n = tmp1.length;
        int[] amt = new int[n];
        for (int i = 0; i < n; i++) {
            amt[i] = Integer.parseInt(tmp1[i]);
        }
        Arrays.sort(amt);
        int dif = Integer.MAX_VALUE;
        if (Arrays.stream(amt).sum()< 2* m) {
            System.out.println("-1.0");
        } else {
            ArrayList<ArrayList<Integer>> res = subsets(amt);
            for (int i = 0; i < res.size(); i++) {
                int tp = sum(res.get(i));
                if (tp<2*m) continue;
                else {
                    int df = tp-2*m;
                    if (df<dif) {
                        dif = df;
                    }
                }
            }
        }

        int ans = 2*m + dif;
        String a = ans+".0";
        System.out.println(a);


    }

    public static ArrayList<ArrayList<Integer>> subsets(int[] nums) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        backtrack(0, nums, res, new ArrayList<Integer>());
        return res;

    }

    private static void backtrack(int i, int[] nums, ArrayList<ArrayList<Integer>> res, ArrayList<Integer> tmp) {
        res.add(new ArrayList<>(tmp));
        for (int j = i; j < nums.length; j++) {
            tmp.add(nums[j]);
            backtrack(j + 1, nums, res, tmp);
            tmp.remove(tmp.size() - 1);
        }
    }

    public static int sum(ArrayList<Integer> list) {
        int s = 0;
        for (int i : list) {
            s+=i;
        }
        return s;
    }
}
