/**
 * 〈StringBuider〉
 *
 * @author He.H
 * @create 2018/9/9
 */
public class ReverseString {
    public static String reverseString(String s) {
        final String s1 = new StringBuilder(s).reverse().toString();
        return s1;
    }
    public static void main(String[] args){
        String s = "hellobans;lala,";
        String b = reverseString(s);
        System.out.println(b);
    }
}