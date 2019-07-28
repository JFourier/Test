import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author He.H
 * @date 2019/7/17 21:20
 **/


public class List2LargestNumber {
/**
 * 给定一个正整型数组，将数组中各个元素组合成一个数，输出组合结果最大的那个数；
 *
 */

    public static void main(String[] args) {
        int [] arr = {9,3,32,33,303,34};    //93433332303
        System.out.println(getItem(arr));
    }
    public static String getItem(int [] arr){//重组arr，取出最大的数
        String [] strArr = new String[arr.length];
        Map<String,String> map = new HashMap<String,String>();
        int maxLen = 0;
        for(int i = 0 ; i < strArr.length ; i++){
            strArr[i] = String.valueOf(arr[i]);  //将整型数组转换为字符串数组
            if(strArr[i].length() > maxLen){
                maxLen = strArr[i].length();  //找到最长字符串的长度
            }
        }
        String[] strArrb = new String[arr.length];
        for(int i = 0 ;i < strArrb.length ; i++){
            strArrb[i] = strArr[i];
            int strLen = strArr[i].length();
            String s = strArr[i].substring(strLen-1,strLen);//找到该元素的最后一个字符
            for(int j = 0 ; j < maxLen - strLen ; j++){
                strArrb[i] += s ;//在原字符串下加上maxLen-strLen个字符s
            }
            if(map.containsKey(strArrb[i])){
                strArrb[i] +="_" + i ;//若map中已有该key值则将该key加上后缀"_i"
            }
            map.put(strArrb[i], strArr[i]);
        }
        Arrays.sort(strArrb);
        String res = "";
        for(int i = strArrb.length-1 ; i >= 0 ; i--){
            res += map.get(strArrb[i]);
        }
        return res;
    }
}
