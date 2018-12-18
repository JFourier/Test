import java.util.*;

/**
 * @author He.H
 * @date 2018/12/18 9:07
 * leetcode 503
 **/


public class NextGreaterElement {
    public static int[] nextGreaterElements(int[] nums) {
        List<Integer> result = new ArrayList<>();
        int flag = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length; j++) {
                if (nums[j]>nums[i]) {
                    flag = 1;
                    result.add(nums[j]);
                    break;
                }
            }
            if (flag == 0) {
                for (int k = 0; k < i; k++) {
                    if (nums[k]>nums[i]) {
                        flag = 1;
                        result.add(nums[k]);
                        break;
                    }
                }
                if (flag == 0)
                    result.add(-1);
            }
            flag = 0;
        }
        int l = result.size();
        int[] res = new int[l];
        for(int i = 0; i<l; i++){
            res[i] = result.get(i);
        }
        return res;
    }


    public static int[] nextGreaterElements2(int[] nums) {
        //存储nums索引值，最后留下的元素为nums最大值的下标
        Deque<Integer> stack = new ArrayDeque<>();
        int len  = nums.length;
        int[] res = new int[len];
        //Arrays.fill,将res中每个位置都填为 -1
        Arrays.fill(res, -1);
        for (int i = 0; i < 2 * len; i++) {
            int num = nums[(i+len) % len];
            while (!stack.isEmpty() && num > nums[stack.peek()]) {
                res[stack.pop()] = num;
            }
            // use for second round
            if (i < len) stack.push(i);
            if (stack.isEmpty()) break;
        }

        return res;
    }
    public static void main(String[] args){
        int[] input = {1,2,1};
        int[] res = nextGreaterElements2(input);
        for (int x:res
             ) {
            System.out.println(x);
        }
    }


}
