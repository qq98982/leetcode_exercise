package com.home.henry.linked_list_07;

/**
 * 21. Merge Two Sorted Lists
 *
 * Merge two sorted linked lists and return it as a new list. The new list should be made by
 * splicing together the nodes of the first two lists.
 *
 * Input: 1->2->4, 1->3->4 Output: 1->1->2->3->4->4
 */
public class MergeTwoSortedLists_L021_014 {
    // iterative
    static class Solution {
        public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
            if (l1 == null) {return l2;}
            if (l2 == null) {return l1;}
            int cur = Integer.MAX_VALUE;
            ListNode dummy = new ListNode(0);
            ListNode res = dummy;
            while (l1 != null || l2 != null) {
                int c1 = l1 == null ? Integer.MAX_VALUE : l1.val;
                int c2 = l2 == null ? Integer.MAX_VALUE : l2.val;
                int c = Math.min(c1, c2);
                if (l1 != null && c == l1.val) {
                    l1 = l1.next;
                } else {
                    l2 = l2.next;
                }
                res.next = new ListNode(c);
                res = res.next;
            }
            return dummy.next;
        }
    }

    // recursive
    static class Solution2 {
        public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
            if (l1 == null) {return l2;}
            if (l2 == null) {return l1;}
            if (l1.val <= l2.val) {
                l1.next = mergeTwoLists(l1.next, l2);
                return l1;
            } else {
                l2.next = mergeTwoLists(l1, l2.next);
                return l2;
            }
        }
    }

    // not create new list
    static class Solution3 {
        public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
            if (l1 == null) {return l2;}
            if (l2 == null) {return l1;}
            ListNode dummy = new ListNode(0);
            ListNode handler = dummy;
            while (l1 != null && l2 != null) {
                if (l1.val <= l2.val) {
                    handler.next = l1;
                    l1 = l1.next;
                } else {
                    handler.next = l2;
                    l2 = l2.next;
                }
                handler = handler.next;
            }
            if (l1 == null) {
                handler.next = l2;
            } else {
                handler.next = l1;
            }
            return dummy.next;
        }
    }
}
