package leetcode;

/**
 * @author He.H
 * @date 2019/1/14 10:49
 **/


public class Leetcode76 {
    public String minWindow(String s, String t) {
        if (s == null || t == null || s.length() < t.length()) {
            return "";
        }
        char[] chas1 = s.toCharArray();
        char[] chas2 = t.toCharArray();
        // HashMap<Character, Integer> map = new HashMap<>();
        int[] map = new int[256];
        for (int i = 0; i < chas2.length; i++) {
            map[chas2[i]]++;
        }
        int curLen = Integer.MAX_VALUE;
        int minLen = Integer.MAX_VALUE;
        int minL = 0;
        int minR = 0;
        int match = chas2.length;
        int left = 0;
        int right = 0;
        while (right < chas1.length) {
            map[chas1[right]]--;
            if (map[chas1[right]] >= 0) {  // 成功的一笔还款
                match--;
            }
            if (match == 0) {
                while (map[chas1[left]] < 0) { // left尽量右移
                    map[chas1[left]]++;
                    left++;
                }
                curLen = right - left + 1;
                if (curLen < minLen) {  // 记录最短窗口的位置
                    minLen = curLen;
                    minL = left;
                    minR = right;
                }
                // 一定要在if语句内，left不一定是每次都移动
                map[chas1[left++]]++; // left继续右移1位
                match++;  // 再次欠款！
            }
            right++;
        }
        return minLen == Integer.MAX_VALUE ? "" : s.substring(minL, minR + 1);
    }
}
