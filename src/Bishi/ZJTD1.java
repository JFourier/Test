package Bishi;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 头条8-11
 *
 * @author He.H
 * @date 2019/8/11 17:05
 **/


public class ZJTD1 {
    static class Time {
        int hour;
        int minute;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        //int[][] nums = new int[n][2];

        Time[] clock = new Time[n];
        for (int i = 0; i < n; i++) {
            clock[i] = new Time();
            clock[i].hour = sc.nextInt();
            clock[i].minute = sc.nextInt();
        }
        Arrays.sort(clock, (c1, c2)->{return c1.hour == c2.hour ? c1.minute-c2.minute : c1.hour - c2.hour;});
        int time = sc.nextInt();
        int hour = sc.nextInt();
        int min = sc.nextInt();

        int h = time/60;
        int m = time%60;

        int h1, m1;
        if (m > min) {
            h1 = hour - h -1;
            m1 = 60 + min - m;
        } else {
            h1 = hour - h;
            m1 = min - m;
        }

        int index = 0;
        for (int i = n-1; i >0  ; i--) {
            if (clock[i].hour> h1) {
                continue;
            } else if (clock[i].hour == h1 && clock[i].minute>m1) {
                continue;
            } else if (clock[i].hour == h1 && clock[i].minute<=m1) {
                index = i;
                break;
            }else if (clock[i].hour < h1) {
                index = i;
                break;
            }
        }

        System.out.print(clock[index].hour);
        System.out.print(" ");
        System.out.println(clock[index].minute);


    }
    public static int[] solve(int[][] nums, int time, int hour, int min) {
        return new int[2];
    }
}
