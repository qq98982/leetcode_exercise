package com.home.henry.linked_list_07;

/**
 * 234. Palindrome Linked List
 *
 * Given a singly linked list, determine if it is a palindrome.
 *
 * Input: 1->2 Output: false
 * Input: 1->2->2->1 Output: true
 * Follow up:
 * Could you do it in O(n) time and O(1) space?
 */
public class PalindromeLinkedList_L234_017 {
    static class Solution {
        public static boolean isPalindrome(ListNode head) {
            ListNode mid = findMid(head);
            ListNode cur = mid.next;
            mid.next = null;
            cur = reverse(cur);
            while (head != null && cur != null) {
                if (head.val != cur.val) {
                    return false;
                }
                head = head.next;
                cur = cur.next;
            }
            return true;
        }

        private static ListNode findMid(ListNode head) {
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
            if (head == null || head.next == null) { return head;}
            ListNode pre = null;
            while (head != null) {
                ListNode temp = head.next;
                head.next = pre;
                pre = head;
                head = temp;
            }
            return pre;
        }
    }

    public static void main(String[] args) {
        System.out.println(Solution.isPalindrome(new ListNode(new int[] { 1, 1, 1, 1 })));
        System.out.println(Solution.isPalindrome(new ListNode(new int[] { 1, 2, 1 })));
        System.out.println(Solution.isPalindrome(new ListNode(new int[] { 1, 2 })));
        System.out.println(Solution.isPalindrome(new ListNode(new int[] { 1 })));
        System.out.println(Solution.isPalindrome(new ListNode(new int[] { 1, 2, 2, 1 })));

    }
}
