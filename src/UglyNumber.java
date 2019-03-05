/**
 * @author He.H
 * @date 2019/3/4 18:16
 **/


public class UglyNumber {
    public static int GetUglyNumber_Solution(int index) {
        int count = 0;
        int i;
        for(i=1;count<=index;i++){
            if(isUgly(i))
                count++;
        }
        return i;
    }
    public static boolean isUgly(int number){
        while(number % 2 == 0)
            number/=2;
        while(number % 3 == 0)
            number /=3;
        while(number % 5 == 0)
            number /=5;
        return (number ==1)? true:false;
    }
    public static void main(String[] args){
        int n = 2;
        int res = GetUglyNumber_Solution(n);
        System.out.println(res);
    }
}
