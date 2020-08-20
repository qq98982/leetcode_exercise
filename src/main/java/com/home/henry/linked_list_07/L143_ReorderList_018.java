package com.home.henry.linked_list_07;

/**
 * 143. Reorder List
 *
 * Given a singly linked list L: L0→L1→…→Ln-1→Ln,
 * reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→…
 *
 * You may not modify the values in the list's nodes, only nodes itself may be changed.
 *
 * Given 1->2->3->4, reorder it to 1->4->2->3.
 * Given 1->2->3->4->5, reorder it to 1->5->2->4->3.
 */
public class L143_ReorderList_018 {

    static class Solution {
        public void reorderList(ListNode head) {
            if (head == null || head.next == null) {return;}
            ListNode dummy = new ListNode(0);
            dummy.next = head;
            ListNode mid = findMid(head);
            // split
            ListNode cur = mid.next;
            mid.next = null;
            // reverse
            cur = reverse(cur);
            // reorder
            while (cur != null) {
                ListNode temp = head.next;
                head.next = cur;
                cur = cur.next;
                head.next.next = temp;
                head = temp;
            }
        }

        private static ListNode findMid(ListNode head) {
            if (head == null || head.next == null) {return head;}
            ListNode dummy = new ListNode(0);
            dummy.next = head;
            ListNode fast = dummy, slow = dummy;
            while (fast != null && fast.next != null) {
                fast = fast.next.next;
                slow = slow.next;
            }
            return slow;
        }

        private static ListNode reverse(ListNode head) {
            if (head == null || head.next == null) {return head;}
            ListNode prev = null;
            while (head != null) {
                ListNode temp = head.next;
                head.next = prev;
                prev = head;
                head = temp;
            }
            return prev;
        }
    }
}
