/**
 * @author He.H
 * @date 2018/12/27 10:32
 **/


public class SuperUglyNumber {
    public static int nthSuperUglyNumber(int n, int[] primes) {
        int[] dp = new int[n];
        // 第一个超级丑数是1
        dp[0] = 1;
        int[] idxPrimes = new int[primes.length];
        int counter = 1;
        while (counter < n) {
            int min = Integer.MAX_VALUE;
            for (int i = 0; i < primes.length; i++) {
                // idxPrimes[i]代表每个丑数的个数，
                // 比如丑数2题目的2，3，5，
                // idxPrimes[0]代表2的下标
                // idxPrimes[1]代表3的下标
                // idxPrimes[2]代表5的下标
                int temp = dp[idxPrimes[i]] * primes[i];
                min = min < temp ? min : temp;
            }
            // 如果min和 dp[idxPrimes[i]] * primes[i]相等，
            // 则其对应的下标++
            for (int i = 0; i < primes.length; i++) {
                if (min == dp[idxPrimes[i]] * primes[i]) {
                    idxPrimes[i]++;
                }
            }
            dp[counter] = min;
            counter++;
        }
        return dp[n - 1];
    }


    public static void main(String[] args){
        int n = 12;
        int[] p = new int[]{2, 7, 13, 19};
        int res = nthSuperUglyNumber(n, p);
        System.out.println(res);

    }
}
