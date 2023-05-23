package com.home.henry.array_01;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class L1207_UniqueNumberOfOccurrences_053Test {

    private L1207_UniqueNumberOfOccurrences_053 l1207UniqueNumberOfOccurrences053UnderTest;

    @BeforeEach
    void setUp() throws Exception {
        l1207UniqueNumberOfOccurrences053UnderTest = new L1207_UniqueNumberOfOccurrences_053();
    }

    @Test
    void testUniqueOccurrences() {
        assertTrue(l1207UniqueNumberOfOccurrences053UnderTest.uniqueOccurrences(new int[] { 1,2,2,1,1,3 }));
        assertFalse(l1207UniqueNumberOfOccurrences053UnderTest.uniqueOccurrences(new int[] { 1,2}));
        assertTrue(l1207UniqueNumberOfOccurrences053UnderTest.uniqueOccurrences(new int[] { -3,0,1,-3,1,1,1,-3,10,0 }));
    }
}
