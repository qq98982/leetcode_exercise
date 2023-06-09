package com.home.henry.binary_search_08;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class L540_SingleElementInASortedArray_022Test {

    private L540_SingleElementInASortedArray_022 l540SingleElementInASortedArray022UnderTest;

    @BeforeEach
    void setUp() {
        l540SingleElementInASortedArray022UnderTest = new L540_SingleElementInASortedArray_022();
    }

    @Test
    void testSingleNonDuplicate() {
        assertEquals(2, l540SingleElementInASortedArray022UnderTest.singleNonDuplicate(
                new int[] { 1, 1, 2, 3, 3, 4, 4, 8, 8 }));
        assertEquals(10, l540SingleElementInASortedArray022UnderTest.singleNonDuplicate(
                new int[] { 3, 3, 7, 7, 10, 11, 11 }));
        assertEquals(2, l540SingleElementInASortedArray022UnderTest.singleNonDuplicate(
                new int[] { 1, 1, 2, 3, 3 }));
        assertEquals(1, l540SingleElementInASortedArray022UnderTest.singleNonDuplicate(
                new int[] { 1 }));
    }
}
