package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author He.H
 * @date 2019/4/11 10:14
 **/


public class Leetcode996 {
    /*
    * 构造一张图，包含所有的边 ii 到 jj ，如果满足 A[i] + A[j]A[i]+A[j] 是一个完全平方数。
    * 我们的目标就是求这张图的所有哈密尔顿路径，即经过图中所有点仅一次的路径。
    * 我们使用 count 记录对于每一种值还有多少个节点等待被访问，与一个变量 "to do" 记录还剩多少个节点等待被访问。
    * 对于每一个节点，我们可以访问它的所有邻居节点（从数值的角度来看，从而大大减少复杂度）
    * */
    Map<Integer, Integer> count;
    Map<Integer, List<Integer>> graph;

    public int numSquarefulPerms(int[] A) {
        int N = A.length;
        count = new HashMap();
        graph = new HashMap();

        // count.get(v) : 数组 A 中值为 v 的节点数量v
        for (int x: A)
            count.put(x, count.getOrDefault(x, 0) + 1);

        // graph.get(v) : 在 A 中的值 w 满足 v + w 是完全平方数
        //                (ie., "vw" is an edge)
        for (int x: count.keySet())
            graph.put(x, new ArrayList());

        for (int x: count.keySet())
            for (int y: count.keySet()) {
                int r = (int) (Math.sqrt(x + y) + 0.5);
                if (r * r == x + y)
                    graph.get(x).add(y);
            }
        // 增加从 x 开始的可行路径数量
        int ans = 0;
        for (int x: count.keySet())
            ans += dfs(x, N - 1);
        return ans;
    }

    public int dfs(int x, int todo) {
        count.put(x, count.get(x) - 1);
        int ans = 1;
        if (todo != 0) {
            ans = 0;
            for (int y: graph.get(x)) if (count.get(y) != 0) {
                ans += dfs(y, todo - 1);
            }
        }
        count.put(x, count.get(x) + 1);
        return ans;
    }
}




class DP996 {
    /*
    * 令 dfs(node, visited) 等于从 node 节点出发访问剩余的节点的可行方法数。
    * 这里，visited 是一个掩码：(visited >> i) & 1 为真，当且仅当第 i 个节点已经被访问过了。
    * 这样计算之后，对于 A 中拥有相同值的节点我们会重复计算。
    * 考虑这个因素，对于 A 中的值 x，如果 A 中包含 k 个值为 x 的节点，我们令最终答案除以 k!。
    * */
    int N;
    Map<Integer, List<Integer>> graph;
    Integer[][] memo;

    public int numSquarefulPerms(int[] A) {
        N = A.length;
        graph = new HashMap();
        memo = new Integer[N][1 << N];

        for (int i = 0; i < N; ++i)
            graph.put(i, new ArrayList());

        for (int i = 0; i < N; ++i)
            for (int j = i+1; j < N; ++j) {
                int r = (int) (Math.sqrt(A[i] + A[j]) + 0.5);
                if (r * r == A[i] + A[j]) {
                    graph.get(i).add(j);
                    graph.get(j).add(i);
                }
            }


        int[] factorial = new int[20];
        factorial[0] = 1;
        for (int i = 1; i < 20; ++i)
            factorial[i] = i * factorial[i-1];
        int ans = 0;
        for (int i = 0; i < N; ++i)
            ans += dfs(i, 1 << i);
        Map<Integer, Integer> count = new HashMap();
        for (int x: A)
            count.put(x, count.getOrDefault(x, 0) + 1);
        for (int v: count.values())
            ans /= factorial[v];
        return ans;
    }

    public int dfs(int node, int visited) {
        if (visited == (1 << N) - 1)
            return 1;
        if (memo[node][visited] != null)
            return memo[node][visited];

        int ans = 0;
        for (int nei: graph.get(node))
            if (((visited >> nei) & 1) == 0)
                ans += dfs(nei, visited | (1 << nei));
        memo[node][visited] = ans;
        return ans;
    }
}
