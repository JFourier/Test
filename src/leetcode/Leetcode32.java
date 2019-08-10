package leetcode;

import java.util.Stack;

/**
 * @author He.H
 * @date 2019/2/18 17:23
 **/


public class Leetcode32 {
    //定义一个 dp 数组，其中第 i 个元素表示以下标为 i 的字符结尾的最长有效子字符串的长度。
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


    //对于遇到的每个 ‘(’ ，我们将它的下标放入栈中。
    //对于遇到的每个 ‘)’ ，我们弹出栈顶的元素并将当前元素的下标与栈顶元素下标作差，得出当前有效括号字符串的长度
    public int longestValidParentheses1(String s) {
        int maxans = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if (stack.empty()) {
                    stack.push(i);
                } else {
                    maxans = Math.max(maxans, i - stack.peek());
                }
            }
        }
        return maxans;
    }
}
