package leetcode;

/**
 * @author He.H
 * @date 2019/4/12 10:18
 **/


public class Leetcode992 {
    public int subarraysWithKDistinct(int[] A, int K) {
        return alltheKs(A,K) - alltheKs(A,K-1);
    }
    private int alltheKs(int[] A,int k) {
        int i = 0;
        int result = 0;
        int[] count = new int[A.length+1];
        for (int j = 0; j < A.length; j++) {
            if (count[A[j]]++ == 0) k--;
            while(k < 0) {
                if(--count[A[i++]] == 0) k++;
            }
            result += j - i + 1;
        }
        return result;
    }
}
