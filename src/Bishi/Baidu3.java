package Bishi;

import java.util.Scanner;

/**
 * @author He.H
 * @date 2019/9/10 19:49
 **/


public class Baidu3 {
    static int[] map = new int[] {0,2,5,5,4,5,6,3,7,6};
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] nums = new int[m];
        int cnt[] = new int[m];
        for (int i = 0; i < m; i++) {
            nums[i] = sc.nextInt();
            cnt[i] = map[nums[i]];
        }

        while (n > 7) {

        }
    }
}
