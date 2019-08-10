package leetcode;

/**
 * @author He.H
 * @date 2019/8/10 11:27
 **/


public class Leetcode785 {
    public boolean isBipartite(int[][] graph) {
        int len = graph.length;
        int color[] = new int[len];
        for(int i = 0;i<len;i++){
            if(color[i]==0&&dfs(i,color,2,graph)==false)
                return false;
        }
        return true;
    }
    public boolean dfs(int i,int []color,int t,int [][]graph){
        if(color[i]!=0)
            return color[i]==t;
        color[i] = t;
        for(int j:graph[i]){
            if(dfs(j,color,3-t,graph)==false)
                return false;
        }
        return true;
    }
}
