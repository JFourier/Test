package Bishi;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/**
 * @author He.H
 * @date 2019/4/2 20:15
 **/


public class Baidu {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        int ans = solve(nums);
        System.out.println(ans);
    }

    public static int solve(int[] nums) {
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        for (int i : nums) {
            if (!map.containsKey(i)) {
                ArrayList<Integer> tmp = new ArrayList<>();
                tmp.add(i);
                map.put(i, tmp);
            } else {
                map.get(i).add(i);
            }
        }
        int ans = 0;
        for (int key : map.keySet()) {
            if (map.get(key).size()%2 == 0) {
                ans += map.get(key).size()/2;
            } else {
                ans += map.get(key).size()/2 + 1;
            }
        }
        return ans;
    }


}
