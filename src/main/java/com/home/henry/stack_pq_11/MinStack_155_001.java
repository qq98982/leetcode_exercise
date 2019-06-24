package com.home.henry.stack_pq_11;

import java.util.Stack;

/**
 * 155. Min Stack
 */
public class MinStack_155_001 {
    private Stack<Integer> stack;
    private int min;

    MinStack_155_001(){
        this.stack = new Stack<>();
    }

    public void push(int x) {
        if (x <= min) {
            stack.push(min);
            min = x;
        }
        stack.push(x);
    }

    public void pop() {
        if (stack.pop() == min) {
            min = stack.pop();
        }
    }
    public int top() {
        return stack.peek();
    }
    public int getMin() {
        return min;
    }

}
