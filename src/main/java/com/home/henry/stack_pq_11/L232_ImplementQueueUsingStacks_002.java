package com.home.henry.stack_pq_11;

import java.util.Stack;

/**
 * 232. Implement Queue using Stacks
 *
 * Implement the following operations of a queue using stacks.
 *
 * push(x) -- Push element x to the back of queue.
 * pop() -- Removes the element from in front of queue.
 * peek() -- Get the front element.
 * empty() -- Return whether the queue is empty.
 * Example:
 *
 * MyQueue queue = new MyQueue();
 *
 * queue.push(1);
 * queue.push(2);
 * queue.peek();  // returns 1
 * queue.pop();   // returns 1
 * queue.empty(); // returns false
 */
public class L232_ImplementQueueUsingStacks_002 {

    static class Solution {
        private Stack<Integer> queue;

        Solution() {
            queue = new Stack<>();
        }

        public void push(int x) {
            Stack<Integer> tmp = new Stack<>();
            while (queue.isEmpty()) {
                tmp.push(queue.pop());
            }
            queue.push(x);
            while (!tmp.isEmpty()) {
                queue.push(tmp.pop());
            }
        }

        public int pop() {
            if (!queue.isEmpty()) {
                return queue.pop();
            } else {
                throw new IllegalArgumentException();
            }
        }

        public int peek() {
            if (!queue.isEmpty()) {
                return queue.peek();
            } else {
                throw new IllegalArgumentException();
            }
        }

        public boolean isEmpty() {
            return queue.isEmpty();
        }
    }
}
