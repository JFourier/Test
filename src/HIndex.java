import java.util.Arrays;

/**
 * @author He.H
 * @date 2018/12/17 9:42
 * Leetcode 274
 **/


public class HIndex {
    public static void main(String[] args){
        int[] a = {1, 0, 5, 3, 6};
        int res = hIndexII(a);
        System.out.println(res);
    }
    public static int hIndex(int[] citations) {
        ////降序排序，找到序号比引用次数大的位置，返回减一即可
        //实际实现中，为升序排列，从后开始读取，且标号从 1 开始
        if (citations.length == 0) {
            return 0;
        }
        Arrays.sort(citations);
        int h = 0;
        for (int i = citations.length - 1; i >= 0; i--) {
            if (citations.length - i > citations[i]) {
                h = citations.length - i;
                break;
            }
            if (i == 0) {
                h = citations.length + 1;
            }
        }
        return h - 1;
    }
    public static int hIndexII(int[] citations) {
        //二分查找
        int n = citations.length;

        int low=0, high=n-1;

        while(low<=high) {
            int mid  = low + (high-low)/2;
            if(citations[mid] == n-mid)
                // x = n-mid 为第x大的数
                return n-mid;
            else if(citations[mid] < n-mid)
                low = mid+1;
            else
                high = mid-1;
        }
        return n-low;
    }
}
