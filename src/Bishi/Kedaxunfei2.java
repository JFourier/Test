package Bishi;

import java.util.Scanner;

/**
 * @author He.H
 * @date 2019/8/16 17:29
 **/


public class Kedaxunfei2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


    }
    private static int solve(int[] input, int start, int end, int searchKey){
        if (start <= end) {
            int middle =  (start+end)/2;
            if (searchKey == input[middle]) {
                return middle;
            } else if (searchKey < input[middle]) {
                return solve(input, start, middle - 1, searchKey);
            } else {
                return solve(input, middle + 1, end, searchKey);
            }
        } else {
            return -1;
        }
    }

}
