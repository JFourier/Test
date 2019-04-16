package leetcode;

/**
 * @author He.H
 * @date 2019/4/12 9:55
 **/


public class Leetcode972 {
    public boolean isRationalEqual(String S, String T) {
        double num1 = work(S);
        double num2 = work(T);
        if (Math.abs(num1 - num2) < 1e-8) {
            return true;
        }
        return false;
    }
    public double work(String str) {
        int dig = 0;
        double ans = 0;
        int idx = 0;
        while (idx < str.length() && str.charAt(idx) != '.') {
            ans = ans * 10 + str.charAt(idx) - '0';
            idx++;
            dig++;
        }

        idx++; // skip '.'

        double base = 0.1;
        while (idx < str.length() && str.charAt(idx) != '(') {
            ans += base * (str.charAt(idx) - '0');
            base *= 0.1;
            idx++;
            dig++;
        }

        int prev = idx;
        idx++;
        while (idx < str.length() && dig < 20) {
            ans += base * (str.charAt(idx) - '0');
            base *= 0.1;
            idx++;
            dig++;
            if (str.charAt(idx) == ')') {
                idx = prev + 1;
            }
        }

        return ans;
    }
}
