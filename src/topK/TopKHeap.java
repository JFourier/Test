package topK;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 找到最小的k个数
 *
 * @author He.H
 * @date 2019/3/1 13:53
 **/


public class TopKHeap {
    public static ArrayList<Integer> findTopK(int[] ori, int k) {
        if (ori.length < k) {
            return null;
        } else if (ori.length == k) {
            return new ArrayList(Arrays.asList(ori));
        }
        ArrayList res = new ArrayList();
        buildMaxHeap(ori,k-1);
        int [] rest = new int[k+1];
        for (int i = 0; i < k; i++) {
            rest[i+1] = ori[i];
        }
        for (int i = k; i < ori.length; i++) {
            heapInsert(rest, ori[i]);
        }
        for (int i = 1; i < rest.length; i++) {
            res.add(rest[i]);
        }
        return res;
    }


    private static void buildMaxHeap(int[] data, int lastIndex) {
        //从lastIndex处节点（最后一个节点）的父节点开始
        for(int i=(lastIndex-1)/2;i>=0;i--){
            //k保存正在判断的节点
            int k=i;
            //如果当前k节点的子节点存在
            while(k*2+1<=lastIndex){
                //k节点的左子节点的索引
                int biggerIndex=2*k+1;
                //如果biggerIndex小于lastIndex，即biggerIndex+1代表的k节点的右子节点存在
                if(biggerIndex<lastIndex){
                    //若果右子节点的值较大
                    if(data[biggerIndex]<data[biggerIndex+1]){
                        //biggerIndex总是记录较大子节点的索引
                        biggerIndex++;
                    }
                }
                //如果k节点的值小于其较大的子节点的值
                if(data[k]<data[biggerIndex]){
                    //交换他们
                    swap(data,k,biggerIndex);
                    //将biggerIndex赋予k，开始while循环的下一次循环，重新保证k节点的值大于其左右子节点的值
                    k=biggerIndex;
                }else{
                    break;
                }
            }
        }
    }
    //交换方法
    private static void swap(int[] data, int i, int j){
        int tmp=data[i];
        data[i]=data[j];
        data[j]=tmp;
    }
    public static void heapInsert(int[] heap,int k) {
        if (k > heap[1]) {
            return;
        } else if (k == heap[1]) {
            return;
        }
        heap[1] = k;
        sink(heap, 1);
    }
    public static void sink(int[] heap,int k) {
        if (k*2 >= heap.length) {
            return;
        }
        if (heap[k]<heap[2*k] && 2*k+1<heap.length && heap[k]<heap[2*k+1]) {
            if (heap[2 * k] < heap[2 * k + 1]) {
                swap(heap, k, 2 * k);
                sink(heap,2*k);
            } else {
                swap(heap, k, 2 * k + 1);
                sink(heap,2*k+1);
            }
        }
        if (heap[k]<heap[2*k] && 2*k+1<heap.length && heap[k]>heap[2*k+1]) {
            swap(heap, k, 2 * k);
            sink(heap,2*k);
        }
        if (heap[k]>heap[2*k] && 2*k+1<heap.length && heap[k]<heap[2*k+1]) {
            swap(heap, k, 2 * k+1);
            sink(heap,2*k);
        }
        if (heap[k]<heap[2*k] && 2*k+1<heap.length) {
            swap(heap, k, 2 * k);
            sink(heap,2*k);
        }

    }

    public static void main(String[] args){
        int[] a = {3,1,6,0,2,7,9};
        int k = 5;
        ArrayList res = findTopK(a,k);
        System.out.println(res);
    }
}
