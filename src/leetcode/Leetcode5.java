package leetcode;

/**
 * @author He.H
 * @date 2019/2/18 16:20
 **/


public class Leetcode5 {
    public static String longestPalindrome(String s) {
        if(s == null || s.length() <= 1){
            return s;
        }
        int len = s.length();
        //flag[i][j]=true 表示子串i-j为回文字符串
        boolean[][] flags = new boolean[1000][1000];
        int start = 0;
        int maxlen = 0;
        for(int i=0; i<len; i++){
            flags[i][i] = true;
            if(maxlen==0||maxlen==1){
                start = i;
                maxlen = 1;
            }
            //相邻的两个字符相同
            if( i<len-1 && s.charAt(i) == s.charAt(i+1)){
                flags[i][i+1] = true;
                start = i;
                maxlen = 2;
            }
        }
        //m代表回文子串长度，从3开始
        for(int m = 3; m <= len; m++){
            for(int i = 0; i <= len-m; i++ ){
                //依次比较是否符合状态转移方程
                int j = i+m-1;
                if(flags[i+1][j-1] && s.charAt(i)==s.charAt(j)){
                    flags[i][j] = true;
                    start = i;
                    maxlen = m;
                }
            }
        }
        return s.substring(start, start+maxlen);
    }

    public String longestPalindrome1(String s) {
        int n = s.length();
        String res = "";
        boolean[][] dp = new boolean[n][n];
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                dp[i][j] = s.charAt(i) == s.charAt(j) && (j - i < 2 || dp[i + 1][j - 1]); //j - i 代表长度减去 1
                if (dp[i][j] &&  j - i + 1 > res.length()) {
                    res = s.substring(i, j + 1);
                }
            }
        }
        return res;
    }

    //中心扩展
    public String longestPalindrome2(String s) {
        if (s == null || s.length() < 1) return "";
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = expandAroundCenter(s, i, i);
            int len2 = expandAroundCenter(s, i, i + 1);
            int len = Math.max(len1, len2);
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    private int expandAroundCenter(String s, int left, int right) {
        int L = left, R = right;
        while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
            L--;
            R++;
        }
        return R - L - 1;
    }


    public static void main(String[] args){
        String s = "ababa";
        String ans = longestPalindrome(s);
        System.out.println(ans);
    }
}
