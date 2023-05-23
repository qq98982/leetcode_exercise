package com.home.henry.linked_list_07;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class L002_AddTwoNumbers_011Test {

    @Test
    void testAddTwoNumbers() {
        // Setup
        final ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);
        final ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);

        // Run the test
        final ListNode result = L002_AddTwoNumbers_011.addTwoNumbers(l1, l2);
        assertEquals("7 -> 0 -> 8 -> null", result.toString());
    }

    @Test
    void testAddTwoNumbers2() {
        // Setup
        final ListNode l1 = new ListNode(9);
        l1.next = new ListNode(9);
        l1.next.next = new ListNode(9);
        l1.next.next.next = new ListNode(9);
        l1.next.next.next.next = new ListNode(9);
        l1.next.next.next.next.next = new ListNode(9);
        l1.next.next.next.next.next.next = new ListNode(9);
        final ListNode l2 = new ListNode(9);
        l2.next = new ListNode(9);
        l2.next.next = new ListNode(9);
        l2.next.next.next = new ListNode(9);

        // Run the test
        final ListNode result = L002_AddTwoNumbers_011.addTwoNumbers(l1, l2);
        assertEquals("8 -> 9 -> 9 -> 9 -> 0 -> 0 -> 0 -> 1 -> null", result.toString());
    }


}
