/**
 * @author He.H
 * @date 2019/1/28 19:26
 **/


public class Leetcode9 {
    public static boolean isPalindrome(int x) {
        //return String.valueOf(x).equals(new StringBuffer(x+"").reverse().toString());
        if (x < 0) return false;
        int a = x, r = 0;

        while (a > 0) {
            r = r * 10 + a % 10;
            a = a / 10;
        }
        return r == x;
    }
    public static void main(String[] args){
        int x = 1221;
        System.out.println(isPalindrome(x));
    }

}
