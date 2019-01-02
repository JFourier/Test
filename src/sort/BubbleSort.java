package sort;

/**
 * @author He.H
 * @date 2019/1/2 9:40
 **/


public class BubbleSort {
    public static void bubbleSort(int[] numbers){
        int temp = 0;
        int size = numbers.length;
        for(int i = 0 ; i < size-1; i ++){
            for(int j = 0 ;j < size-1-i ; j++){
                if(numbers[j] > numbers[j+1]){
                    temp = numbers[j];
                    numbers[j] = numbers[j+1];
                    numbers[j+1] = temp;
                }
            }
        }
    }
}
