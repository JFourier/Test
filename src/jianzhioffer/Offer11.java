package jianzhioffer;


/**
 * @author He.H
 * @date 2019/6/18 10:48
 **/


//二进制中1的个数
public class Offer11 {
    public int NumberOf1(int n) {
        int count = 0;
        while (n != 0) {
            ++count;
            n = (n - 1) & n;
        }
        return count;
    }
}
