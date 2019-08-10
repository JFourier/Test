package leetcode;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author He.H
 * @date 2019/8/6 15:51
 **/
//将信封数组按照宽“升序”排序以后，信封数组的高的“最长上升子序列”的长度就是题目所求。
//
// 在宽度相等的时候，高度不能出现“上升的子序列”，首先按照宽度“升序排序”，
// 在宽度相等的手，高度“降序排序”，宽度相等的信封，最多只能选一个，这种策略保证了结果的正确性。
// 这就是最开始的说明中的第 1 点缺少的正确性的另一半。
//

public class Leetcode354 {
    public int maxEnvelopes(int[][] envelopes) {

        int len = envelopes.length;
        if (len < 2) {
            return len;
        }

        Arrays.sort(envelopes, new Comparator<int[]>() {
            @Override
            public int compare(int[] envelope1, int[] envelope2) {
                if (envelope1[0] != envelope2[0]) {
                    return envelope1[0] - envelope2[0];
                }
                return envelope2[1] - envelope1[1];
            }
        });


        int[] tail = new int[len];
        tail[0] = envelopes[0][1];

        // end 表示有序数组 tail 的最后一个已经赋值元素的索引
        int end = 0;

        for (int i = 1; i < len; i++) {
            int target = envelopes[i][1];

            if (target > tail[end]) {
                end++;
                tail[end] = target;
            } else {
                int left = 0;
                int right = end;

                while (left < right) {
                    int mid = (left + right) >>> 1;
                    if (tail[mid] < target) {
                        left = mid + 1;
                    } else {
                        right = mid;
                    }
                }
                tail[left] = target;
            }
        }
        return end + 1;
    }
}
