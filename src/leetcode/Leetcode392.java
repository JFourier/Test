package leetcode;

/**
 * @author He.H
 * @date 2019/7/6 11:33
 **/


public class Leetcode392 {
    public boolean isSubsequence(String s, String t) {
        char[] ch = s.toCharArray();
        int index = 0;
        for(int i = 0; i < ch.length; i++) {
            if(index >= t.length()) {
                return false;
            }
            int n = t.indexOf(ch[i], index);
            if(n < 0) {
                return false;
            }
            index = n+1;
        }
        return true;
    }
}
