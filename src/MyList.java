/**
 * @author He.H
 * @date 2019/2/20 9:26
 **/


public class MyList {

    private Node head; // 定义一个头节点
    private Node current; // 记录当前节点

    public static void main(String[] args) {
        MyList myList = new MyList();
        for (int i = 0; i < 5; i++) {
            myList.addData(i); // 循环添加5个元素
        }

        myList.printList(myList.head);   //打印链表
    }

    // 往链表中添加数据
    private void addData(int data) {
        if (head == null) {
            head = new Node(data); // 如果头节点为空，就新建一个头结点
            current = head; // 记录当前节点为头结点
        } else {
            current.next = new Node(data); // 新建一个节点，当前节点的指针域指向它
            current = current.next; // 当前节点位置后移
        }
    }

    // 打印链表
    private void printList(Node head) {
        if (head != null) { // 确定链表不为空
            current = head;
            while (current!= null) { // 最后一个节点的为空
                System.out.print(current.data + "-->");
                current = current.next; // 当前节点往后移动一个位置
            }
        }
    }

    // 递归倒置链表
    private Node resetList1(Node head) {
        if (head == null || head.next == null) {
            return head;                        // 若为空链或者当前结点在尾结点，则直接返回
        } else {
            Node newHead = resetList1(head.next);   //反转后续节点head.next
            head.next.next = head;              //将当前节点的指针域向前移
            head.next = null;                   //前一节点的指针域置空
            return newHead;
        }
    }

    // 遍历方法倒置
    private Node resetList2(Node head) {
        Node current = head;
        Node next = null;
        Node newHead = null;
        if (head == null || head.next == null) {
            return head;
        } else {
            while (current != null) {    //为空时到了尾节点
                next = current.next;     //新结点next缓存下一个节点
                current.next = newHead;  //指针域反转
                newHead = current;       //将当前节点给newHead
                current = next;          //移动到下一个节点
            }
        }
        return newHead;
    }

    // 自定义节点类，包含数据域和指针域
    class Node {
        int data; // 数据域
        Node next; // 指针域

        public Node(int data) {
            this.data = data;
        }
    }
}
