package com.home.henry.linked_list_07;

/**
 * 148. Sort List
 *
 * Sort a linked list in O(n log n) time using constant space complexity.
 *
 * Input: 4->2->1->3 Output: 1->2->3->4
 *
 * Input: -1->5->3->4->0 Output: -1->0->3->4->5
 */
public class SortList_L148_016 {
    static class Solution {
        public static ListNode sortList(ListNode head) {
            if (head == null || head.next == null) {return head;}
            ListNode mid = findMid(head);
            ListNode next = mid.next;
            mid.next = null;
            return merge(sortList(head), sortList(next));
        }

        private static ListNode findMid(ListNode head) {
            if (head == null) {return head;}
            ListNode dummy = new ListNode(0);
            dummy.next = head;
            ListNode fast = dummy, slow = dummy;
            while (fast.next != null) {
                fast = fast.next.next;
                slow = slow.next;
            }
            return slow;
        }

        private static ListNode merge(ListNode l1, ListNode l2) {
            if (l2 == null) {return l1;}
            if (l1 == null) {return l2;}
            ListNode dummy = new ListNode(0);
            ListNode cur = dummy;
            while (l1 != null && l2 != null) {
                if (l1.val <= l2.val) {
                    cur.next = l1;
                    l1 = l1.next;
                } else {
                    cur.next = l2;
                    l2 = l2.next;
                }
                cur = cur.next;
            }
            if (l1 == null) {cur.next = l2;}
            if (l2 == null) {cur.next = l1;}
            return dummy.next;
        }
    }

}
