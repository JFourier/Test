import java.util.Scanner;

/**
 * 〈统计f(n)=1!*2*...*n!最后有多少个0〉
 *
 * @author He.H
 * @create 2018/9/15
 */
public class RedBook {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int input = scanner.nextInt();
        int ans = 0;
        for (int i = input; i>1;i--){
            ans = ans+trailingZeroes(i);
        }
        System.out.println(ans);
    }
    public  static int trailingZeroes(int n) {
        int count=0;
        while(n!=0){
            count+=n/5;
            n=n/5;
        }
        return count;
    }
}
