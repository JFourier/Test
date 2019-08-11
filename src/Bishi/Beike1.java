package Bishi;

import java.util.Scanner;

/**
 * @author He.H
 * @date 2019/8/10 18:37
 **/


public class Beike1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        int res = solve(nums);
        System.out.println(res);


    }
    public static int solve(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int[] dp = new int[nums.length];
        dp[0] = 1;
        int maxans = 1;
        for (int i = 1; i < dp.length; i++) {
            int maxval = 0;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    maxval = Math.max(maxval, dp[j]);
                }
            }
            dp[i] = maxval + 1;
            maxans = Math.max(maxans, dp[i]);
        }
        return maxans;
    }
}


class test30 {
    private static int getLength(int[] array) {
        int[] assistArray = new int[array.length];
        assistArray[0] = array[0];
        int length = 0;
        for (int number : array) {
            if (assistArray[length] < number) {
                assistArray[++length] = number;
            } else {
                int low = 0;
                int high = length;
                while (low < high) {
                    int middle = (low + high) >> 1;
                    if (assistArray[middle] < number) {
                        low = middle + 1;
                    } else {
                        high = middle - 1;
                    }
                }
                if (assistArray[low] < number && (low + 1) < assistArray.length) {
                    assistArray[low + 1] = number;
                } else {
                    assistArray[low] = number;
                }
            }
        }
        return length + 1;
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()) {
            int N = sc.nextInt();
            int[] nums = new int[N];
            for(int i = 0;i < N;i++) {
                nums[i] = sc.nextInt();
            }
            System.out.println(getLength(nums));
        }

    }

}

