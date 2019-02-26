import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author He.H
 * @date 2019/2/20 14:49
 **/


public class ArrayListTest {
    public static void main(String[] args){
        ArrayList Li = new ArrayList();
        System.out.println(Li.size());
        int[][] points = {{1,2},{2,3},{2,5},{1,4},{1,1}};
        Arrays.sort(points,(a,b)-> (a[1] - b[1]));
        for (int[] a: points)
            System.out.println(a);
    }
}
