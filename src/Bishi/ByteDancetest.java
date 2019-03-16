package Bishi;

import java.util.Scanner;

/**
 * @author He.H
 * @date 2019/3/16 20:25
 **/


public class ByteDancetest {

    public static void main(String[] args){
        int n = 3, m = 4;
        int[] arr = {3,4,5};
        double lower = 0D, higher =100D;

        while(higher - lower > 0.001){
            double mid = (lower+higher)/2;
            if(checkAns(arr, n, m, mid)){
                lower = mid;
            }else{
                higher = mid;
            }
        }
        System.out.println(String.format("%.2f", higher));
    }
    public static boolean checkAns(int[] arr, int n, int m, double mid){
        int ans = 0;
        for(int i=0; i<n; i++){
            ans += (int)arr[i]/mid;
            if(ans >= m){
                return true;
            }
        }
        return false;
    }
}
