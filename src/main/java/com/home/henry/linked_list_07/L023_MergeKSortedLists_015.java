package com.home.henry.linked_list_07;

import java.util.PriorityQueue;

/**
 * 23. Merge k Sorted Lists
 *
 * Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.
 *
 * Input: [ 1->4->5, 1->3->4, 2->6 ]
 * Output: 1->1->2->3->4->4->5->6
 */
public class L023_MergeKSortedLists_015 {

    static class Solution {
        public static ListNode mergeKLists(ListNode[] lists) {
            // lists divide half and merge
            if (lists == null || lists.length == 0) {return null;}
            return sort(lists, 0, lists.length - 1);
        }

        private static ListNode sort(ListNode[] lists, int lo, int hi) {
            if (lo >= hi) {return lists[lo];}
            int mid = (hi - lo) / 2 + lo;
            ListNode s1 = sort(lists, lo, mid);
            ListNode s2 = sort(lists, mid + 1, hi);
            return merge(s1, s2);
        }

        private static ListNode merge(ListNode l1, ListNode l2) {
            if (l1 == null) { return l2;}
            if (l2 == null) { return l1;}
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
            if (l1 == null) { cur.next = l2;}
            if (l2 == null) {cur.next = l1;}
            return dummy.next;
        }

        public static ListNode mergeKLists2(ListNode[] lists) {
            if (lists == null || lists.length == 0) {return null;}
            PriorityQueue<ListNode> queue = new PriorityQueue<>(lists.length, (a, b) -> a.val - b.val);
            for (ListNode node : lists) {
                if (node != null) {
                    queue.offer(node);
                }
            }
            ListNode dummy = new ListNode(0);
            ListNode cur = dummy;
            while (!queue.isEmpty()) {
                cur.next = queue.poll();
                cur = cur.next;
                if (cur.next != null) {
                    queue.offer(cur.next);
                }
            }
            return dummy.next;
        }
    }

    public static void main(String[] args) {
        ListNode n1 = new ListNode(new int[] { 1, 2, 3 });
        ListNode n2 = new ListNode(new int[] { 4, 6, 7 });
        ListNode n3 = new ListNode(new int[] { 8, 10, 12, 13, 14 });
        ListNode n4 = new ListNode(new int[] { 9, 18, 23, 78, 124 });
        ListNode[] listNodes = { n1, n2, n3, n4 };
        System.out.println(Solution.mergeKLists2(listNodes));
    }

}
