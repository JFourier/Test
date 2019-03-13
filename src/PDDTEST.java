import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author He.H
 * @date 2019/3/10 16:29
 **/


public class PDDTEST {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Integer> input1 = new ArrayList<>();
        ArrayList<Integer> input2 = new ArrayList<>();
        for (int i = 0; i < n ; i++) {
            input1.add(sc.nextInt());
        }
        for (int i = 0; i < n ; i++) {
            input2.add(sc.nextInt());
        }
        quickSort(input1,0,n-1);
        quickSort(input2,0,n-1);

        int ans = 0;
        for(int i = 0; i < n; i++){
            ans += input1.get(i)*input2.get(n-i-1);
        }
        System.out.println(ans);
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
