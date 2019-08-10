package leetcode;

/**
 * @author He.H
 * @date 2019/1/24 15:34
 **/


public class Leetcode91 {
    public int numDecodings(String s) {
        if(s.length()==0){
            return 0;
        }
        int[] dp = new int[s.length()];
        dp[0] = s.charAt(0)=='0'?0:1;
        if(s.length()==1){
            return dp[0];
        }
        int k = s.charAt(0) > '0' && s.charAt(1) > '0'? 1:0;
        dp[1] = k + (s.charAt(0) == '1' || s.charAt(0) == '2' && s.charAt(1) <= '6' ? 1:0);
        for (int i = 2; i < dp.length; i++) {
            if(s.charAt(i)!='0'){
                dp[i] += dp[i-1];
            }
            if(s.charAt(i-1)=='1'||s.charAt(i-1)=='2'&&s.charAt(i)<='6'){
                dp[i] += dp[i-2];
            }
        }
        return dp[s.length()-1];
    }


    public int numDecodings1(String s) {
        if (s.charAt(0) == '0') return 0;

        int[] dp = new int[s.length() + 1];
        dp[0] = dp[1] = 1;

        for (int i = 2; i <= s.length(); i++) {
            //如果该位不为'0'，说明该位单独成字母合法
            if (s.charAt(i - 1) != '0') {
                dp[i] += dp[i - 1];
            }
            //如果后两位能组成"1x"（x为任意数字）或者"2x"（x小于7），说明最后两位组成字母合法
            if ((s.charAt(i - 2) == '1') || (s.charAt(i - 2) == '2' && s.charAt(i - 1) <= '6')) {
                dp[i] += dp[i - 2];
            }
        }
        return dp[s.length()];
    }
}
