import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

/**
 * @author He.H
 * @date 2019/3/5 10:12
 **/


public class PermuteString {
    public static void main(String[] args){
        String test = "";
        ArrayList<String> res = Permutation(test);
        for (String i : res) {
            System.out.println(i);
        }
    }
    public static ArrayList<String> Permutation(String str) {
        if (str.isEmpty())
            return (new ArrayList<>());
        char[] in = str.toCharArray();
        return Permutation(in);
    }
    public static ArrayList<String> Permutation(char[] str) {
        ArrayList<String> res = new ArrayList<>();
        //ArrayList<Integer> temp = new ArrayList<Integer>();
        Set<String> set = new TreeSet<>();
        dfs(res, str, 0);
        for (String i:res) {
            set.add(i);
        }
        res.clear();
        Iterator<String> iterator = set.iterator();
        while(iterator.hasNext()){
            res.add(iterator.next());
        }
        return res;
    }
    private static void dfs(ArrayList<String> res, char[] nums, int j) {
        if (j == nums.length) {
            StringBuilder temp = new StringBuilder();
            for (char num : nums) temp.append(num);
            res.add(temp.toString());
        }
        for (int i = j; i < nums.length; i++) {
            swap(nums, i, j);
            dfs(res, nums, j+1);
            swap(nums, i, j);
        }
    }
    private static void swap(char[] nums, int m, int n) {
        char temp = nums[m];
        nums[m] = nums[n];
        nums[n] = temp;
    }
}
