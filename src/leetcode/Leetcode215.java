package leetcode;

import java.util.PriorityQueue;

/**
 * @author He.H
 * @date 2019/2/23 10:19
 **/


public class Leetcode215 {
    public int findKthLargest(int[] nums, int k) {
        if(k > nums.length || k < 1)
            return Integer.MIN_VALUE;
        PriorityQueue<Integer> pq = new PriorityQueue<>(k);
        for(int i=0;i<k;i++) {
            pq.add(nums[i]);
        }
        for(int i=k;i<nums.length;i++) {
            if(nums[i] > pq.peek()) {
                pq.poll();
                pq.add(nums[i]);
            }
        }
        return pq.peek();
    }



}
