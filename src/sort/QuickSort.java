package sort;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author He.H
 * @date 2019/1/2 9:42
 **/


public class QuickSort {
    public  static void quickSort(ArrayList<Integer> a, int low, int high){
        int start = low;
        int end = high;
        int key = a.get(low);
        while(end>start){
            while(end>start&&a.get(end)>=key)
                end--;
            if(a.get(end)<=key){
                int temp = a.get(end);
                a.set(end,a.get(start));
                a.set(start,temp);
            }
            while(end>start&&a.get(start)<=key)
                start++;
            if(a.get(start)>=key){
                int temp = a.get(start);
                a.set(start,a.get(end));
                a.set(end,temp);
            }
        }
        if(start>low) quickSort(a,low,start-1);
        if(end<high) quickSort(a,end+1,high);
    }
    public static void quickSort(int[] nums, int low, int high){
        int start = low;
        int end = high;
        int key = nums[low];
        while (end>start){
            while (end>start && nums[end]>=key)
                end--;
            if(nums[end] <= key){
                int temp = nums[end];
                nums[end] = nums[start];
                nums[start] = temp;
            }
            while (end>start && nums[start]<=key)
                start++;
            if(nums[start] >= key){
                int temp = nums[start];
                nums[start] = nums[end];
                nums[end] = temp;
            }
        }
        if(start>low) quickSort(nums ,low ,start-1);
        if(end<high) quickSort(nums ,end+1 ,high);
    }

    public static void main(String[] args){
        int[] nums = {2,1,3,4,0};
        quickSort(nums,0, nums.length-1);
        System.out.println(Arrays.toString(nums));
    }
}
