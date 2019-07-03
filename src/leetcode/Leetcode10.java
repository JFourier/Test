package leetcode;

/**
 * @author He.H
 * @date 2019/7/1 9:37
 **/


enum Result {
    TRUE, FALSE
}

public class Leetcode10 {
    public boolean isMatch(String text, String pattern) {
        if (pattern.isEmpty()) return text.isEmpty();
        boolean first_match = (!text.isEmpty() &&
                (pattern.charAt(0) == text.charAt(0) || pattern.charAt(0) == '.'));

        if (pattern.length() >= 2 && pattern.charAt(1) == '*'){
            // 发现下一位是*， 此时递归判断匹配0次和1次
            return (isMatch(text, pattern.substring(2)) ||//0次就是pattern中跳过*及其前一位
                    (first_match && isMatch(text.substring(1), pattern)));//1次就将text后移一位继续判断能否再次匹配
        } else {
            return first_match && isMatch(text.substring(1), pattern.substring(1));
        }
    }




    Result[][] memo;

    public boolean isMatch1(String text, String pattern) {
        memo = new Result[text.length() + 1][pattern.length() + 1];
        return dp(0, 0, text, pattern);
    }

    public boolean dp(int i, int j, String text, String pattern) {
        if (memo[i][j] != null) {
            return memo[i][j] == Result.TRUE;
        }
        boolean ans;
        if (j == pattern.length()){
            ans = i == text.length();
        } else{
            boolean first_match = (i < text.length() &&
                    (pattern.charAt(j) == text.charAt(i) ||
                            pattern.charAt(j) == '.'));

            if (j + 1 < pattern.length() && pattern.charAt(j+1) == '*'){
                ans = (dp(i, j+2, text, pattern) ||
                        first_match && dp(i+1, j, text, pattern));
            } else {
                ans = first_match && dp(i+1, j+1, text, pattern);
            }
        }
        memo[i][j] = ans ? Result.TRUE : Result.FALSE;
        return ans;
    }
}

