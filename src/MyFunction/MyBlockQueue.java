package MyFunction;

import java.util.LinkedList;
import java.util.List;

/**
 * @author He.H
 * @date 2019/8/19 10:29
 **/


public class MyBlockQueue {
    public static void main(String[] args) {

    }
    private List queue = new LinkedList();
    private int  limit = 10;

    public MyBlockQueue(int limit){
        this.limit = limit;
    }


    public synchronized void enqueue(Object item)
            throws InterruptedException  {
        while(this.queue.size() == this.limit) {
            wait();
        }
        if(this.queue.size() == 0) {
            notifyAll();
        }
        this.queue.add(item);
    }


    public synchronized Object dequeue()
            throws InterruptedException{
        while(this.queue.size() == 0){
            wait();
        }
        if(this.queue.size() == this.limit){
            notifyAll();
        }

        return this.queue.remove(0);
    }
}
