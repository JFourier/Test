import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

import static java.lang.Integer.bitCount;

/**
 * 〈〉
 *
 * @author He.H
 * @create 2018/11/14
 */
public class testforJDK11 {
    public static void main(String[] args) {
        int n = -5;
        int a = Math.abs(n);
        int c = bitCount(n);
        System.out.println(c);
    }
}