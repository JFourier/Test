package jianzhioffer;

/**
 * @author He.H
 * @date 2019/6/18 10:59
 **/


//合并有序链表
public class Offer16 {
    public ListNode Merge(ListNode l1,ListNode l2) {
        ListNode listNode = new ListNode(0);
        ListNode firstNode = listNode;

        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                listNode.next = l1;
                l1 = l1.next;
            } else {
                listNode.next = l2;
                l2 = l2.next;
            }
            listNode = listNode.next;
        }
        while (l1 != null) {
            listNode.next = l1;
            l1 = l1.next;
            listNode = listNode.next;
        }
        while (l2 != null) {
            listNode.next = l2;
            l2 = l2.next;
            listNode = listNode.next;
        }
        return firstNode.next;
    }
}
