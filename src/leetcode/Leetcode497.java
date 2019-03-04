package leetcode;

import java.util.Random;

/**
 * @author He.H
 * @date 2019/1/14 15:14
 **/


public class Leetcode497 {
    private int[][] rects;
    private Random rd;
    private int[] sum;
    private int total;

    public Leetcode497(int[][] rects) {
        this.rects = rects;
        this.rd = new Random();
        int[] weight = new int[rects.length];
        for (int i = 0; i < rects.length; i++) {
            weight[i] = (rects[i][2] - rects[i][0] + 1) * (rects[i][3] - rects[i][1] + 1);
        }
        this.sum = new int[weight.length];
        this.total = 0;
        for (int i = 0; i < sum.length; i++) {
            total += weight[i];
            sum[i] = total;
        }
    }

    public int[] pick() {
        int[] rect = rects[pickRect()];
        int x = rect[0] + rd.nextInt(rect[2] - rect[0] + 1);
        int y = rect[1] + rd.nextInt(rect[3] - rect[1] + 1);
        return new int[] {x, y};
    }

    private int pickRect() {
        int target = rd.nextInt(total);
        int i = 0, j = sum.length - 1;
        while (i < j) {
            int mid = (i + j) / 2;
            if (sum[mid] > target) {
                j = mid;
            } else {
                i = mid + 1;
            }
        }
        return i;
    }
}
