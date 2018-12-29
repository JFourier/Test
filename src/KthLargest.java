import java.util.PriorityQueue;
import java.util.Queue;

/**
 * leetcode 703
 * @author He.H
 * @date 2018/12/28 20:28
 **/


public class KthLargest {
    private Queue<Integer> heap;
    private int maxSize;
    public KthLargest(int k, int[] nums) {
        heap = new PriorityQueue<>(k);
        maxSize = k;
        for (int num:nums) {
            this.add(num);
        }
    }

    public int add(int val) {
        if (heap.isEmpty() || heap.size() < maxSize) {
            heap.add(val);
        } else if (val > heap.peek()) {
            heap.poll();
            heap.add(val);
        }
        return heap.peek();
    }
}
