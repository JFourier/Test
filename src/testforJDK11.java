import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.lang.Integer.bitCount;

/**
 * 〈〉
 *
 * @author He.H
 * @create 2018/11/14
 */
public class testforJDK11 {
    public static void main(String[] args) {
        String test = "hellllllllloo";
        test = test.replaceAll("(\\.)\2+", "$2");
        System.out.println(test);
    }
}