package jianzhioffer;

import java.util.ArrayList;

/**
 * @author He.H
 * @date 2019/6/18 10:23
 **/

//从尾到头打印链表
public class Offer3 {
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> res = new ArrayList<>();
        if (listNode == null)
            return res;
        ListNode first = listNode;
        ListNode reverseHead = null; //建立一个新的节点用来存放结果
        while (first != null) { //遍历输入链表，开始处理每一个节点
            ListNode second = first.next; //先处理第一个节点first，所以需要一个指针来存储first的后继
            first.next = reverseHead; //将first放到新链表头节点的头部
            reverseHead = first; //移动新链表的头指针，让它始终指向新链表头部
            first = second; //继续处理原链表的节点，即之前指针存放的后继，循环往复
        }
        while(reverseHead != null){
            res.add(reverseHead.val);
            reverseHead = reverseHead.next;
        }
        return res;
    }
}
