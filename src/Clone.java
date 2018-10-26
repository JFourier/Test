import java.util.ArrayList;
import java.util.Scanner;

/**
 * 〈已知k，k=x1*x2...*xn，求min(x1+x2+...+xn+n)〉
 *
 * @author He.H
 * @create 2018/9/29
 */
public class Clone {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        ArrayList<Integer> res = new ArrayList<>();
        if (isPrime(n)){
            System.out.println(n+1);
        }else {
            for (int i =2;i<n;i++){
                while (n%i==0){
                    res.add(i);
                    n = n/i;
                }
            }
            if (n>1){
                res.add(n);
            }
        }
        int sum = 0;
        int count2 = 0;
        int result = 0;
        for (int i : res){
            sum+=i;
            if (i ==2){
                count2++;
            }
        }
        sum = sum+res.size();
        result = sum-count2/2;
        System.out.println(result);
    }
    public static boolean isPrime(int num){
        boolean isprime = true;
        int len = num/2;
        for(int i =2; i<len; i++){
            if (num % i == 0){
                isprime = false;
                break;
            }
        }
        return isprime;
    }
}