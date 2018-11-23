
/**
 * 〈leetcode 29〉
 *
 * @author He.H
 * @create 2018/11/23
 */
public class devide {
    public static void main(String[] args){
        int res = divide(23, 4);
        System.out.println(res);
    }
    public static int divide(int dividend, int divisor) {
        boolean positive = (dividend > 0 && divisor > 0)
                || (dividend < 0 && divisor < 0);
        long absDividend = Math.abs((long) dividend);
        long absDivisor = Math.abs((long) divisor);

        int ret = dividePositive(absDividend, absDivisor);
        return positive ? ret : -ret;
    }

    private static int dividePositive(long dividend, long divisor) {
        // The first loop computes i.
        int i = 0;
        while (dividend >= divisor << 1) {
            divisor <<= 1;
            i++;
        }
        // The second loop computes the sum of non-zero coefficients.
        int ret = 0;
        while (i >= 0) {
            if (dividend >= divisor) {
                dividend -= divisor;
                ret += 1 << i;
            }
            divisor >>= 1;
            i--;
        }
        return ret;
    }


}