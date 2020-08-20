package com.home.henry.linked_list_07;

/**
 * 92. Reverse Linked List II
 *
 * Reverse a linked list from position m to n. Do it in one-pass.
 * Note: 1 ≤ m ≤ n ≤ length of list.
 * Input: 1->2->3->4->5->NULL, m = 2, n = 4 Output: 1->4->3->2->5->NULL
 */
public class L092_ReverseLinkedListII_005 {

    static class Solution {
        public static ListNode reverseBetween(ListNode head, int m, int n) {
            ListNode dummy = new ListNode(0);
            dummy.next = head;
            ListNode pre = dummy;
            for (int i = 0; i < m - 1; i++) {
                pre = pre.next;
            }
            ListNode start = pre.next;
            for (int i = 0; i < n - m; i++) {
                if (start == null || start.next == null) {break;}
                ListNode then = start.next;
                start.next = then.next;
                then.next = pre.next;
                pre.next = then;
            }
            return dummy.next;
        }
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        for (int i = 2; i < 7; i++) {
            head.next = new ListNode(i);
            head = head.next;
        }
        head = dummy.next;
        ListNode listNode = Solution.reverseBetween(head, 2, 5);
        System.out.println(listNode);
    }
}
