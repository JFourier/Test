package lambda;

import java.util.HashMap;

/**
 * @author He.H
 * @date 2019/10/28 10:43
 **/


public class AsIter {
    public static void main(String[] args) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(1,2);
        map.put(3,4);
        map.forEach((k,v) -> System.out.println(k+":" + v));
    }
}
