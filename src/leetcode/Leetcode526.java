package leetcode;

/**
 * @author He.H
 * @date 2019/1/3 21:23
 **/


public class Leetcode526 {
    public int countArrangement(int N) {
        int[] num = new int[N];
        int res = findWay(num, 1);
        return res;
    }

    public int findWay(int[] num, int index) {
        if (index == num.length+1) return 1;
        int total = 0;
        for (int i = 0; i < num.length; i++) {
            if (num[i] != 1) {
                if ((i+1) % index == 0 || index % (i+1) == 0) {
                    int[] newNum = num.clone();
                    newNum[i] = 1;
                    total += findWay(newNum, index+1);
                }
            }
        }
        return total;
    }
}
