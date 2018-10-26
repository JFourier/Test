import java.util.*;

/**
 * 〈〉
 *
 * @author He.H
 * @create 2018/9/28
 */
public class BoxNumber {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        ArrayList<Integer> input = new ArrayList<>();
        for(int i=0;i<n;i++){
            input.add(in.nextInt());//给数组赋值
        }
        HashMap<Integer,Integer> res = new HashMap<>();
        for(int i = 0;i<input.size();i++){
            if (!res.containsKey(input.get(i))){
                res.put(input.get(i),1);
            }else {
                int tmp = res.get(input.get(i));
                res.put(input.get(i),tmp+1);
            }
        }
        Collection<Integer> value = res.values();
        List<Integer> aa = new ArrayList<Integer>(value);
        quickSort((ArrayList<Integer>) aa,0, aa.size() -1);
        System.out.println(aa.get(aa.size()-1));
    }
    public  static void quickSort(ArrayList<Integer> a, int low, int high){
        int start = low;
        int end = high;
        int key = a.get(low);
        while(end>start){
            while(end>start&&a.get(end)>=key)
                end--;
            if(a.get(end)<=key){
                int temp = a.get(end);
                a.set(end,a.get(start));
                a.set(start,temp);
            }
            while(end>start&&a.get(start)<=key)
                start++;
            if(a.get(start)>=key){
                int temp = a.get(start);
                a.set(start,a.get(end));
                a.set(end,temp);
            }
        }
        if(start>low) quickSort(a,low,start-1);
        if(end<high) quickSort(a,end+1,high);
    }
}