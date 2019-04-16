import java.util.ArrayList;
import java.util.Comparator;
import java.util.stream.StreamSupport;

/**
 * @author He.H
 * @date 2019/3/4 16:31
 **/


public class Zhaoyin {
    public static void main(String[] args) {
        ArrayList<Integer[]>  t = new ArrayList<>();
        Integer[][] input = new Integer[][]{{50,2},{50,1},{100,50},{100,10},{100,0}};
        for ( Integer[] tmp: input) {
            t.add(tmp);
        }
        t.sort(Comparator.comparingInt((Integer[] a) -> a[1]));
        t.sort((Integer[] a, Integer[] b) -> b[0]-a[0]);

        for (Integer[] tmp: t
             ) {
            System.out.println(tmp[1]);
        }
    }
}
