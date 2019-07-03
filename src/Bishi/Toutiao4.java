package Bishi;

import java.util.Scanner;

/**
 * @author He.H
 * @date 2019/7/1 10:14
 **/


/*
* 给定一个长度为N一维数组代表的路径，每个数组值（>=0）代表从该位置向前或者向后弹跳的最大步数（即：可以弹跳1到最大步之间）。
* 如果是0，则代表是悬崖。马里奥开始会出生在一个随机的位置P。
* 一维数组最右端的位置是终点（例如：10 0 2 1 1 0 1 终点）。
* 现在求马里奥从出生点到达重点需要的最少弹跳次数。如果终点不可达，那么返回-1。
输入第一行路径长度和马里奥出生位置：N P
输入第二行：N个位置上的最大弹跳长度
输入样例：
7 4
10 0 2 1 1 0 1
输入样例：
3
* */
public class Toutiao4 {
    static int min_step = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int P = in.nextInt();
        int[] A = new int [N];
        for (int i = 0; i < N; ++i) {
            A[i] = in.nextInt();
        }

        int[] visit = new int[N];

        if (A[P] == 0) {
            System.out.println(-1);
        } else {
            dfs(A, P-1, 1, N, visit);
        }
        if (min_step == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(min_step);
        }
    }
    public static void dfs(int[] mmap, int born, int count, int termin, int[] visit) {
        visit[born] = 1;
        if (mmap[born] == 0)
            return;
        int step = mmap[born];
        int left = born - step;
        int right = born + step;
        if (right >= termin)
        {
            if (count < min_step)
                min_step = count;
            return;
        }
        if (left < 0)
            left = 0;
        if (right >= mmap.length)
            right = mmap.length - 1;
        for (int i = left; i <= right; i++)
        {
            if(visit[i] == 0)
                dfs(mmap, i, count + 1, termin, visit);
        }
        visit[born] = 0;
    }
}
