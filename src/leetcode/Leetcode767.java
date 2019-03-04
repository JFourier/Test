package leetcode;

/**
 * @author He.H
 * @date 2019/1/14 9:25
 **/


public class Leetcode767 {
    public String reorganizeString(String S) {
        int[] letters = new int[26];
        for (char c : S.toCharArray()) {
            letters[c - 'a']++;
        }

        int maxIdx = 0;
        int max = letters[0];
        for (int i = 1; i < letters.length; i++) {
            if (max < letters[i]) {
                max = letters[i];
                maxIdx = i;
            }
        }

        if (max > Math.ceil(S.length() / 2.0)) {
            return "";
        }

        int tmpIdx = 0;
        char[] retArr = new char[S.length()];
        for (int j = 0; j < max; j++) {
            retArr[tmpIdx] = (char) (maxIdx + 'a');
            tmpIdx += 2;
        }
        for (int i = 0; i < letters.length; i++) {
            if (letters[i] > 0 && i != maxIdx) {
                for (int j = 0; j < letters[i]; j++) {
                    if (tmpIdx >= S.length()) tmpIdx = 1;
                    retArr[tmpIdx] = (char) (i + 'a');
                    tmpIdx += 2;
                }
            }
        }
        return String.valueOf(retArr);
    }
}
