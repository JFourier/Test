package leetcode;

import java.util.Scanner;


/**
 * 〈〉
 *
 * @author He.H
 * @create 2018/11/19
 */
public class leetcode338 {
    public static void main(String[] args){
        leetcode338 A = new leetcode338();

        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        int[] res;
        res = A.countBits(num);
        for (int i = 0; i<res.length; i++){
            System.out.print(res[i]);
        }
    }
    public int[] countBits(int num) {
        int[] res = new int[num + 1];
        res[0] = 0;
        int base = 1;//末尾为1的情况
        while(base <= num){
            int next = base * 2;//下一个末尾全为0的值
            for(int i = base;i<next && i<=num;i++){
                res[i] = res[i-base]+1;
            }
            base = next;
        }
        return res;
    }
}