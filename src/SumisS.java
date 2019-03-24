import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author He.H
 * @date 2019/3/9 10:09
 **/


public class SumisS {
    public ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
        Queue<Integer> t = new LinkedList<Integer>();
        int cnt = 0;
        ArrayList<ArrayList<Integer>> result = new  ArrayList<>();
        if(sum<2){
            return result;
        }
        for (int i = 1; i <= sum/2+2; i++) {
            t.offer(i);
            cnt += i;
            if (cnt<sum){
                continue;
            }else if(cnt>sum) {
                while (cnt>sum) {
                    cnt -= t.poll();
                    if (cnt == sum && t.size()!=1){
                        result.add(makeres(t));
                    }
                }
            }else {
                if (t.size()!=1){
                    result.add(makeres(t));
                }
            }
        }
        return result;
    }
    public ArrayList<Integer> makeres(Queue<Integer> tmp) {
        ArrayList<Integer> res = new ArrayList<>();
        for (int i: tmp ) {
            res.add(i);
        }
        return res;
    }
}
class TestforSumisS{
    public static void main(String[] args){
        SumisS test = new SumisS();
        int sum = 9;
        ArrayList<ArrayList<Integer>> res = test.FindContinuousSequence(sum);
        for (ArrayList a:res) {
            System.out.println(a);
        }
    }
}
