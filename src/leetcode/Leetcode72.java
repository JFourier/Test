package leetcode;

/**
 * @author He.H
 * @date 2019/3/14 10:37
 **/


public class Leetcode72 {
    public int minDistance(String word1, String word2) {
        if(word1.isEmpty())
            return word2.length();
        if(word2.isEmpty())
            return word1.length();
        int[][] steps = new int[word1.length()+1][word2.length()+1];
        for(int i = 0 ; i<=word1.length() ; i++){
            for(int j = 0 ; j<=word2.length() ; j++){
                if(i==0){
                    steps[i][j] = j;
                }else if(j==0){
                    steps[i][j] = i;
                }else if(word1.charAt(i-1) == word2.charAt(j-1)){
                    steps[i][j] = steps[i-1][j-1];
                }else{
                    //dp[i-1][j-1] 表示替换操作，dp[i-1][j] 表示删除操作，dp[i][j-1] 表示插入操作。
                    steps[i][j] = Math.min(Math.min(steps[i][j-1]+1, steps[i-1][j-1]+1), steps[i-1][j]+1);
                }

            }
        }
        return steps[word1.length()][word2.length()];
    }
}
