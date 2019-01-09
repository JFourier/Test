/**
 * @author He.H
 * @date 2019/1/8 16:50
 **/


public class Leetcode762 {
    public int countPrimeSetBits(int L, int R) {
        int count = 0;
        for(int i=L;i<=R;i++){
            if(isPrime(Integer.bitCount(i))){
                count++;
            }
        }
        return count;
    }

    public boolean isPrime(int x){
        return (x == 2 || x == 3 || x == 5 || x == 7 ||
                x == 11 || x == 13 || x == 17 || x == 19);
    }

    public static void main(String[] args){
        System.out.println(Integer.bitCount(6));
    }
}
