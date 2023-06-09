package com.home.henry.binary_search_08;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class L410_SplitArrayLargestSum_024Test {

    private L410_SplitArrayLargestSum_024 l410SplitArrayLargestSum024UnderTest;

    @BeforeEach
    void setUp() {
        l410SplitArrayLargestSum024UnderTest = new L410_SplitArrayLargestSum_024();
    }

    @Test
    void testSplitArray() {
        assertEquals(18, l410SplitArrayLargestSum024UnderTest.splitArray(new int[] { 7,2,5,10,8 }, 2));
        assertEquals(9, l410SplitArrayLargestSum024UnderTest.splitArray(new int[] { 1,2,3,4,5 }, 2));
    }
}
