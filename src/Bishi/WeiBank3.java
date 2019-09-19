package Bishi;

import java.util.Scanner;

/**
 * @author He.H
 * @date 2019/9/19 16:42
 **/


public class WeiBank3 {
    static int arr[];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        arr = new int[n * 4];
        arr[0] = 1;
        int p = 0;
        for(int i = 1; i <= n; i++){
            int t = 0;
            for(int j = 0; j < p; j++){
                arr[j] = arr[j] * i + t;
                t = 0;
                if(arr[j] >= 10){
                    t = arr[j] / 10;
                    arr[j] = arr[j] % 10;
                }
            }
            int cur = arr[p] * i + t;
            while(cur >= 10){
                arr[p++] = cur % 10;
                cur /= 10;
            }
            arr[p] = cur;
        }
        for(int k = p; k >= 0; k--){
            System.out.print(arr[k]);
        }
        System.out.print("\n");
        sc.close();
    }
}
