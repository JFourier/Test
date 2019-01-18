/**
 * @author He.H
 * @date 2019/1/17 20:18
 **/


public class Leetcode868 {
    private static int binaryGap(int N) {
        int gap = 0;
        int a=1,b=1;
        while(N%2==0){
            N/=2;
        }
        N/=2;
        b++;
        while(N>0){
            if(N%2==1){
                gap=Math.max(gap,b-a);
                a=b;
            }b++;
            N/=2;
        }
        return gap;
    }
    public static void main(String[] args){
        int N = 22;
        int res = binaryGap(N);
        System.out.println(res);
    }
}
