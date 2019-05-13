package com.home.henry.random_11;

import java.util.Random;

/**
 * 382. Linked List Random Node
 *
 * When we read the first node head, if the stream ListNode stops here, we can just return the head.val.
 * The possibility is 1/1.
 * When we read the second node, we can decide if we replace the result r or not. The possibility is 1/2.
 * So we just generate a random number between 0 and 1, and check if it is equal to 1. If it is 1, replace r as the value of the current node, otherwise we don't touch r, so its value is still the value of head.
 * When we read the third node, now the result r is one of value in the head or second node.
 * We just decide if we replace the value of r as the value of current node(third node).
 * The possibility of replacing it is 1/3, namely the possibility of we don't touch r is 2/3.
 * So we just generate a random number between 0 ~ 2, and if the result is 2 we replace r.
 * We can continue to do like this until the end of stream ListNode.
 */
public class LinkedListRandomNode_L382_003 {

    public static class Solution {

        ListNode head;
        Random random;

        public Solution(ListNode h) {
            head = h;
            random = new Random();
        }

        public int getRandom() {

            ListNode c = head;
            int r = c.val;
            for (int i = 1; c.next != null; i++) {

                c = c.next;
                if (random.nextInt(i + 1) == i) { r = c.val; }
            }

            return r;
        }
        private static class ListNode {

            int val;

            ListNode next;

            ListNode(int x) { val = x; }
        }
    }


}
