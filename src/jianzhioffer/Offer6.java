package jianzhioffer;

/**
 * @author He.H
 * @date 2019/6/18 10:37
 **/


//旋转数组中的最小值
public class Offer6 {
    public int minNumberInRotateArray(int [] array) {
        if (array.length == 0)
            return 0;
        int index = 0;
        for (int i = 1; i<array.length; i++){
            if(array[i]<array[i-1])
                index = i;
        }
        return array[index];
    }
}
