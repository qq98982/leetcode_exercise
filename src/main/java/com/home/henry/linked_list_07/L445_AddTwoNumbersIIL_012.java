package com.home.henry.linked_list_07;

import java.util.Stack;

/**
 * 445. Add Two Numbers II
 *
 * You are given two non-empty linked lists representing two non-negative integers.
 * The most significant digit comes first and each of their nodes contain a single digit.
 * Add the two numbers and return it as a linked list.
 *
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 *
 * Follow up:
 * What if you cannot modify the input lists? In other words, reversing the lists is not allowed.
 *
 * Input: (7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4) Output: 7 -> 8 -> 0 -> 7
 */
public class L445_AddTwoNumbersIIL_012 {
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null || l2 == null) {
            return l1 == null ? l2 : l1;
        }
        ListNode p1 = l1, p2 = l2;
        int count = 0;
        int len = 0;
        while (l1 != null || l2 != null) {
            if (l1 != null) {
                count++;
                l1 = l1.next;
            }
            if (l2 != null) {
                count--;
                l2 = l2.next;
            }
            len++;
        }
        int[] buck = new int[len + 1];
        ListNode fast = count >= 0 ? p1 : p2;
        ListNode slow = count >= 0 ? p2 : p1;
        count = count > 0 ? count : -count;
        for (int i = 1; i < buck.length; i++) {
            if (count-- > 0) {
                buck[i] = fast.val;
            } else {
                buck[i] = fast.val + slow.val;
                slow = slow.next;
            }
            fast = fast.next;
        }
        for (int i = buck.length - 1; i > 0; i--) {
            if (buck[i] > 9) {
                buck[i - 1] += 1;
            }
            buck[i] %= 10;
        }
        ListNode dummy = new ListNode(0);
        ListNode p = dummy;
        for (int i = 0; i < buck.length; i++) {
            if (i == 0 && buck[i] == 0) {
                continue;
            }
            p.next = new ListNode(buck[i]);
            p = p.next;
        }

        return dummy.next;
    }

    public static ListNode addTwoNumbersStack(ListNode l1, ListNode l2) {
        if (l1 == null || l2 == null) {
            return l1 == null ? l2 : l1;
        }
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        while (l1 != null || l2 != null) {
            if (l1 != null) {
                stack1.push(l1.val);
                l1 = l1.next;
            }
            if (l2 != null) {
                stack2.push(l2.val);
                l2 = l2.next;
            }
        }
        ListNode res = new ListNode(0);
        int sum = 0;
        while (!stack1.isEmpty() || !stack2.isEmpty()) {
            int sum1 = !stack1.isEmpty() ? stack1.pop() : 0;
            int sum2 = !stack2.isEmpty() ? stack2.pop() : 0;
            sum += sum1 + sum2;
            res.val = sum % 10;
            // 如果不是sum / 10, 而是0, 那么[5,5]时stack会空,返回会出错
            ListNode head = new ListNode(sum / 10);
            head.next = res;
            res = head;
            sum /= 10;
        }
        // 如果领头的是0, 取其next
        return res.val == 0 ? res.next : res;
    }

    public static void main(String[] args) {
        int[] a1 = { 3, 9, 9, 9, 9, 9, 9, 9, 9, 9 }, a2 = { 7 };
//        int[] a1 = { 0 }, a2 = { 7,3 };
        ListNode dummy1 = new ListNode(0);
        ListNode dummy2 = new ListNode(0);
        ListNode l1 = dummy1, l2 = dummy2;
        for (int i : a1) {
            l1.next = new ListNode(i);
            l1 = l1.next;
        }
        for (int i : a2) {
            l2.next = new ListNode(i);
            l2 = l2.next;
        }
        l1 = dummy1.next;
        l2 = dummy2.next;

        System.out.println(l1);
        System.out.println(l2);
        System.out.println(addTwoNumbers(l1, l2));
    }
}
