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
    public static void main(String[] args){
        String s = "ababa";
        String ans = longestPalindrome(s);
        System.out.println(ans);
    }
}
