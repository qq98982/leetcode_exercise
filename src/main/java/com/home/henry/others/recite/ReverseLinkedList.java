package com.home.henry.others.recite;

public class ReverseLinkedList {

    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int n) {
            this.val = n;
            this.next = null;
        }
    }

    static class SolutionIterate {
        public ListNode reverse(ListNode head) {
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

    static class SolutionRecursive {
        public ListNode reverse(ListNode head) {
            return reverse(head, null);
        }

        private ListNode reverse(ListNode head, ListNode newHead) {
            if (head == null) {
                return newHead;
            }
            ListNode next = head.next;
            head.next = newHead;
            return reverse(newHead, next);
        }
    }
}
