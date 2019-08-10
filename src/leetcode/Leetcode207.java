package leetcode;

import java.util.LinkedList;

/**
 * @author He.H
 * @date 2019/8/10 9:01
 **/


public class Leetcode207 {
    //DFS 判断是否有环
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[][] adjacency = new int[numCourses][numCourses];
        int[] flags = new int[numCourses];
        for(int[] cp : prerequisites)
            adjacency[cp[1]][cp[0]] = 1;
        for(int i = 0; i < numCourses; i++){
            if(!dfs(adjacency, flags, i)) return false;
        }
        return true;
    }
    private boolean dfs(int[][] adjacency, int[] flags, int i) {
        //未被DFS访问：i == 0；
        //已被其他节点启动的DFS访问：i == -1；
        //已被当前节点启动的DFS访问：i == 1。
        if(flags[i] == 1)
            //有环
            return false;
        if(flags[i] == -1)
            //无环
            return true;
        flags[i] = 1;
        for(int j = 0; j < adjacency.length; j++) {
            if(adjacency[i][j] == 1 && !dfs(adjacency, flags, j)) return false;
        }
        flags[i] = -1;
        return true;
    }




    //拓扑排序，先将入度为0 的入队，
    public static boolean canFinish1(int numCourses, int[][] prerequisites) {
        int[] indegrees = new int[numCourses];
        for(int[] cp : prerequisites) indegrees[cp[0]]++;
        LinkedList<Integer> queue = new LinkedList<>();
        for(int i = 0; i < numCourses; i++){
            if(indegrees[i] == 0) queue.addLast(i);
        }
        while(!queue.isEmpty()) {
            Integer pre = queue.removeFirst();
            numCourses--;
            for(int[] req : prerequisites) {
                if(req[1] != pre) continue;
                if(--indegrees[req[0]] == 0) queue.add(req[0]);
            }
        }
        return numCourses == 0;
    }


    public static void main(String[] args) {
        int n = 3;
        int[][] adj = {{1,2},{0,1},{0,2}};
        boolean res = canFinish1(n, adj);
    }
}
