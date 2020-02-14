package com.home.henry.linked_list_07;

/**
 * 19. Remove Nth Node From End of List
 *
 * Given a linked list, remove the n-th node from the end of list and return its head.
 *
 * Given linked list: 1->2->3->4->5, and n = 2.
 *
 * After removing the second node from the end, the linked list becomes 1->2->3->5.
 *
 * Given n will always be valid.
 *
 * Follow up: Could you do this in one pass?
 */
public class RemoveNthNodeFromEndOfList_L019_008 {
    static class Solution {
        public ListNode removeNthFromEnd(ListNode head, int n) {
            if (n == 0) {return head;}
            ListNode dummy = new ListNode(0);
            dummy.next = head;
            ListNode quick = dummy, slow = dummy;
            for (int i = 0; i <= n; i++) {
                quick = quick.next;
            }
            while (quick != null) {
                quick = quick.next;
                slow = slow.next;
            }
            slow.next = slow.next.next;
            return dummy.next;
        }
    }
}
