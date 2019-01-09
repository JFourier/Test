/**
 * @author He.H
 * @date 2019/1/8 16:48
 **/


public class Prime {
    public static boolean isPrime(int num){
        boolean isprime=true;
        int len=num/2;
        for(int i=2;i<len;i++){
            if(num%i==0){
                isprime=false;
                break;
            }
        }
        return isprime;
    }
}
