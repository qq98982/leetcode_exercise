package com.home.henry.linked_list_07;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class L146_LRUCache_021Test {

    private L146_LRUCache_021 l146LruCache021UnderTest;

    @BeforeEach
    void setUp() {
        l146LruCache021UnderTest = new L146_LRUCache_021(2);
    }

    @Test
    void testLRUCache() {
        l146LruCache021UnderTest.put(1,1);
        l146LruCache021UnderTest.put(2,2);
        assertEquals(1, l146LruCache021UnderTest.get(1));
        l146LruCache021UnderTest.put(3,3);
        assertEquals(-1, l146LruCache021UnderTest.get(2));
        l146LruCache021UnderTest.put(4,4);
        assertEquals(-1, l146LruCache021UnderTest.get(1));
        assertEquals(3, l146LruCache021UnderTest.get(3));
        assertEquals(4, l146LruCache021UnderTest.get(4));
    }
    @Test
    void testLRUCache2() {
        l146LruCache021UnderTest.put(2,1);
        l146LruCache021UnderTest.put(1,2);
        l146LruCache021UnderTest.put(2,3);
        l146LruCache021UnderTest.put(4,1);
        assertEquals(-1, l146LruCache021UnderTest.get(1));
        assertEquals(3, l146LruCache021UnderTest.get(2));
    }


}
