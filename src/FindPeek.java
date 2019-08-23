/**
 * @author He.H
 * @date 2019/8/19 9:17
 **/


public class FindPeek {
    //找峰值，先升后降
    public int findPeek(int[] nums) {
        if(nums.length < 3){
            return -1;
        }
        int start = 1;
        int end = nums.length-1;
        while(start <= end){
            int middle = start + (end - start) / 2;
            if(nums[middle] < nums[middle-1]){
                //出现下降
                end = middle-1;
            }
            else if(nums[middle] < nums[middle+1]){
                //出现上升
                start = middle+1;
            }
            else {
                return middle;
            }
        }
        return -1;
    }

    //找谷值
    public static int find(int[] nums) {
        if(nums.length < 3){
            return -1;
        }
        int start = 1;
        int end = nums.length-1;
        while(start <= end){
            int middle = start + (end - start) / 2;
            if(nums[middle] > nums[middle+1]){
                //出现下降
                start = middle+1;
            } else if(nums[middle] > nums[middle-1]){
                //出现上升
                end = middle-1;
            } else {
                return middle;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {3,1,0,2,4,5};
        System.out.println(find(arr));
    }
}
