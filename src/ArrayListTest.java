import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

/**
 * @author He.H
 * @date 2019/2/20 14:49
 **/


public class ArrayListTest {
    public static void main(String[] args){
//        ArrayList Li = new ArrayList();
//        System.out.println(Li.size());
//        int[][] points = {{1,2},{2,3},{2,5},{1,4},{1,1}};
//        Arrays.sort(points,(a,b)-> (a[1] - b[1]));
//        for (int[] a: points)
//            System.out.println(a);
//        StringBuilder a = new StringBuilder();
//        LinkedList b = new LinkedList();
        for (int i = 0; i < 10; i++) {
            if (i == 1)
                continue;
            if (i == 4)
                break;
            System.out.println(i);
        }
    }
}
