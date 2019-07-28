package Bishi;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author He.H
 * @date 2019/7/28 14:42
 **/


public class PDD1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String i = scanner.nextLine();
        String[] h = i.split(" ");
        int[] A = new int[h.length];
        for (int j = 0; j < h.length; j++) {
            A[j] = Integer.parseInt(h[j]);
        }

        String i1 = scanner.nextLine();
        String[] h1 = i1.split(" ");
        int[] B = new int[h1.length];
        for (int j = 0; j < h1.length; j++) {
            B[j] = Integer.parseInt(h1[j]);
        }

        int index = -1;
        for (int j = 0; j < A.length-1; j++) {
            if (A[j+1]>=A[j]) {
                continue;
            } else {
                index = j+1;
                break;
            }
        }

        Arrays.sort(B);
        int index2 = -1;
        for (int j = B.length-1; j > 0; j--) {
            if (index == 0){
                if (B[j]<A[index+1]) {
                    index2=j;
                    break;
                }
            }else if (index == A.length-1) {
                if (B[j]>A[index-1]) {
                    index2=j;
                    break;
                }
            }else {
                if (B[j]<A[index+1] && B[j]>A[index-1]) {
                    index2=j;
                    break;
                }
            }
        }

        if (index2 == -1 ) {
            System.out.println("NO");
        }else {
            A[index] = B[index2];
            for (int j = 0; j < A.length; j++) {
                if (j!=A.length-1) {
                    System.out.print(A[j]+" ");
                } else {
                    System.out.print(A[j]);
                }
            }
        }
    }
}
