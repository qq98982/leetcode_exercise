package com.home.henry.linked_list_07;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class L203_RemoveLinkedListElements_007Test {

    @Test
    void testRemoveElements() {
        final ListNode head = new ListNode(new int[] { 1, 2, 6, 3, 4, 5, 6 });
        final ListNode result = L203_RemoveLinkedListElements_007.removeElements(head, 6);
        Assertions.assertEquals("1 -> 2 -> 3 -> 4 -> 5 -> null", result.toString());
    }
    @Test
    void testRemoveElements2() {
        final ListNode head = new ListNode(new int[] { 7,7 });
        final ListNode result = L203_RemoveLinkedListElements_007.removeElements(head, 7);
        Assertions.assertEquals(null, result);
    }

    @Test
    void testRemoveElements3() {
        final ListNode head = null;
        final ListNode result = L203_RemoveLinkedListElements_007.removeElements(head, 1);
        Assertions.assertEquals(null, result);
    }
}
