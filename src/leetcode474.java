/**
 * 〈〉
 *
 * @author He.H
 * @create 2018/11/12
 */
public class leetcode474 {
    public static int findMaxForm(String[] strs, int m, int n) {
        int [][] tables = new int[m + 1][n + 1];
        for(String item : strs){
            int m_0 = 0, n_1 = 0;
            for(int i = 0; i < item.length(); i ++){
                if(item.charAt(i) == '0') m_0 ++;
                else n_1 ++;
            }

            for(int i = m; i >= m_0; i --)
                for(int j =n; j >= n_1; j--){
                    tables[i][j] = Math.max(tables[i][j], 1 + tables[i-m_0][j-n_1]);
                }
        }
        return tables[m][n];
    }
    public static void main(String[] args){
        int m = 1;
        int n = 1;
        String[] strs = {"10","1","0"};
        int res = findMaxForm(strs,m,n);
        System.out.println(res);
    }

}