import org.jetbrains.annotations.NotNull;

/**
 * @author He.H
 * @date 2019/9/26 18:47
 **/


public class KMP {

    private int[][] dp;
    private String pat;

    public KMP(@NotNull String pat) {
        this.pat = pat;
        int M = pat.length();
        // dp[状态][字符] = 下个状态
        dp = new int[M][256];
        // base case
        dp[0][pat.charAt(0)] = 1;
        // 影子状态 X 初始为 0，所谓影子状态，就是和当前状态具有相同的前缀
        int X = 0;
        // 构建状态转移图（稍改的更紧凑了）
        for (int j = 1; j < M; j++) {
            for (int c = 0; c < 256; c++) {
                //先尝试恢复
                dp[j][c] = dp[X][c];
                //向前更新一步
                dp[j][pat.charAt(j)] = j + 1;
                //以上两行代码等价于
                /*if (pat.charAt(j) == c)
                    dp[j][c] = j + 1;
                else
                    dp[j][c] = dp[X][c];*/
                // 更新影子状态
                X = dp[X][pat.charAt(j)];
            }
        }
    }

    public int search(@NotNull String txt) {
        int M = pat.length();
        int N = txt.length();
        // pat 的初始态为 0
        int j = 0;
        for (int i = 0; i < N; i++) {
            // 计算 pat 的下一个状态
            j = dp[j][txt.charAt(i)];
            // 到达终止态，返回结果
            if (j == M) return i - M + 1;
        }
        // 没到达终止态，匹配失败
        return -1;
    }

}
