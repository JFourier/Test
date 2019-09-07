package Bishi;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author He.H
 * @date 2019/9/3 19:16
 **/


public class Xiaohongshu2 {
    static class Box {
        int len;
        int weight;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        Box[] b = new Box[n+1];;
        while(in.hasNext()) {

            b[0] = new Box();
            for(int i = 1; i < n+1; ++i) {
                b[i] = new Box();
                b[i].len = in.nextInt();
                b[i].weight = in.nextInt();
            }
        }
        Box[] bb = b.clone();
        Arrays.sort(b, (b1, b2) -> {return b1.len == b2.len ? b1.weight-b2.weight : b1.len - b2.len;});
        Arrays.sort(b, (b1, b2) -> {return b1.weight == b2.weight ? b1.len-b2.len : b1.weight - b2.weight;});
        int ans = Math.max(solveb(b), solvebb(bb));
        System.out.println(ans);
    }

    public static int solveb(Box[] b) {
        int n = b.length;
        int ans = 1;
        int l0 = b[0].len;
        int w0 = b[0].weight;
        for (int i = 1; i < n; i++) {
            if (b[i].len<=l0) {
                continue;
            } else {
                if (b[i].weight>w0) {
                    ans++;
                    l0 = b[i].len;
                    w0 = b[i].weight;
                }
            }
        }
        return ans;
    }
    public static int solvebb(Box[] b) {
        int n = b.length;
        int ans = 1;
        int l0 = b[0].len;
        int w0 = b[0].weight;
        for (int i = 1; i < n; i++) {
            if (b[i].weight<=w0) {
                continue;
            } else {
                if (b[i].len>l0) {
                    ans++;
                    l0 = b[i].len;
                    w0 = b[i].weight;
                }
            }
        }
        return ans;
    }
}
