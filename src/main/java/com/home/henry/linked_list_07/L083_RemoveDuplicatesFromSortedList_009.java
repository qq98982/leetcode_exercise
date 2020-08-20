package com.home.henry.linked_list_07;

/**
 * 83. Remove Duplicates from Sorted List
 *
 * Given a sorted linked list, delete all duplicates such that each element appear only once.
 *
 * Input: 1->1->2 Output: 1->2
 * Input: 1->1->2->3->3 Output: 1->2->3
 *
 * 如果前一个和后一个值相等, curr.next = curr.next.next, 否则遍历即可
 */
public class L083_RemoveDuplicatesFromSortedList_009 {
    static class Solution {
        public ListNode deleteDuplicates(ListNode head) {
            ListNode dummy = new ListNode(0);
            dummy.next = head;
            ListNode curr = dummy.next;
            while (curr != null) {
                if (curr.next != null && curr.val == curr.next.val) {
                    curr.next = curr.next.next;
                } else {
                    curr = curr.next;
                }
            }
            return dummy.next;
        }
    }
}
