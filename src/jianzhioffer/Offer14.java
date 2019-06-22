package jianzhioffer;

/**
 * @author He.H
 * @date 2019/6/18 10:55
 **/


//倒数第k个节点
public class Offer14 {
    public ListNode FindKthToTail(ListNode head,int k) {
        int length = 0;
        ListNode first = head;
        while (first != null) {
            length++;
            first = first.next;
        }
        if(k>length)
            return(null);
        length = length-k+1;
        first = head;
        for (int i = 1; i<length; i++){
            first = first.next;
        }
        return first;
    }
}
