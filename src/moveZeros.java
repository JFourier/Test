/**
 * @author He.H
 * @date 2018/11/27 9:18
 **/


public class moveZeros {
    public static void main(String[] args){
        int[] a = {1, 0, 4, 0, 6};
        moveZeroes(a);
//        for (int item:a) {
//            //System.out.println(item);
//        }
        int res = 'A'-'z';
        System.out.println(res);
    }
    public static void moveZeroes(int[] nums) {
        int temp;
        int idx = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                temp = nums[idx];
                nums[idx] = nums[i];
                nums[i] = temp;
                idx++;
            }
        }
    }
}
