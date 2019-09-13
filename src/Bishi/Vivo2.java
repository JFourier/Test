package Bishi;

import java.util.Scanner;

/**
 * @author He.H
 * @date 2019/9/11 16:26
 **/


public class Vivo2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String full = scanner.nextLine();
        String[] fulllist = full.split(" ");
        int disk = Integer.parseInt(fulllist[0]);
        int mem = Integer.parseInt(fulllist[1]);
        String[] applist = fulllist[2].trim().split("#");
        int cnt = applist.length;
        int[] appdisk = new int[cnt];
        int[] appmem = new int[cnt];
        int[] appuser = new int[cnt];
        for (int i = 0; i < cnt; i++) {
            String tmp = applist[i];
            String[] tmpl = tmp.split(",");
            appdisk[i] = Integer.parseInt(tmpl[0]);
            appmem[i] = Integer.parseInt(tmpl[1]);
            appuser[i] = Integer.parseInt(tmpl[2]);
        }
        int[][] dp = new int[disk+1][mem+1];
        for (int k = 0; k < cnt; k++) {
            for (int i = disk; i >= 0 ; --i) {
                for (int j = mem; j >= 0 ; --j) {
                    if (j>=appmem[k] && i>=appdisk[k]){
                        dp[i][j] = Math.max(dp[i][j], dp[i-appdisk[k]][j-appmem[k]]+appuser[k]);
                    }
                }
            }
        }
        System.out.println(dp[disk][mem]);
    }
}
