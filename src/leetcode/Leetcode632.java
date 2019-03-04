package leetcode;

import java.util.List;

/**
 * @author He.H
 * @date 2019/1/14 10:32
 **/


public class Leetcode632 {
    public int[] smallestRange(List<List<Integer>> nums) {
        int k=nums.size(), max=Integer.MIN_VALUE;
        int[] res = new int[2], ind = new int[k];
        res[1]=Integer.MAX_VALUE;

        for(int i=0;i<k;i++) {
            int n=nums.get(i).get(0);
            if(n>max) max=n;
        }

        while(true){
            int min=Integer.MAX_VALUE, minIndex=-1;
            //always adjust all pointers next to the maxValue in current range
            for(int i=0;i<k;i++){
                while(ind[i]+1<nums.get(i).size() && nums.get(i).get(ind[i]+1)<=max) ind[i]++;
                if(nums.get(i).get(ind[i])<min) {
                    min=nums.get(i).get(ind[i]);
                    minIndex=i;
                }
            }
            if(max-min<res[1]-res[0]){
                res[1]=max;
                res[0]=min;
            }
            ind[minIndex]++;
            if(ind[minIndex]>=nums.get(minIndex).size()) break;
            //make sure in next loop, the max needs to be bigger than the int at changed index
            max=nums.get(minIndex).get(ind[minIndex]);
        }
        return res;
    }
}

