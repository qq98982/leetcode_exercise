package com.home.henry.linked_list_07;

/**
 * 24. Swap Nodes in Pairs
 * Given a linked list, swap every two adjacent nodes and return its head.
 * You may not modify the values in the list's nodes, only nodes itself may be changed.
 * Example: Given 1->2->3->4, you should return the list as 2->1->4->3.
 */
public class L024_SwapNodesInPairs_003 {

    static class Solution {
        public ListNode swapPairs(ListNode head) {
            if (head == null || head.next == null) {return head;}
            ListNode dummy = new ListNode(0);
            dummy.next = head;
            ListNode l0 = dummy;
            ListNode l1 = head;
            while (l1 != null && l1.next != null) {
                //dummy,  1,  2 , 3, 4
                ListNode nextStart = l1.next.next;
                l0.next = l1.next;
                l1.next.next = l1;
                l1.next = nextStart;
                l0 = l1;
                l1 = l1.next;
            }
            return dummy.next;
        }
    }
}
