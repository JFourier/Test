package Bishi;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author He.H
 * @date 2019/9/12 20:26
 **/


public class Tongcheng582 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        System.out.println(solve(nums));
    }
    public static int solve(int[] nums) {
        int[] cookies = new int[nums.length];
        Arrays.fill(cookies, 1);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                cookies[i] = cookies[i - 1] + 1;
            }
        }
        int sum = cookies[nums.length - 1];
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] > nums[i + 1]) {
                cookies[i] = Math.max(cookies[i], cookies[i + 1] + 1);
            }
            sum += cookies[i];
        }
        return sum;
    }
}
