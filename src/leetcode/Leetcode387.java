package leetcode;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author He.H
 * @date 2019/3/5 11:22
 **/


public class Leetcode387 {
    public int firstUniqChar(String s) {
        Map<Character,Integer> map = new LinkedHashMap<Character,Integer>();
        char[] arr = s.toCharArray();
        for(int i =0;i<arr.length;i++){
            if(!map.containsKey(arr[i])){
                map.put(arr[i],i);
            }else{
                map.put(arr[i],-1);
            }
        }
        for(Map.Entry<Character,Integer> entry :map.entrySet()){
            if(entry.getValue()!=-1){
                return entry.getValue();
            }
        }
        return -1;
    }
}
