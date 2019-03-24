package Bishi;

/**
 * @author He.H
 * @date 2019/3/17 20:37
 * 搬桌子的最小代价
 *
 * https://blog.csdn.net/abc7845129630/article/details/51250207
 *
 * https://www.nowcoder.com/questionTerminal/ba2b1a3cf03c460f88f406d69e607292?orderByHotValue=0&questionTypes=000100&done=0&pos=1&onlyReference=false
 **/
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class ZhaoYin3 {
    public static void main(String[] args) {
        int n;
        int minCount=0;
        Scanner in=new Scanner(System.in);
        ArrayList<Integer> li = new ArrayList<Integer>();
        ArrayList<Integer> di = new ArrayList<Integer>();
        int[] a = new int[100001];
        n=in.nextInt();
        for(int i=0;i<n;i++){
            int temp=in.nextInt();
            li.add(temp);
            a[temp]+=1;
        }
        for(int i=0;i<n;i++){
            int tmp=in.nextInt();
            di.add(tmp);
            minCount+=tmp;
        }
        for(int i=100000;i>0;i--){
            int cost=0;
            ArrayList<Integer> cut = new ArrayList<Integer>();
            if(a[i]>0){
                if(a[i]*2<=n){
                    int cutNum = li.size()-a[i];
                    for(int j=i+1;j<100000;j++){
                        cutNum-=a[j];
                    }
                    cutNum-=(a[i]-1);

                    for(int k=0;k<li.size();k++){
                        if(li.get(k)<i){
                            cut.add(di.get(k));
                        }
                        if(li.get(k)>i){
                            cost+=di.get(k);
                        }
                    }
                    if(cut.size()>0){
                        if(cutNum<=0){
                            cutNum=0;
                        }
                        Collections.sort(cut);
                        for(int k=0;k<cutNum;k++){
                            cost+=cut.get(k);
                        }
                        if(cost<minCount){
                            minCount=cost;
                        }
                    }
                }else{
                    for(int k=0;k<li.size();k++){
                        if(li.get(k)>i){
                            cost+=di.get(k);
                        }
                    }
                }
                if(cost<minCount){
                    minCount=cost;
                }
            }
        }
        System.out.println(minCount);
    }
}
