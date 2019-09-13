package leetcode;

import java.util.Scanner;

/**
 * @author He.H
 * @date 2019/9/13 15:50
 **/


public class Leetcode135 {
    //分糖果。线性数组
    public int candy(int[] ratings) {
        int n = ratings.length;
        int total = 0;
        int down = 0;
        int pre = 1;
        for (int i = 1; i < n; i++) {
            //当前是在上坡或者平坡
            if (ratings[i] >= ratings[i - 1]) {
                //之前出现过了下坡
                if (down > 0) {
                    //山顶的糖果数大于下降的高度，对应情况 1
                    //将下降的糖果数利用等差公式计算，单独加上山顶
                    if (pre > down) {
                        total += count(down);
                        total += pre;
                        //山顶的糖果数小于下降的高度，对应情况 3，
                        //将山顶也按照等差公式直接计算进去累加
                    } else {
                        total += count(down + 1);
                    }
                    //当前是上坡，对应情况 1 或者 3
                    //更新 pre 等于 2
                    if (ratings[i] > ratings[i - 1]) {
                        pre = 2;

                        //当前是平坡，对应情况 2 或者 4
                        //更新 pre 等于 1
                    } else {
                        pre = 1;
                    }
                    down = 0;
                    //之前没有出现过下坡
                } else {
                    //将前一个小朋友的糖果数相加
                    total += pre;
                    //如果是上坡更新当前糖果数是上一个的加 1
                    if (ratings[i] > ratings[i - 1]) {
                        pre = pre + 1;
                        //如果是平坡，更新当前糖果数为 1
                    } else {
                        pre = 1;
                    }

                }
            } else {
                down++;
            }
        }
        //判断是否有下坡
        if (down > 0) {
            //和之前的逻辑一样进行相加
            if (pre > down) {
                total += count(down);
                total += pre;
            } else {
                total += count(down + 1);
            }
            //将最后一个小朋友的糖果计算
        } else {
            total += pre;
        }
        return total;
    }

    //等差数列求和
    private int count(int n) {
        return (1 + n) * n / 2;
    }



    //环形数组
    private void solve(int[] arr, int[] dp) {
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
                    dfs(j, n, arr, dp);
                }
                ans += dp[j];
            }
            System.out.println(ans);
        }
    }
    void dfs(int k, int n, int[] arr, int[] dp) {
        //环形数组，当前元素 i 的前一个元素下标为：(i-1+n)%n
        //后一个元素下标为： (i+1)%n
        int pre = (k-1+n)%n, nex = (k+1)%n;
        if(arr[pre] < arr[k] && dp[pre] == 0){
            //当前位大于前一位，但前一位未赋值，深度搜索，把前一位值确定
            dfs(pre, n, arr, dp);
        }
        if(arr[nex] < arr[k] && dp[nex] == 0){
            //当前位大于后一位，但后一位未确定，搜索后一位的值
            dfs(nex, n, arr, dp);
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
