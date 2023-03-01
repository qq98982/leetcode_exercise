package com.home.henry.linked_list_07;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class L206_ReverseLinkedList_001Test {

    private L206_ReverseLinkedList_001 l206ReverseLinkedList001UnderTest;

    @BeforeEach
    void setUp() {
        l206ReverseLinkedList001UnderTest = new L206_ReverseLinkedList_001();
    }

    @Test
    void testReverseList() {
        final ListNode result = l206ReverseLinkedList001UnderTest.reverseList(
                new ListNode(new int[] { 1, 2, 3, 4, 5 }));
        Assertions.assertEquals("5 -> 4 -> 3 -> 2 -> 1 -> null", result.toString());
    }

    @Test
    void testReverseListRecursive() {
        final ListNode result = l206ReverseLinkedList001UnderTest.reverseListRecursive(
                new ListNode(new int[] { 1, 2, 3, 4, 5 }));
        Assertions.assertEquals("5 -> 4 -> 3 -> 2 -> 1 -> null", result.toString());
    }
}
