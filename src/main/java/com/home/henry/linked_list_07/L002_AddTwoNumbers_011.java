package com.home.henry.linked_list_07;

/**
 * 2. Add Two Numbers
 *
 * You are given two non-empty linked lists representing two non-negative integers. The digits are
 * stored in reverse order and each of their nodes contain a single digit. Add the two numbers and
 * return it as a linked list.
 *
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 *
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4) Output: 7 -> 0 -> 8 Explanation: 342 + 465 = 807.
 */
public class L002_AddTwoNumbers_011 {
    static class Solution {
        public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            ListNode dummy = new ListNode(0);
            ListNode p1 = l1, p2 = l2, cur = dummy;
            int sum = 0;
            while (p1 != null || p2 != null) {
                if (p1 != null) {
                    sum += p1.val;
                    p1 = p1.next;
                }
                if (p2 != null) {
                    sum += p2.val;
                    p2 = p2.next;
                }
                cur.next = new ListNode(sum % 10);
                sum /= 10;
                cur = cur.next;
            }
            if (sum == 1) {
                cur.next = new ListNode(1);
            }
            return dummy.next;
        }
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(5);
        ListNode l2 = new ListNode(3);
        System.out.println(Solution.addTwoNumbers(l1, l2));
    }
}
