import java.util.ArrayList;

/**
 * 〈〉
 *
 * @author He.H
 * @create 2018/9/7
 */
public class fun {
    public long gcd(long m,long n){//just for test
        while (n!=0){
            long rem = m%n;
            m = n;
            n = rem;
        }
        return m;
    }
    public static void main(String[] args){
        fun d = new fun();
        long a =0;
        a = (long) d.gcd(50,15);
        System.out.println(a);
        boolean q = false;
        ArrayList qq = new ArrayList();
        qq.add(1);
        qq.add(2);
        for (Object i:
             qq) {
            System.out.println(i);
        }
    }
}
