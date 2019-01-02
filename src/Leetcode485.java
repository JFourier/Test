/**
 * @author He.H
 * @date 2019/1/2 14:06
 **/


public class Leetcode485 {
    private static int findMaxConsecutiveOnes(int[] nums) {
        int max=0,one=0;
        for (int i=0;i<nums.length;i++) {
            if(nums[i]==1) {
                one++;
            }else one = 0;
            max=Math.max(max, one);
        }
        return max;
    }
    public static void main(String[] args){
        int[] a = {1,1,0,1,1,1,1,0,0,1,1,1};
        int res = findMaxConsecutiveOnes(a);
        System.out.println(res);
    }
}
