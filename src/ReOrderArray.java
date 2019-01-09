/**
 * 调整数组，使得奇数在偶数前面且相对位置不变
 * @author He.H
 * @date 2019/1/9 10:24
 **/


public class ReOrderArray {
    public static void reOrderArray(int [] array) {
        int temp;
        for(int i=0;i<array.length; i++){
            for(int j=0; j<array.length-i-1; j++){
                if(array[j]%2==0 && array[j+1]%2==1){
                    temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                }
            }
        }
    }

    public static void main(String[] args){
        int[] test = {2,3,5,7,1,8,9,0};
        reOrderArray(test);
        for (int a :
             test) {
            System.out.println(a);
        };
    }
}
