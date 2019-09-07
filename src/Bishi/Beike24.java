package Bishi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @author He.H
 * @date 2019/8/23 14:41
 **/


public class Beike24 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        Arrays.sort(nums);
        int sum = Arrays.stream(nums).sum();

        int[] dp = new int[1000005];
        for (int i = 0; i < n; i++) {
            for (int j = sum/2; j >= nums[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j-nums[i]]+nums[i]);
            }
        }
        int diff = sum-2*dp[sum/2];
        System.out.print(diff+" ");
        int sum1 = (sum+diff)/2;
        int sum2 = sum-sum1;

        int cnt = Math.min(help(nums,sum1), help(nums, sum2));
        System.out.println(Math.abs(n-2*cnt));
    }

    public static int help(int[] nums, int key){
        boolean[] visited = new boolean[nums.length];
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        int le = Integer.MAX_VALUE;
        backTrack(nums,visited, 0,0,key, res, le);

        int s = Integer.MAX_VALUE;
        for (ArrayList<Integer> t : res) {
            if (t.size() < s) {
                s = t.size();
            }
        }
        return s;
    }

    public static void backTrack(int[] input, boolean[] visited, int n, int sum, int key,
                                 ArrayList<ArrayList<Integer>> lists, int le) {
        // 如果条件为：if (sum % key == 0 && sum != 0) 则是求所有和为定值整数倍的序列
        if (count(visited) >= le){
            return;
        }
        if (sum == key) {
            ArrayList<Integer> list = new ArrayList<Integer>();
            for (int j = 0; j <= n; j++) {
                if (visited[j]) {
                    list.add(input[j]);
                }
            }
            lists.add(list);
            return;
        }

        for (int i = n; i < input.length; i++) {
            if (!visited[i]) {
                sum += input[i];
                visited[i] = true;
                if (i != input.length - 1) {
                    backTrack(input, visited, i + 1, sum, key, lists,le);
                } else {
                    backTrack(input, visited, i, sum, key, lists,le);
                }
                visited[i] = false;
                sum -= input[i];

//                重复的元素只统计一次，否则会出现重复（而次操作的前提是，序列已经排序。所以参数input数组是排序好的）
//                while (i < input.length - 1 && input[i] == input[i + 1]) {
//                    i++;
//                }
            }
        }
    }

    public static int count(boolean[] used) {
        int cnt = 0;
        for (boolean i: used) {
            if (i) {
                cnt++;
            }
        }
        return cnt;
    }

    public static int calDiff(int a, int b) {
        return Math.abs(a-b);
    }
}
