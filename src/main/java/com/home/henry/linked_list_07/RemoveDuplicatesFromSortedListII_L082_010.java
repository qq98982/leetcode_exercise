package com.home.henry.linked_list_07;

/**
 * 82. Remove Duplicates from Sorted List II
 *
 * Given a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct
 * numbers from the original list.
 *
 * Input: 1->2->3->3->4->4->5 Output: 1->2->5
 * Input: 1->1->1->2->3 Output: 2->3
 */
public class RemoveDuplicatesFromSortedListII_L082_010 {
    static class Solution {
        public static ListNode deleteDuplicates(ListNode head) {
            ListNode dummy = new ListNode(0);
            dummy.next = head;
            ListNode pre = dummy;
            while (head != null) {
                while (head.next != null && head.val == head.next.val) {
                    head = head.next;
                }
                if (pre.next != head) {
                    pre.next = head.next;
                    head = pre.next;
                } else {
                    pre = pre.next;
                    head = head.next;
                }
            }
            return dummy.next;
        }
    }

    public static void main(String[] args) {
        ListNode node = new ListNode(0);
        ListNode curr = node;
        for (int i = 1; i < 10; i++) {
            if (i > 1 && i < 3) {
                node.next = new ListNode(1);
            } else if (i > 4 && i < 6) {
                node.next = new ListNode(4);
            } else {
                node.next = new ListNode(i);
            }
            node = node.next;
        }
        System.out.println(curr);
        Solution.deleteDuplicates(curr);
        System.out.println(curr);
    }
}
