package StackQueue;

import java.util.Stack;

/**
 * @author He.H
 * @date 2019/1/9 9:31
 **/


public class QueueByStack {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        stack1.push(node);
    }

    public int pop() {
        if(stack2.empty()){
            while(!stack1.empty())
                stack2.push(stack1.pop());
        }
        return stack2.pop();
    }
}
