package jianzhioffer;

/**
 * @author He.H
 * @date 2019/6/18 10:53
 **/


//调整数组，奇数在偶数前面
public class Offer13 {
    public void reOrderArray(int [] array) {
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
}
