package String;

/**
 * @author He.H
 * @date 2019/1/8 19:48
 **/


public class ReplaceSpace {
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
