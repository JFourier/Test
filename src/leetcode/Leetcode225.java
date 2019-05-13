package leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author He.H
 * @date 2019/5/9 9:30
 **/


public class Leetcode225 {
    public static void main(String[] args) {
        MyStack stack = new MyStack();
        stack.push(1);
        stack.push(2);
        System.out.println(stack.pop());
        stack.push(10);
        System.out.println(stack.pop());
    }
}

class MyStack {

    Queue<Integer> queue = null;
    private int topNum = -1;
    private int stackNum = 0;
    /** Initialize your data structure here. */
    public MyStack() {
        queue = new LinkedList<>();
        stackNum = 0;
    }

    /** Push element x onto stack. */
    public void push(int x) {
        queue.offer(x);
        topNum = x;
        stackNum ++;
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        if(stackNum == 0){
            return -1;
        }else if(stackNum == 1){
            stackNum = 0;
            return queue.poll();
        }else{
            Queue<Integer> tempQueue = new LinkedList<>();
            int index = 1;
            while(index <= stackNum -1){
                tempQueue.offer(queue.poll());
                index ++;
            }
            int num = queue.poll();
            stackNum --;
            index = 1;
            while(index <= stackNum -1){
                queue.offer(tempQueue.poll());
                index ++;
            }
            topNum = tempQueue.poll();
            queue.offer(topNum);
            return num;
        }
    }

    /** Get the top element. */
    public int top() {
        return topNum;
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return stackNum == 0;
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */
