package sort;

/**
 * @author He.H
 * @date 2019/9/4 9:00
 **/


public class ListSort {
    class ListNode{
        int value;
        ListNode next;
    }

    //快速排序
    /**
     * 实现链表的快速排序算法
     * @param head	链表的头结点
     * @param end	链表的尾结点
     */
    public static void quickSortLinkedList(ListNode head, ListNode end){
        if(head != end){	//链表至少需要两个结点，即头结点和尾结点不能相同
            int pivot = head.value;		//得到基准值
            ListNode small = head;		//small指针
            ListNode large = small.next;	//large指针

            while(large != end){	//如果large指针没有到尾结点
                if(large.value < pivot){	//如果large指向的结点值小于基准值，需要交换
                    small = small.next;		//small指针后移
                    if(small != large){		//如果不是指向同一个结点，则执行交换，否则不做处理
                        int temp = small.value;
                        small.value = large.value;
                        large.value = temp;
                    }
                }
                large = large.next;		//large指针后移
            }
            int temp = small.value;		//交换头结点和small指向的结点
            small.value = head.value;
            head.value = temp;

            quickSortLinkedList(head, small);	//对前半部分进行快速排序
            quickSortLinkedList(small.next, end);	//对后半部分进行快速排序
        }
    }


}
