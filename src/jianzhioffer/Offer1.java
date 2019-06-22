package jianzhioffer;

/**
 * @author He.H
 * @date 2019/6/18 10:21
 **/

//二维数组中的查找
public class Offer1 {
    public boolean Find(int target, int [][] array) {
        if(array.length==0 || array[0].length==0) return false;
        int i=0, j=array[0].length-1;
        while(i<array.length && j>=0) {
            int x = array[i][j];
            if(target == x) return true;
            else if(target < x) --j;
            else ++i;
        }
        return false;
    }
}
