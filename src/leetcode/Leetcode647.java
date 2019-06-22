package leetcode;

/**
 * @author He.H
 * @date 2019/6/22 14:39
 **/


public class Leetcode647 {
    public static void main(String[] args) {
        String test = "abbbc";
        int res = countSubstrings(test);
        System.out.println(res);
    }
    public static int countSubstrings(String s) {
        int res = 0, n = s.length();
        for(int i = 0; i<n ;i++ ){
            for(int j = 0; i-j >= 0 && i+j < n && s.charAt(i-j) == s.charAt(i+j); j++){
                res++; //substring s[i-j, ..., i+j]，长度为奇数
            }
            for(int j = 0; i-1-j >= 0 && i+j < n && s.charAt(i-1-j) == s.charAt(i+j); j++){
                res++; //substring s[i-1-j, ..., i+j]，长度为偶数
            }
        }
        return res;
    }
}
