package jianzhioffer;

import java.util.Stack;

/**
 * @author He.H
 * @date 2019/6/18 11:18
 **/


//包含min函数的栈
public class Offer20 {
    private static Stack<Integer> mStack = new Stack<Integer>();
    private static Stack<Integer> minStack = new Stack<Integer>();

    public static void push(Integer i){
        mStack.push(i);
        if(minStack.size() == 0 || i < minStack.peek()){
            minStack.push(i);
        }else{
            minStack.push(minStack.peek());
        }
    }

    public static void pop(){
        assert(mStack.size() > 0 && minStack.size() > 0);
        minStack.pop();
        mStack.pop();
    }

    public static Integer min(){
        assert(mStack.size() > 0 && minStack.size() > 0);
        return minStack.peek();
    }
}
