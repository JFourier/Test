import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author He.H
 * @date 2018/12/22 9:52
 **/


public class Sum {
    public static void main(String[] args){

    }

    //找出三数之和为0 的所有方法，不能重复
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        for(int i = 0; i < nums.length; i++){
            if(nums[i] > 0) break;
            if(i > 0 && nums[i] == nums[i - 1]) continue;
            int target = 0 - nums[i];
            int k = i + 1;
            int j = nums.length - 1;
            while(k < j){
                if(nums[k] + nums[j] == target){
                    List<Integer> item = Arrays.asList(nums[i], nums[k], nums[j]);
                    res.add(item);
                    while(k < j && nums[k] == nums[k + 1]) k++;
                    while(k < j && nums[j] == nums[j - 1]) j--;
                    k++;
                    j--;
                }else if(nums[k] + nums[j] < target){
                    k++;
                }else{
                    j--;
                }
            }
        }
        return res;
    }
}
