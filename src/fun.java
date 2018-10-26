/**
 * 〈〉
 *
 * @author He.H
 * @create 2018/9/7
 */
public class fun {
    public static long gcd(long m,long n){
        while (n!=0){
            long rem = m%n;
            m = n;
            n = rem;
        }
        return m;
    }
    public static void main(String[] args){
        long a =0;
        a =gcd(50,15);
        System.out.println(a);
    }
}
