package Bishi;

import java.util.Scanner;

/**
 * @author He.H
 * @date 2019/8/23 14:41
 **/



public class Beike23 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long box = sc.nextLong();
        int[] cnt = new int[n];
        int[] size = new int[n];
        for(int i =0; i<n; i++){
            cnt[i] = sc.nextInt();
            size[i] = sc.nextInt();
        }
        long ans = 0;
        for(int i =0; i<n; i++){
            long tmp = box / size[i];
            if(tmp > cnt[i]){
                ans += cnt[i];
                box -= cnt[i]*size[i];
            }
            else {
                ans += tmp;
                box -= tmp*size[i];
            }

        }
        System.out.println(ans);
    }
}


