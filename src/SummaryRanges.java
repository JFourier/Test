import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * leetcode228
 *
 *input: [0,1,2,4,5,8]
 * output: ["0->2","4->5","8"]
 *
 * @author He.H
 * @date 2018/12/11 16:40
 **/


public class SummaryRanges {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        String[] h = scanner.nextLine().split("");
        int[] input = stringToInt(h);
        List<String> result = summaryRanges(input);
        System.out.print(result);
    }
    public static int[] stringToInt(String[] arrs){
        int[] ints = new int[arrs.length];
        for(int i=0;i<arrs.length;i++){
            ints[i] = Integer.parseInt(arrs[i]);
        }
        return ints;
    }
    public static List<String> summaryRanges(int[] nums) {
        List<String> list = new ArrayList<>();
        int pos = 0;
        while (pos < nums.length) {
            StringBuilder it = new StringBuilder(""+nums[pos]);
            int temp = pos;
            while (pos + 1 < nums.length && nums[pos + 1] == nums[pos] + 1)
                pos++;

            if (pos != temp)
                it.append("->").append(nums[pos]);
            list.add(it.toString());
            pos++;
        }
        return list;
    }
}
