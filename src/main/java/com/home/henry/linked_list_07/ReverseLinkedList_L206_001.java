package com.home.henry.linked_list_07;

/**
 * 206. Reverse Linked List
 *
 * Reverse a singly linked list.
 *
 * Input: 1->2->3->4->5->NULL
 * Output: 5->4->3->2->1->NULL
 *
 * Follow up:
 * A linked list can be reversed either iteratively or recursively. Could you implement both?
 */
public class ReverseLinkedList_L206_001 {
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode(int x) { val = x; }
     * }
     */
    static class Solution {
        public ListNode reverseList(ListNode head) {
            if (head == null || head.next == null) {return head;}
            ListNode pre = null;
            while (head != null) {
                ListNode temp = head.next;
                head.next = pre;
                pre = head;
                head = temp;
            }
            return pre;
        }

        public ListNode reverseListRecursive(ListNode head) {
            return reverse(head, null);
        }

        private ListNode reverse(ListNode head, ListNode newHead) {
            if (head == null) {return newHead;}
            ListNode next = head.next;
            head.next = newHead;
            return reverse(next, head);
        }
    }
}
