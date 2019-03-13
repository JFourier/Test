import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

/**
 * @author He.H
 * @date 2019/3/9 11:10
 **/


public class StrisNum {
    /**
     * 利用正则表达式
     * [\\+\\-]?                    正或负符号出现与否
     * \\d*                         整数部分是否出现，如-.34 或 +3.34均符合
     * (\\.\\d+)?                   如果出现小数点，那么小数点后面必须有数字；否则一起不出现
     * ([eE][\\+\\-]?\\d+)?         如果存在指数部分，那么e或E肯定出现，+或-可以不出现，紧接着必须跟着整数；或者整个部分都不出现
     *
     * @param str
     * @return
     */
    public boolean isNumeric(char[] str) {

        return new String(str).matches("[\\+\\-]?\\d*(\\.\\d+)?([eE][\\+\\-]?\\d+)?");
    }
    public static void main(String[] args){
        String a = "abcdefg";
        int k = 3;
        String res = new StringBuilder(a.substring(k,a.length())).append(a.substring(0,k)).toString();
        System.out.println(res);
    }
}
