package com.home.henry.others.recite;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class WeightedUnionFindTest {

    private WeightedUnionFind weightedUnionFindUnderTest;

    @BeforeEach
    void setUp() {
        weightedUnionFindUnderTest = new WeightedUnionFind(10);
    }

    @Test
    void testConnected() {
        weightedUnionFindUnderTest.union(0, 1);
        weightedUnionFindUnderTest.union(1, 2);
        weightedUnionFindUnderTest.union(1, 9);
        assertTrue(weightedUnionFindUnderTest.connected(0, 1));
        assertTrue(weightedUnionFindUnderTest.connected(0, 2));
        assertTrue(weightedUnionFindUnderTest.connected(0, 9));
        assertTrue(weightedUnionFindUnderTest.connected(9, 1));
        assertFalse(weightedUnionFindUnderTest.connected(9, 3));
        weightedUnionFindUnderTest.union(9,3);
        assertTrue(weightedUnionFindUnderTest.connected(9, 3));
    }

    @Test
    void testCount() {
        assertEquals(10, weightedUnionFindUnderTest.count());
        weightedUnionFindUnderTest.union(0, 1);
        weightedUnionFindUnderTest.union(1, 2);
        weightedUnionFindUnderTest.union(1, 9);
        weightedUnionFindUnderTest.union(1, 8);
        assertEquals(6, weightedUnionFindUnderTest.count());
    }
}
