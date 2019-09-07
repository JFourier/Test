package Bishi;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author He.H
 * @date 2019/8/23 14:41
 **/


public class Beike21 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int S = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        Arrays.sort(nums);

        int res = 0;
        int amount = 0;
        for (int i = 0; i < n; i++) {
            if (amount+nums[i] < S) {
                res++;
                amount += nums[i];
            }
        }
        System.out.println(res);
    }
}
