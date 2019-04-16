package Bishi;

import java.util.Scanner;

/**
 * @author He.H
 * @date 2019/3/16 20:06
 **/


public class ByteDance2 implements Runnable {
    /**
     * 设dp[i]表示给i发的最小奖品，首先扫一遍数组，将两侧分数均比中间高的位置，奖品数置1，
     * 然后再扫一遍对没有赋值的位置进行递归记忆化搜索。复杂度O(N)
     * */

    private final int mod = 1000000007, max = 100005;

    int[] arr = new int[max], dp = new int[max];

    public static void main(String[] args) {
        new Thread(null, new ByteDance2(), "thread-1", 1024*1024*10).start();
    }

    @Override
    public void run() {
        try{
            solve();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    private void solve() {
        Scanner cin = new Scanner(System.in);
        int T = cin.nextInt();
        for(int i=0; i<T; i++){
            int n = cin.nextInt();
            for(int j=0; j<n; j++){
                arr[j] = cin.nextInt();
                dp[j] = 0;//初始化dp数组
            }
            for(int j=0; j<n; j++){
                if(arr[(j+1)%n] >= arr[j] && arr[(j-1+n)%n] >= arr[j]){ // 最优情况下，这里发的奖品一定是1
                    dp[j] = 1;
                }
            }

            long ans = 0;
            for(int j=0; j<n; j++){
                if(dp[j] == 0){
                    //搜索j上的值
                    dfs(j, n);
                }
                ans += dp[j];
            }
            System.out.println(ans);
        }
    }

    void dfs(int k, int n) {

        //环形数组，当前元素 i 的前一个元素下标为：(i-1+n)%n
        //后一个元素下标为： (i+1)%n
        int pre = (k-1+n)%n, nex = (k+1)%n;
        if(arr[pre] < arr[k] && dp[pre] == 0){
            //当前位大于前一位，但前一位未赋值，深度搜索，把前一位值确定
            dfs(pre, n);
        }
        if(arr[nex] < arr[k] && dp[nex] == 0){
            //当前位大于后一位，但后一位未确定，搜索后一位的值
            dfs(nex, n);
        }

        if(arr[pre] < arr[k]){
            //当前位大于前一位，则奖品不少于前一位
            dp[k] = Math.max(dp[k], dp[pre]+1);
        }
        if(arr[nex] < arr[k]){
            //当前位大于后一位，则奖品不少于后一位
            dp[k] = Math.max(dp[k], dp[nex]+1);
        }
    }
}
