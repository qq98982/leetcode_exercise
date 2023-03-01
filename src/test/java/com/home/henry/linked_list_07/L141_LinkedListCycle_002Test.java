package com.home.henry.linked_list_07;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class L141_LinkedListCycle_002Test {

    private L141_LinkedListCycle_002 l141LinkedListCycle002UnderTest;

    @BeforeEach
    void setUp() {
        l141LinkedListCycle002UnderTest = new L141_LinkedListCycle_002();
    }

    @Test
    void testHasCycle() {
        final ListNode head = new ListNode(new int[] { 1, 2, 3, 4, 5 });
        head.next = head.next.next;
        head.next.next = head;
        assertTrue(l141LinkedListCycle002UnderTest.hasCycle(head));
    }
}
