import com.sun.xml.bind.v2.runtime.unmarshaller.XsiNilLoader;
import org.apache.commons.math3.util.Pair;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

/**
 * 〈leetcode 808〉
 *
 * @author He.H
 * @create 2018/11/10
 */
public class soupServings {
    public static double soupServing(int N) {
        HashMap<ArrayList<Integer>,Double> map = new HashMap<>();
        if (N==0)
            return 0.5;
        else
            return helper(N,N,map);
    }
    public static double helper(int a, int b, HashMap<ArrayList<Integer>, Double >map){
        ArrayList<Integer> tmp = new ArrayList<>();
        tmp.add(a);
        tmp.add(b);
        if(a<=0&&b<=0)
            return 0.5;
        if(a<=0)
            return 1;
        if(b<=0)
            return 0;
        if (map.containsKey(tmp))
            return map.get(tmp);
        double res = 0.25*(helper(a-100,b,map)+helper(a-75,b-25,map)+helper(a-50,b-50,map)+helper(a-25,b-75,map));
        map.put(tmp,res);
        return res;
    }
    public static void main(String[] args){
        System.out.println(soupServing(50));
    }

}