package com.home.henry.linked_list_07;

/**
 * 203. Remove Linked List Elements
 *
 * Remove all elements from a linked list of integers that have value val.
 *
 * Input:  1->2->6->3->4->5->6, val = 6 Output: 1->2->3->4->5
 */
public class L203_RemoveLinkedListElements_007 {
    public static ListNode removeElements(ListNode head, int val) {
        if (head == null) {
            return head;
        }
        // 因为删除可能涉及到头节点，所以设置dummy节点，统一操作
        ListNode dummy = new ListNode(-1, head);
        ListNode pre = dummy;
        ListNode cur = head;
        while (cur != null) {
            if (cur.val == val) {
                pre.next = cur.next;
            } else {
                pre = cur;
            }
            cur = cur.next;
        }
        return dummy.next;
    }

    public static ListNode removeElements2(ListNode head, int val) {
        if (head == null) {return null;}
        head.next = removeElements2(head.next, val);
        return head.val == val ? head.next : head;
    }

    // 这个更容易理解点
    public static ListNode removeElements3(ListNode head, int val) {
        if (head == null) {return null;}
        ListNode next = removeElements3(head.next, val);
        if (head.val == val) {
            return next;
        }
        head.next = next;
        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode curr = head;
        head.next = new ListNode(6);
        head = head.next;
        for (int i = 2; i < 7; i++) {
            head.next = new ListNode(i);
            head = head.next;
        }
        System.out.println(curr);
        ListNode listNode = removeElements(curr, 6);
        System.out.println(listNode);
    }
}
