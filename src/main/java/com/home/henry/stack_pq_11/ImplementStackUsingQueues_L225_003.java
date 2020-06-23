package com.home.henry.stack_pq_11;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 225. Implement Stack using Queues
 *
 * Implement the following operations of a stack using queues.
 *
 * push(x) -- Push element x onto stack.
 * pop() -- Removes the element on top of the stack.
 * top() -- Get the top element.
 * empty() -- Return whether the stack is empty.
 *
 * Example:
 * MyStack stack = new MyStack();
 * stack.push(1);
 * stack.push(2);
 * stack.top();   // returns 2
 * stack.pop();   // returns 2
 * stack.empty(); // returns false
 */
public class ImplementStackUsingQueues_L225_003 {

    class Solution {
        private Queue<Integer> queue;

        Solution() {
            this.queue = new LinkedList<>();
        }

        public void push(int x) {
            queue.offer(x);
            for (int i = 0; i < queue.size() - 1; i++) {
                queue.offer(queue.poll());
            }
        }

        public int pop() {
            if (!queue.isEmpty()) {
                return queue.poll();
            } else {
                throw new IllegalArgumentException();
            }
        }

        public int top() {
            if (!queue.isEmpty()) {
                return queue.peek();
            } else {
                throw new IllegalArgumentException();
            }
        }

        public boolean empty() {
            return queue.isEmpty();
        }
    }
}
