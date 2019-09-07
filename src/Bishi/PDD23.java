package Bishi;

import java.util.Scanner;

/**
 * @author He.H
 * @date 2019/9/1 13:39
 **/


public class PDD23 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int m=sc.nextInt();
        int k=sc.nextInt();
        int ret= findKthNumber(n,m,n*m+1-k);
        System.out.println(ret);
    }

    public static int findKthNumber(int m, int n, int k) {
        int lo = 1, hi = m * n + 1;
        int mid, count;
        while (lo < hi) {
            mid = lo + (hi - lo) / 2;
            count = 0;
            for (int i = 1; i <= m; i++) {
                count += (mid/i > n ? n : mid/i);
            }
            if (count >= k) hi = mid;
            else lo = mid + 1;
        }
        return lo;
    }
//    private static int solve(int m, int n, int k) {
//        int L=1*1;
//        int R=m*n;
//        while(L<R){
//            int mid=(L+R)>>1;
//            int count=help(mid,m,n);
//            if(count<k){
//                L=mid+1;
//            }else{
//                R=mid;
//            }
//        }
//        return R;
//    }
//    private static int help(int val,int m,int n){
//        int i=m;
//        int j=1;
//        int sum=0;
//        while(i>0 && j<=n){
//            if(i*j <= val){
//                sum += i;
//                j++;
//            }else{
//                i--;
//            }
//        }
//        return sum;
//    }
}



