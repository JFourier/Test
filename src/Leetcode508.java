import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * @author He.H
 * @date 2018/12/30 10:36
 **/


public class Leetcode508 {
    public int[] findFrequentTreeSum(TreeNode root) {
        if (root == null) return new int[0];

        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        countSum(root, map);

        int[] all = new int[map.size()];
        int num = 0;
        int big = 0;
        Iterator iter = map.entrySet().iterator();
        while (iter.hasNext()) {
            Map.Entry entry = (Map.Entry)iter.next();
            if ((int)entry.getValue() > big) {
                all[0] = (int)entry.getKey();
                num = 1;
                big = (int)entry.getValue();
            } else if ((int)entry.getValue() == big) {
                all[num] = (int)entry.getKey();
                num++;
            }
        }
        return Arrays.copyOfRange(all, 0, num);
    }

    public int countSum(TreeNode root, HashMap<Integer, Integer> map) {
        int sum = 0;
        sum += root.val;
        if (root.left != null) sum += countSum(root.left, map);
        if (root.right != null) sum += countSum(root.right, map);

        if (map.get(sum) != null) {// 之前放过
            map.put(sum, map.get(sum)+1);
        } else {
            map.put(sum, 1);
        }
        return sum;
    }
}
