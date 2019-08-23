package leetcode;

/**
 * @author He.H
 * @date 2019/8/15 14:45
 **/


public class Leetcode123 {
    public int maxProfit(int[] prices) {
        if(prices==null||prices.length<2)
            return 0;

        int len=prices.length;
        int[]firstProfit=new int[len];
        int[]secondProfit=new int[len];
        int min=prices[0];
        for(int i=1;i<len;i++){
            min=Math.min(min, prices[i]);
            firstProfit[i]=Math.max(firstProfit[i-1], prices[i]-min);
        }
        int max=prices[len-1];
        for(int i=len-2;i>=0;i--){
            max=Math.max(max, prices[i]);
            secondProfit[i]=Math.max(secondProfit[i+1], max-prices[i]);
        }
        int res=0;
        for(int i=0;i<len;i++){
            res=Math.max(res, firstProfit[i]+secondProfit[i]);
        }
        return res;
    }
}
