package BFSDFS;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * @author He.H
 * @date 2019/8/14 21:05
 **/
//m个用户，r[i,j]\in [1,9]表示用户之间的亲密度，为0表示不是好友
// 给定用户i，输出n度好友。1<=n<=10。按照推荐值降序输出
// 输入：第一行T， 表示有T组测试用例/
// 对于每一组有两行：第一行是三个整数m ，i， n
// 第二行先是一个k，后续3*K个数用空格分割 i，j，w表示连边顶点和权值。


//input： 10 0 2 13 0 3 5 0 4 9 0 6 8 0 7 5 1 2 6 1 6 3 2 9 7 3 4 3 3 5 3 3 8 3 3 9 3 5 8 9 7 8 9
//outp： 1 5 8 9
public class NDegreeFriend {
    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int T = sc.nextInt();
//        for (int i = 0; i < T; i++) {
//            solve();
//        }
        solve();
    }


    static class Result {
        int value;
        int weight;
    }
    public static void solve() {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int i = sc.nextInt();
        int n = sc.nextInt();
        int k = sc.nextInt();

        HashMap<Integer, int[]> map = new HashMap<>();

        for (int j = 0; j < k; j++) {
            int d1 = sc.nextInt();
            int d2 = sc.nextInt();
            int w = sc.nextInt();
            if (map.containsKey(d1)) {
                map.get(d1)[d2] = w;
            }else {
                map.put(d1, new int[m]);
                map.get(d1)[d2] = w;
            }
            if (map.containsKey(d2)) {
                map.get(d2)[d1] = w;
            }else {
                map.put(d2, new int[m]);
                map.get(d2)[d1] = w;
            }
        }

        int flag = 0;
        int[] weights = new int[m];
        int[] used = new int[m];
        LinkedList<int[]> queue = new LinkedList<>();
        queue.add(new int[]{i,0});
        used[i] = 1;
        while (!queue.isEmpty() && flag<n) {
            flag = queue.peek()[1];
            if (flag == n) {
                break;
            }
            int[] tmp = queue.pop();
            //flag = tmp[1] + 1;

            int[] nodes = map.get(tmp[0]);
            for (int j = 0; j < nodes.length; j++) {
                if (used[j] == 0 && nodes[j] != 0) {
                    used[j] = 1;
                    queue.add(new int[]{j, flag+1});
                    weights[j] += nodes[j];
                    weights[j] += weights[tmp[0]];
                }
            }
        }

        Result[] result = new Result[queue.size()];
        int cnt = queue.size();
        for (int j = 0; j < cnt; j++) {
            int[] tmp = queue.pop();
            result[j] = new Result();
            result[j].value = tmp[0];
            result[j].weight = weights[tmp[0]];
        }
        Arrays.sort(result, (r1,r2)->{return r1.weight == r2.weight ? r1.value-r2.value : r2.weight-r1.weight;});

        for (int j = 0; j < result.length; j++) {
            if (j == result.length-1) {
                System.out.print(result[j].value);
            } else {
                System.out.print(result[j].value +" ");
            }
        }
        System.out.println();
    }
}
