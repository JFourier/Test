package leetcode;

import org.junit.Test;

/**
 * @author He.H
 * @date 2019/2/18 17:23
 **/


public class Leetcode32 {
    public int longestValidParentheses(String s) {
        if(null == s) return 0;
        int len = s.length(), max = 0;
        int[] d = new int[len];
        for(int index = len-2; index >= 0; index--){
            int symIndex = index+1+d[index+1];
            if('(' == s.charAt(index) && symIndex < len && ')' == s.charAt(symIndex)){
                d[index] = d[index+1]+2;
                if(symIndex+1 < len){
                    d[index] += d[symIndex+1];
                }
            }
            max = Math.max(max, d[index]);
        }
        return max;
    }
}
