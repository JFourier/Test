package Bishi.BeikeOld;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * @author He.H
 * @date 2019/8/21 16:25
 **/

//给出10个数，分别表示0-9在字符串12345678910111213（1-n）的出现次数，字符串中缺失了一个数字，输出n。和缺失的数字
public class Beike3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] cnt = new int[10];
        for (int i = 0; i < 10; i++) {
            cnt[i] = sc.nextInt();
        }
        int i = 1;
        while (judge(cnt)) {
            int tmp = i;
            while (tmp > 0) {
                int flag = tmp%10;
                tmp = tmp/10;
                cnt[flag]--;
            }
            i++;
        }
        int res1 = i-1;
        List<Integer> res2 = makeRes(cnt);

        System.out.println(res1+"");
        res2.forEach(integer -> System.out.println(integer));
    }

    public static boolean judge(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                return true;
            }
        }
        return false;
    }

    public static List<Integer> makeRes(int[] nums) {
        List<Integer> element = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i]<0) {
                int cnt = Math.abs(nums[i]);
                for (int j = 0; j < cnt; j++) {
                    element.add(i);
                }
            }
        }
        int[] input = new int[element.size()];
        for (int i = 0; i < input.length; i++) {
            input[i] = element.get(i);
        }
        List<List<Integer>> restmp = permuteUnique(input);

        List<Integer> res = list2Integer(restmp);
        return res;

    }

    public static List<Integer> list2Integer(List<List<Integer>> input) {
        List<Integer> res = new ArrayList<>();

        for (int i = 0; i < input.size(); i++) {
            ArrayList<Integer> tmp = (ArrayList<Integer>) input.get(i);
            int rr = 0;
            for (int j = 0; j <tmp.size(); j++) {
                rr = rr*10;
                rr += tmp.get(i);
            }
            res.add(rr);
        }
        return res;
    }

    public static List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(nums==null || nums.length==0) return res;
        boolean[] used = new boolean[nums.length];
        List<Integer> list = new ArrayList<Integer>();
        //排序有利于判断重复值
        Arrays.sort(nums);
        //深度优先算法
        dfs(nums, used, list, res);
        return res;
    }

    public static void dfs(int[] nums, boolean[] used, List<Integer> list, List<List<Integer>> res){
        //如果结果长度和输入长度相等，则添加进结果集
        if(list.size()==nums.length){
            res.add(new ArrayList<Integer>(list));
            return;
        }
        for(int i=0;i<nums.length;i++){
            // 如果该元素已经被使用过，则继续遍历
            if(used[i]) continue;
            //下一个重复值只有在前一个重复值m没有被使用的情况下才可以使用
            if(i>0 &&nums[i-1]==nums[i] && !used[i-1]) continue;
            used[i]=true;
            list.add(nums[i]);
            dfs(nums,used,list,res);
            used[i]=false;
            list.remove(list.size()-1);
        }
    }
}
