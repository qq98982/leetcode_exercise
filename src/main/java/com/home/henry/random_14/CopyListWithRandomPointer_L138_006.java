package com.home.henry.random_14;

import java.util.HashMap;
import java.util.Map;

/**
 * 138. Copy List with Random Pointer
 * A linked list is given such that each node contains an additional random pointer
 * which could point to any node in the list or null. Return a deep copy of the list.
 * Example 1:
 * Input:
 * {"$id":"1","next":{"$id":"2","next":null,"random":{"$ref":"2"},"val":2},"random":{"$ref":"2"},"val":1}
 * Explanation:
 * Node 1's value is 1, both of its next and random pointer points to Node 2.
 * Node 2's value is 2, its next pointer points to null and its random pointer points to itself.
 */
public class CopyListWithRandomPointer_L138_006 {

    // Definition for a Node.

    static class Solution {
        // https://leetcode.com/problems/copy-list-with-random-pointer/discuss/43491/A-solution-with-constant-space-complexity-O(1)-and-linear-time-complexity-O(N)
        // The idea is to associate the original node with its copy node in a single linked list. In this way,
        // we don't need extra space to keep track of the new nodes.
        // The algorithm is composed of the follow three steps which are also 3 iteration rounds.
        //
        // Iterate the original list and duplicate each node. The duplicate
        // of each node follows its original immediately.
        // Iterate the new list and assign the random pointer for each
        // duplicated node.
        // Restore the original list and extract the duplicated nodes.
        // The algorithm is implemented as follows:
        public RandomListNode copyRandomList(RandomListNode head) {
            RandomListNode iter = head, next;

            // First round: make copy of each node,
            // and link them together side-by-side in a single list.
            while (iter != null) {
                next = iter.next;

                RandomListNode copy = new RandomListNode(iter.val);
                iter.next = copy;
                copy.next = next;
                iter = next;
            }

            // Second round: assign random pointers for the copy nodes.
            iter = head;
            while (iter != null) {
                if (iter.random != null) {
                    iter.next.random = iter.random.next;
                }
                iter = iter.next.next;
            }

            // Third round: restore the original list, and extract the copy list.
            iter = head;
            RandomListNode pseudoHead = new RandomListNode(0);
            RandomListNode copy, copyIter = pseudoHead;

            while (iter != null) {
                next = iter.next.next;

                // extract the copy
                copy = iter.next;
                copyIter.next = copy;
                copyIter = copy;

                // restore the original list
                iter.next = next;

                iter = next;
            }

            return pseudoHead.next;
        }

        private static class RandomListNode {
            public int val;
            public RandomListNode next;
            private RandomListNode random;

            public RandomListNode() {}

            public RandomListNode(int val) {this.val = val;}

            public RandomListNode(int _val, RandomListNode _next, RandomListNode _random) {
                val = _val;
                next = _next;
                random = _random;
            }
        }
    }

    static class SolutionWithMap {
        public Node copyRandomList(Node head) {
            Map<Node, Node> map = new HashMap<>();
            Node cur = head;
            while (cur != null) {
                map.put(cur, new Node(cur.val));
                cur = cur.next;
            }
            cur = head;
            while (cur != null) {
                map.get(cur).next = map.get(cur.next);
                map.get(cur).random = map.get(cur.random);
                cur = cur.next;
            }
            return map.get(head);
        }

        private class Node {
            public int val;
            public Node next;
            public Node random;

            public Node() {}

            public Node(int val) {this.val = val;}

            public Node(int _val, Node _next, Node _random) {
                val = _val;
                next = _next;
                random = _random;
            }
        }

        ;
    }

}
