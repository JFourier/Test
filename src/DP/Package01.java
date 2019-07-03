package DP;

/**
 * @author He.H
 * @date 2019/7/1 15:05
 **/


public class Package01 {
    // 一维数组
        public static void main(String[] args) {
            int[] w = {0,10, 3, 4, 5};
            int[] v = {0,3, 4, 6, 7};
            int m = 10;
            int n = 4;
            //int k = 0;
            int[] maxValue = new int[16];

            for (int i=1; i<=n; i++) {
                for (int j=m; j>=w[i]; j--) {
                    maxValue[j] = max(maxValue[j], maxValue[j-w[i]] + v[i]);
                }

                //验证  结果和二维实现的输出结果完全一样
                //for (int k=0; k<=m; k++) {
                //	System.out.print(maxValue[k] + "\t");
                //}
                //System.out.println();
            }

            System.out.println("4个物品在背包承重为10的情况下的组合的最大价值为："+maxValue[m]);
            System.out.println();

            for (int i=0; i<=m; i++) {
                System.out.print(maxValue[i] + "\t");
            }
        }

        public static int max(int a, int b) {
            if (a > b) {
                return a;
            }
            return b;
        }
}
