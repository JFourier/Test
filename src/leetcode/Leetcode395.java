package leetcode;

import java.util.HashMap;

/**
 * 〈〉
 *
 * @author He.H
 * @create 2018/9/29
 */
public class Leetcode395 {
    public static void main(String[] args){

    }
    public int longestSubstring(String s, int k) {
        HashMap<Character, Integer> count = new HashMap<>();
        for(int i=0;i<s.length();i++){
            if (!count.containsKey(s.charAt(i))){
                count.put(s.charAt(i),1);
            }else {
                int tmp = count.get(s.charAt(i));
                count.put(s.charAt(i),tmp+1);
            }
        }
        int res = 0;
        for(int i=0;i<s.length();i++){
            if (count.get(s.charAt(i))<k){
                res =i;
                break;
            }else {
                res= s.length();
            }
        }
        return res;
    }
}