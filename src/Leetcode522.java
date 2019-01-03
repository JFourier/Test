import java.util.Arrays;
import java.util.HashMap;

/**
 * @author He.H
 * @date 2019/1/3 16:55
 **/


public class Leetcode522 {
    public static int findPairs(int[] nums, int k) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        int count = 0;
        for(Integer num : nums){
            if(k == 0 && hashMap.getOrDefault(num, 0)>0 && hashMap.get(num)<2){
                count ++;
                hashMap.put(num, 2);
            }else if(k == 0 && hashMap.getOrDefault(num, 0)>0){
            }else{
                hashMap.put(num, 1);
            }
        }
        if(k > 0){
            for(Integer key:hashMap.keySet()){
                if(hashMap.getOrDefault(key+k, 0)>0){
                    count++;
                }
            }
        }
        return count;
    }

    private static int findPairs1(int[] nums, int k) {
        if(k<0 || nums.length<=1){
            return 0;
        }
        Arrays.sort(nums);
        int count = 0;
        int left = 0;
        int right = 1;

        while(right<nums.length){
            int firNum = nums[left];
            int secNum = nums[right];
            if(secNum-firNum<k)
                right++;
            else if(secNum - firNum>k)
                left++;
            else{
                count++;
                while(left<nums.length && nums[left]==firNum){
                    left++;
                }
                while(right<nums.length && nums[right]==secNum){
                    right++;
                }

            }
            if(right==left){
                right++;
            }
        }
        return count;
    }
    public static void main(String[] args){
        int[] nums = {3,1,4,1,5,7};
        int k = 2;
        int res = findPairs1(nums, k);
    }
}
