package com.home.henry.stack_pq_06;

import java.util.Stack;

/**
 * 232. Implement Queue using Stacks
 */
public class ImplementQueueUsingStacks_L232_002 {

    private Stack<Integer> queue;

    public ImplementQueueUsingStacks_L232_002() {
        this.queue = new Stack<>();
    }

    public void push(int x) {
        Stack<Integer> temp = new Stack<>();
        while (!queue.isEmpty()) {
            temp.push(queue.pop());
        }
        queue.push(x);
        while (!temp.isEmpty()) {
            queue.push(temp.pop());
        }
    }

    public int pop() {
        return queue.pop();
    }

    public int peek() {
        return queue.peek();
    }

    public boolean isEmpty() {
        return queue.isEmpty();
    }
}
