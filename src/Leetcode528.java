import java.util.Random;

/**
 * @author He.H
 * @date 2019/1/14 16:01
 **/


public class Leetcode528 {
    private int[] sum;
    private Random rd;
    private int total;
    public Leetcode528(int[] w) {
        rd = new Random();
        sum = new int[w.length];
        total = 0;
        for (int i = 0; i < sum.length; i++) {
            total += w[i];
            sum[i] = total;
        }
    }

    public int pickIndex() {
        // target- 0~sum[last] - 1
        // find the index where sum[index] is the first number > target
        int target = rd.nextInt(sum[sum.length - 1]);
        int i = 0, j = sum.length - 1;
        while (i < j) {
            int mid = (i + j) / 2;
            if (sum[mid] <= target) {
                i = mid + 1;
            } else if (sum[mid] > target) {
                j = mid;
            }
        }
        return i;
    }
}
