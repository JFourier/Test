package Bishi;

import java.util.Scanner;

/**
 * @author He.H
 * @date 2019/3/16 20:09
 **/


public class ByteDance3 implements Runnable{
    /*
    n根绳子，剪成等长的m根，求可以得到的最长长度
    * 二分答案求最大值
    * */
    private final int mod = 1000000007, max = 100005;

    int[] arr = new int[max];

    public static void main(String[] args) {
        new Thread(null, new ByteDance3(), "thread-1", 1024*1024*10).start();
    }

    @Override
    public void run() {
        try{
            solve();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    private void solve(){
        Scanner cin = new Scanner(System.in);
        int n = cin.nextInt(),m = cin.nextInt();
        double lower = 0D, higher = Integer.MAX_VALUE;
        for(int i=0; i<n; i++){
            arr[i] = cin.nextInt();
        }
        //判断能否满足当前 mid 长度的切分，若能，则尝试将下限提高，不能则降低上限
        //不断二分，直至满足精度需求。
        while(higher - lower > 0.001){
            double mid = (lower+higher)/2;
            if(checkAns(n, m, mid)){
                lower = mid;
            }else{
                higher = mid;
            }
        }
        System.out.println(String.format("%.2f", lower));
    }

    boolean checkAns(int n, int m, double mid){
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
