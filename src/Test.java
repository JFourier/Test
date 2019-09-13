import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * 〈〉
 *
 * @author He.H
 * @create 2018/9/4
 */
public class Test {
    public static void main(String[] args){
        int[] nums = new int[] {1,2,3,4,5};
        int target = 5;
        ArrayList<Integer> res = solve(nums, target);

        for(int i : res) {
            System.out.println(i);
        }
    }
    public static ArrayList<Integer> solve(int[] nums, int target) {
        ArrayList<Integer> res = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int diff = target - nums[i];
            if (map.containsKey(nums[i])) {
                res.add(map.get(nums[i]));
                res.add(i);
                break;
            }
            map.put(diff, i);
        }
        return res;
    }
}


