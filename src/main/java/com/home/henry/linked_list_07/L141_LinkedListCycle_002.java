package com.home.henry.linked_list_07;

/**
 * 141. Linked List Cycle
 *
 *
 * Given a linked list, determine if it has a cycle in it.
 * To represent a cycle in the given linked list, we use an integer pos which represents the position
 * (0-indexed) in the linked list where tail connects to. If pos is -1, then there is no cycle in the linked list.
 */
public class L141_LinkedListCycle_002 {

    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {return false;}
        ListNode slow = head;
        ListNode quick = head;
        while (quick != null && quick.next != null) {
            slow = slow.next;
            quick = quick.next.next;
            if (slow == quick) {
                return true;
            }
        }
        return false;
    }
}
