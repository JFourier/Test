/**
 * @author He.H
 * @date 2019/7/23 9:09
 **/


public class YuesefuCircle {
    public static void main(String[] args) {
        int n=5, m=3;
        System.out.println(f(n,m));
    }

    /*
    *  old = (new + m - 1) % n + 1
    * */
    public static int f(int n, int m){
        if(n == 1)   return n;
        return (f(n - 1, m) + m - 1) % n + 1;
    }
}
