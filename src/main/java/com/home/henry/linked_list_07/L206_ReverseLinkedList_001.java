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
public class L206_ReverseLinkedList_001 {
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode(int x) { val = x; }
     * }
     */
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {return head;}
        ListNode prev = null;
        ListNode curr = head;
        ListNode temp;
        while (curr != null) {
            temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        return prev;
    }

    public ListNode reverseListRecursive(ListNode head) {
        return reverse(head, null);
    }

    private ListNode reverse(ListNode head, ListNode newHead) {
        if (head == null) {return newHead;}
        ListNode curr = head.next;
        head.next = newHead;
        return reverse(curr, head);
    }
}
