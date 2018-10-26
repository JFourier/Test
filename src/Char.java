/**
 * 〈char to int〉
 *
 * @author He.H
 * @create 2018/9/13
 */
public class Char {
    public static void main(String[] args){
        String a = "123";
        String c = "123";

        String b = new String("123");

        System.out.println(a==b);
        System.out.println(a==c);
        c = c+"1";
        System.out.println(a==c);
    }
}