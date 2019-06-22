package jianzhioffer;

/**
 * @author He.H
 * @date 2019/6/18 10:51
 **/

//数值的整数次方
public class Offer12 {
    public double Power(double base, int exponent) {
        double res = 1;
        if(exponent == 0)
            return res;
        if(exponent == 1)
            return base;
        if(exponent == -1)
            return 1/base;
        res = base;
        int exp = Math.abs(exponent);
        while(exp>1){
            res = res*base;
            exp--;
        }
        if (exponent < 0)
            return 1/res;
        return res;
    }
}
