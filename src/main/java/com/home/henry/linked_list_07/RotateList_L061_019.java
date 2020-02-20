package com.home.henry.linked_list_07;

/**
 * 61. Rotate List
 *
 * Given a linked list, rotate the list to the right by k places, where k is non-negative.
 *
 * Input: 1->2->3->4->5->NULL, k = 2 Output: 4->5->1->2->3->NULL
 * Explanation:
 * rotate 1 steps to the right: 5->1->2->3->4->NULL
 * rotate 2 steps to the right: 4->5->1->2->3->NULL
 *
 * Input: 0->1->2->NULL, k = 4 Output: 2->0->1->NULL
 * Explanation:
 * rotate 1 steps to the right: 2->0->1->NULL
 * rotate 2 steps to the right: 1->2->0->NULL
 * rotate 3 steps to the right: 0->1->2->NULL
 * rotate 4 steps to the right: 2->0->1->NULL
 */
public class RotateList_L061_019 {

    static class Solution {
        public static ListNode rotateRight(ListNode head, int k) {
            if (head == null || head.next == null || k < 1) {return head;}
            ListNode dummy = new ListNode(0);
            dummy.next = head;
            ListNode fast = dummy;
            int len = findLen(head);
            int pass = len - (k % len);
            while (pass-- > 0) {
                fast = fast.next;
            }
            ListNode cur = fast.next;
            ListNode tail = cur;
            fast.next = null;
            for (int i = 0; i < k % len - 1; i++) {
                tail = tail.next;
            }
            if (tail != null) {
                tail.next = dummy.next;
            }
            return cur;

        }

        private static int findLen(ListNode head) {
            if (head == null) {return 0;}
            ListNode dummy = new ListNode(0);
            dummy.next = head;
            ListNode cur = dummy;
            int count = 0;
            while (cur != null && cur.next != null) {
                cur = cur.next;
                count++;
            }
            return count;
        }
    }

    // better
    public ListNode rotateRight(ListNode head, int n) {
        if (head == null || head.next == null) { return head; }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode fast = dummy, slow = dummy;

        int i;
        for (i = 0; fast.next != null; i++)//Get the total length
        { fast = fast.next; }

        for (int j = i - n % i; j > 0; j--) //Get the i-n%i th node
        { slow = slow.next; }

        fast.next = dummy.next; //Do the rotation
        dummy.next = slow.next;
        slow.next = null;

        return dummy.next;
    }

    public static void main(String[] args) {
        System.out.println(Solution.rotateRight(new ListNode(new int[] { 0, 1, 2 }), 4));
        System.out.println(Solution.rotateRight(new ListNode(new int[] { 1, 2 }), 2));
    }
}
