package leetcode;

import java.util.*;

/**
 * @author He.H
 * @date 2019/3/29 14:21
 **/


public class Leetcode301 {
    public List<String> removeInvalidParentheses(String s) {
        // 统计需要删除的左括号和右括号数量
        int left = 0, right = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                left++;
            } else if (c == ')') {
                if (left > 0)
                    left--;
                else
                    right++;
            }
        }
        // 开始删除
        List<String> res = new ArrayList<>();
        List<String> array = new ArrayList<>();
        Set<String> set = new HashSet<>();

        array.add(s);
        // 先删左括号
        while (left-- > 0) {
            List<String> tempArray = new ArrayList<>();
            for (int i = 0; i < array.size(); i++) {
                String ss = array.get(i);
                for (int j = 0; j < ss.length(); j++) {
                    if (ss.charAt(j) == '(') {
                        String sss = ss.substring(0, j) + ss.substring(j + 1);
                        if (!set.contains(sss)) {
                            set.add(sss);
                            tempArray.add(sss);
                        }
                    }
                }
            }
            array = tempArray;
        }
        //　删右括号
        while (right-- > 0) {
            List<String> tempArray = new ArrayList<>();
            for (int i = 0; i < array.size(); i++) {
                String ss = array.get(i);
                for (int j = 0; j < ss.length(); j++) {
                    if (ss.charAt(j) == ')') {
                        String sss = ss.substring(0, j) + ss.substring(j + 1);
                        if (!set.contains(sss)) {
                            set.add(sss);
                            tempArray.add(sss);
                        }
                    }
                }
            }
            array = tempArray;
        }

        // 对删除后字符串进行验证
        for (int i = 0; i < array.size(); i++) {
            String str = array.get(i);
            if (this.checkVaild(str)) {
                res.add(str);
            }
        }
        return res;
    }

    private static boolean checkVaild(String s) {
        if (s.charAt(0)==')'||s.charAt(s.length()-1)=='(')
            return false;
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' ) {
                stack.push(c);
            } else if (c == ')') {
                if (stack.empty() || stack.peek() == ')') {
                    stack.push(c);
                } else {
                    stack.pop();
                }
            }
        }
        if (stack.empty())
            return true;
        return false;
    }

    public static void main(String[] args) {

        System.out.println(checkVaild(")("));
    }
}

class Solution1111 {
    private void removeLeft(String s, int matchTo, int removeTo, List<String> results) {
        int matched = 0;
        for(int m=matchTo; m>=0; m--) {
            if (s.charAt(m) == ')') matched ++;
            else if (s.charAt(m) == '(') matched --;
            if (matched >= 0) continue;
            for(int r=removeTo; r>=m; r--) {
                //检查是左括号才能删除
                if (s.charAt(r) != '(') continue;
                if (r==removeTo || s.charAt(r+1) != '(') removeLeft(s.substring(0, r)+s.substring(r+1), m-1, r-1, results);
            }
            //如果本次有删除，则留待后面加入到results
            return;
        }
        results.add(s);
    }
    private void removeRight(String s, int matchTo, int removeTo, List<String> results) {
        int matched = 0;
        for(int m=matchTo; m<s.length(); m++) {
            if (s.charAt(m) == '(') matched ++;
            else if (s.charAt(m) == ')') matched --;
            if (matched >= 0) continue;
            for(int r=removeTo; r<=m; r++) {
                //检查是右括号才能删除
                if (s.charAt(r) != ')') continue;
                if (r==removeTo || s.charAt(r-1) != ')') removeRight(s.substring(0, r)+s.substring(r+1), m, r, results);
            }
            //如果本次有删除，则留待后面加入到results
            return;
        }
        removeLeft(s, s.length()-1, s.length()-1, results);
    }
    public List<String> removeInvalidParentheses(String s) {
        List<String> results = new ArrayList<>();
        removeRight(s, 0, 0, results);
        return results;
    }
}

