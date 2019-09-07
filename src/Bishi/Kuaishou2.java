package Bishi;

import java.util.Scanner;

/**
 * @author He.H
 * @date 2019/8/25 16:27
 **/


public class Kuaishou2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        for(int i : nums) {
            System.out.println(judge(i));
        }
        
    }
    

    public static boolean judge(int n){
        int tmp = n;
        while(true){
            tmp = makeNum(tmp);
            if (tmp == 1) {
                return true;
            }else if (tmp == 89) {
                return false;
            }
        }
    }
    public static int makeNum(int n){
        int res = 0;
        while (n > 0) {
            res += (n % 10) * (n %10);
            n = n / 10;
        }
        return res;
    }
}
