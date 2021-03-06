package ListNode;

import java.util.ArrayList;

/**
 * @author He.H
 * @date 2019/1/8 20:00
 **/


public class ReverseList {
    public ListNode reverseList(ListNode head) {
        ListNode first = head;
        ListNode reverseHead = null; //建立一个新的节点用来存放结果
        while (first != null) { //遍历输入链表，开始处理每一个节点
            ListNode second = first.next; //先处理第一个节点first，所以需要一个指针来存储first的后继
            first.next = reverseHead; //将first放到新链表头节点的头部
            reverseHead = first; //移动新链表的头指针，让它始终指向新链表头部
            first = second; //继续处理原链表的节点，即之前指针存放的后继，循环往复
        }
        return reverseHead;


        /*
        if (head == null || head.next == null) return head; //处理最小输入的情况，即空链表和单节点链表
        ListNode second = head.next; //将即将被调用的下一个节点分离，即将下一个调用的输入存在second里
        ListNode reverseHead = reverseList(second); //将调用后的结果存储，这个结果就是最终结果。之后利用递归，调用刚才存好的输入
        second.next = head; //上面一步的调用已经完成以second为首的链表的反转，所以现在second变成了反转完成后的尾节点
　　　　　　　　　　　　　　　　 //把这个尾节点的next指向一开始输入的前驱，即head，完成整个链表反转
        head.next = null; //最开始的头节点要变成尾节点，即在后面补null使链表终结
        return reverseHead;
        */
    }
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
