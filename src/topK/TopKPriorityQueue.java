package topK;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author He.H
 * @date 2019/7/15 10:35
 **/


public class TopKPriorityQueue {
    public static void main(String[] args) {
        Queue<topNode> q1 = new PriorityQueue<topNode>(com);
        q1.add(new topNode(1,5));
        topNode tmp = new topNode(2,2);
        q1.add(tmp);
        q1.add(new topNode(3,9));
        q1.add(new topNode(4,7));
        for (topNode n : q1) {
            System.out.println("id--"+ n.id +"  value"+n.value);
        }
        tmp.value = 9;
        for (topNode n : q1) {
            System.out.println("id--"+ n.id +"  value"+n.value);
        }
    }
    static Comparator<topNode> com = new Comparator<topNode>() {
        @Override
        public int compare(topNode o1, topNode o2) {
            return o1.value - o2.value;
        }
    };

    static class topNode {
        int id;
        int value;
        public topNode(int id, int value) {
            this.id = id;
            this.value = value;
        }
    }
}
