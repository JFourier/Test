import java.util.ArrayList;
import java.util.List;

/**
 * 〈Arraylist〉
 *
 * @author He.H
 * @create 2018/9/16
 */
public class TestForQuickSort {
    public static void main(String[] args){
        ArrayList<Integer> tmp = new ArrayList<>();
        tmp.add(1);
        tmp.add(10);
        tmp.add(3);
        tmp.add(2);
        System.out.println(tmp.get(3));
        quickSort(tmp,0,3);
        System.out.println(tmp.get(3));
        System.out.println(tmp);
    }

    public  static void quickSort(ArrayList<Integer> a,int low,int high){
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