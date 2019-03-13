import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @author He.H
 * @date 2019/3/10 17:46
 **/


public class PDDTEST3 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        ArrayList<Integer[]> list = new ArrayList<>();
            int n = in.nextInt();
            int d = in.nextInt();

            for (int i = 0; i < n; i++) {
                Integer[] tmp = new Integer[2];
                tmp[0] = in.nextInt();
                tmp[1] = in.nextInt();
                list.add(tmp);
            }

        list.sort((Integer[] a,Integer[] b)->a[0]-b[0]);//升序
        int res=0;
        for(int i=0;i<n;i++){
            for(int j=n-1;j>i;j--){
                if(list.get(j)[0]-list.get(i)[0]>=d){
                    if((list.get(j)[1]+list.get(i)[1])>res){
                        res=list.get(i)[1]+list.get(j)[1];//更新res;
                    }
                }
                else{
                    break;
                }
            }
        }
        System.out.println(res);
    }
}
