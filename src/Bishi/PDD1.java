package Bishi;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author He.H
 * @date 2019/7/28 14:42
 *
 **/

//给定两个数组A和B，其中数组A是几乎严格升序排列的，几乎的定义是只需改变其中一个数，即可满足完全升序排列。
//你的任务是从A中找到这个数组，并从数组B中选取一个数将其代替，使得A是严格升序排列的，
//请找出B中满足要求的最大数字，并输出有序数组，如不存在则输出NO。

public class PDD1 {

    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//
//        String i = scanner.nextLine();
//        String[] h = i.split(" ");
//        int[] A = new int[h.length];
//        for (int j = 0; j < h.length; j++) {
//            A[j] = Integer.parseInt(h[j]);
//        }
//
//        String i1 = scanner.nextLine();
//        String[] h1 = i1.split(" ");
//        int[] B = new int[h1.length];
//        for (int j = 0; j < h1.length; j++) {
//            B[j] = Integer.parseInt(h1[j]);
//        }
//
//        int index = -1;
//        for (int j = 0; j < A.length-1; j++) {
//            if (A[j+1]>=A[j]) {
//                continue;
//            } else {
//                index = j+1;
//                break;
//            }
//        }
//
//        Arrays.sort(B);
//        int index2 = -1;
//        for (int j = B.length-1; j > 0; j--) {
//            if (index == 0){
//                if (B[j]<A[index+1]) {
//                    index2=j;
//                    break;
//                }
//            }else if (index == A.length-1) {
//                if (B[j]>A[index-1]) {
//                    index2=j;
//                    break;
//                }
//            }else {
//                if (B[j]<A[index+1] && B[j]>A[index-1]) {
//                    index2=j;
//                    break;
//                }
//            }
//        }
//
//        if (index2 == -1 ) {
//            System.out.println("NO");
//        }else {
//            A[index] = B[index2];
//            for (int j = 0; j < A.length; j++) {
//                if (j!=A.length-1) {
//                    System.out.print(A[j]+" ");
//                } else {
//                    System.out.print(A[j]);
//                }
//            }
//        }

        Scanner in = new Scanner(System.in);
        while(in.hasNext()) {
            String[] aa = in.nextLine().split(" ");
            String[] bb = in.nextLine().split(" ");
            int[] a = new int[aa.length];
            int[] b = new int[bb.length];
            for(int i = 0; i < aa.length; ++i) {
                a[i] = Integer.parseInt(aa[i]);
            }
            for(int i = 0; i < bb.length; ++i) {
                b[i] = Integer.parseInt(bb[i]);
            }
            int cur = 0;
            for(; cur < a.length - 1; ++cur) {
                if(a[cur] >= a[cur+1]) break;
            }
            int left1 = cur == 0 ? Integer.MIN_VALUE : a[cur-1];
            int right1 = a[cur+1];
            int left2 = a[cur];
            int right2 = cur == a.length-2 ? Integer.MAX_VALUE : a[cur+2];

            Arrays.sort(b);
            int i = b.length - 1;
            for(; i >= 0; --i) {
                if(left1 < b[i] && b[i] < right1) {
                    a[cur] = b[i];
                    break;
                } else if(left2 < b[i] && b[i] < right2) {
                    a[cur+1] = b[i];
                    break;
                }
            }
            if(i == -1) {
                System.out.println("NO");
            } else {
                for(i = 0; i < a.length; ++i) {
                    System.out.print(a[i]);
                    if(i != a.length-1) System.out.print(" ");
                }
                System.out.print("\n");
            }
        }
    }
}
