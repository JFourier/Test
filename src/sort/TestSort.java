package sort;

import java.util.Arrays;
import java.util.Random;

/**
 * @author He.H
 * @date 2019/3/10 21:22
 **/


public class TestSort {
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
        int[] te1 = new int[100000];
        int[] te2 = new int[100000];
        int min = 1;
        int max = 1000000;
        Random random = new Random();
        for (int i=0; i<te1.length; i++) {
            int s = random.nextInt(max) % (max - min + 1) + min;
            te1[i] = s;
            te2[i] = s;
        }

        long startTime1=System.currentTimeMillis();   //获取开始时间
        Arrays.sort(te1);  //测试的代码段
        long endTime1=System.currentTimeMillis(); //获取结束时间
        System.out.println("SYS SORT： "+(endTime1-startTime1)+"ms");

//        long startTime=System.currentTimeMillis();   //获取开始时间
//        quickSort(te1,0,te1.length-1);  //测试的代码段
//        long endTime=System.currentTimeMillis(); //获取结束时间
//        System.out.println("MY SORT： "+(endTime-startTime)+"ms");


    }
}
