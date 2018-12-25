import edu.princeton.cs.algs4.In;

import java.util.ArrayList;
import java.util.List;

/**
 * @author He.H
 * @date 2018/12/25 14:31
 **/


public class Leetcode120 {
    public static int minimumTotal(List<List<Integer>> triangle) {
        int[] res = new int[triangle.size()+1];
        for (int i = triangle.size()-1; i >= 0; i--){
            for (int j = 0; j < triangle.get(i).size(); j++){
                res[j] = Math.min(res[j], res[j+1]) + triangle.get(i).get(j);
            }
        }
        return res[0];
    }
    public static void main(String[] args){
        List<List<Integer>> tr = new ArrayList<>();
        List<Integer> t0 = new ArrayList<>(){{add(2);}};
        List<Integer> t1 = new ArrayList<>(){{add(3);add(4);}};
        List<Integer> t2 = new ArrayList<>(){{add(6);add(5);add(7);}};
        List<Integer> t3 = new ArrayList<>(){{add(4);add(1);add(8);add(3);}};
        tr.add(t0);
        tr.add(t1);
        tr.add(t2);
        tr.add(t3);

        int res = minimumTotal(tr);
        System.out.println(res);
    }
}
