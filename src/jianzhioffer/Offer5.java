package jianzhioffer;

import java.util.Stack;

/**
 * @author He.H
 * @date 2019/6/18 10:36
 **/


//两个栈实现队列
public class Offer5 {
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

