package com.home.henry.stack_pq_06;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 225. Implement Stack using Queues
 */
public class ImplementStackUsingQueues_L225_003 {

    private Queue<Integer> queue;

    ImplementStackUsingQueues_L225_003() {
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
