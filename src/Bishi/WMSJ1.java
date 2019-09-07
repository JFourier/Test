package Bishi;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author He.H
 * @date 2019/8/23 19:47
 **/


public class WMSJ1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s  = sc.nextLine();
        String[] str = s.split(" ");
        int n =str.length;
        int[] weight = new int[n];
        for(int i =0; i<n; i++){
            weight[i] = Integer.parseInt(str[i]);
        }
        int limit = sc.nextInt();
        Arrays.sort(weight);
        int lo = 0, hi = n-1;
        int ans = n;
        while(limit - weight[lo] < weight[hi]){
            hi--;
        }
        while(lo < hi){
            if (lo>=n || hi<0) break;
            if(weight[lo] + weight[hi] <= limit){
                ans--;
                lo++;
                hi--;
            }
            else {
                hi--;
            }
        }
        System.out.println(ans);
    }
}
