package Bishi;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author He.H
 * @date 2019/8/16 17:29
 **/


public class Kedaxunfei {
    public static void main(String[] args) {
        StringBuffer input = new StringBuffer("爱讯飞789swr1wwen34ifly65tek");
        numbers(input);
    }

    public static void numbers(StringBuffer s) {
        List<Character> numbers = new ArrayList<Character>();
        for (int i = 0; i != s.length(); i++) {
            if (('0' <= s.charAt(i)) && (s.charAt(i) <= '9')) {
                numbers.add(s.charAt(i));
            }
        }
        Collections.sort(numbers);
        for (int i = 0; i != numbers.size(); i++) {
            System.out.print(numbers.get(i));
        }
    }
}
