package com.home.henry.linked_list_07;

/**
 * 160. Intersection of Two Linked Lists
 *
 * Write a program to find the node at which the intersection of two singly linked lists begins.
 */
public class IntersectionOfTwoLinkedLists_L160_013 {

    static class Solution {
        public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
            // suppose A=a+c; B = b+c;
            // ==> A+B=a+c+b +c
            // ==> B+A=b+c+a +c
            // now, run the same length=(a+c+b), and get the intersection node
            if (headA == null || headB == null) {return null;}
            ListNode a = headA, b = headB;
            while (a != b) {
                a = a == null ? headB : a.next;
                b = b == null ? headA : b.next;
            }
            return a;
        }
    }
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {return null;}
        int offset = 0;
        ListNode dummyA = new ListNode(0);
        dummyA.next = headA;
        ListNode dummyB = new ListNode(0);
        dummyB.next = headB;
        ListNode p1 = dummyA, p2 = dummyB;
        while (p1 != null || p2 != null) {
            if (p1 != null) {
                offset++;
                p1 = p1.next;
            }
            if (p2 != null) {
                offset--;
                p2 = p2.next;
            }
        }
        ListNode k1 = offset >= 0 ? dummyA : dummyB;
        ListNode k2 = offset >= 0 ? dummyB : dummyA;
        offset = offset >= 0 ? offset : -offset;
        while (offset-- > 0) {
            k1 = k1.next;
        }
        while (k1.next != null && k2.next != null) {
            k1 = k1.next;
            k2 = k2.next;
            if (k1 == k2) {return k1;}
        }
        return null;
    }
}
