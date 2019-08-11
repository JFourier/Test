package Bishi;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author He.H
 * @date 2019/8/10 18:38
 **/


public class Beike3 {
    //找到从左到右和从右到左满足题意的值，然后每次比较这两个值的大小，在小的一边做加法。一点点贪心做
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long[] nums = new long[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextLong();
        }
        int res = (int) minSum(n, nums);
        System.out.println(res);
    }

    public static long minSum(int n ,long[] nums) {
        if(n == 1)
            return 0;
        if(n == 2 && nums[0] == nums[1])
            return 1;
        if(n == 2 && nums[0] != nums[1])
            return 0;

        long[] temp = Arrays.copyOf(nums, n);
        int i = 0;
        while(i < n-1 && nums[i] < nums[i+1])
            i++;
        int j = n-1;
        while(j > 0 && nums[j] < nums[j-1])
            j--;

        while(i < j) {
            if(nums[i] < nums[j]) {
                if(nums[i+1] < nums[i]+1)
                    nums[i+1] = nums[i]+1;
                i++;
            } else {
                if(nums[j-1] < nums[j]+1)
                    nums[j-1] = nums[j] + 1;
                j--;
            }
        }
        return Arrays.stream(nums).sum() - Arrays.stream(temp).sum();
    }
}
