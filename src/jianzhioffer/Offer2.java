package jianzhioffer;

/**
 * @author He.H
 * @date 2019/6/18 10:22
 **/


//替换空格
public class Offer2 {
    public String replaceSpace(StringBuffer str) {
        for (int i = 0; i < str.length(); i++) {
            char ch1 = str.charAt(i);
            if(ch1 == ' '){
                str.replace(i, i+1, "%20");
            }
        }
        return str.toString();
    }
}
