package com.home.henry.array_01;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class L209_MinimumSizeSubarraySum_051Test {

    private L209_MinimumSizeSubarraySum_051 l209MinimumSizeSubarraySum051UnderTest;

    @BeforeEach
    void setUp() {
        l209MinimumSizeSubarraySum051UnderTest = new L209_MinimumSizeSubarraySum_051();
    }

    @Test
    void testMinSubArrayLen() {
        assertEquals(2, l209MinimumSizeSubarraySum051UnderTest.minSubArrayLen(7, new int[] { 2,3,1,2,4,3 }));
        assertEquals(1, l209MinimumSizeSubarraySum051UnderTest.minSubArrayLen(4, new int[] { 1,4,4 }));
        assertEquals(0, l209MinimumSizeSubarraySum051UnderTest.minSubArrayLen(11, new int[] { 1,1,1,1,1,1,1,1 }));
    }

    @Test
    void testMinSubArrayLenBS() {
        assertEquals(2, l209MinimumSizeSubarraySum051UnderTest.minSubArrayLenBS(7, new int[] { 2,3,1,2,4,3 }));
        assertEquals(1, l209MinimumSizeSubarraySum051UnderTest.minSubArrayLenBS(4, new int[] { 1,4,4 }));
        assertEquals(0, l209MinimumSizeSubarraySum051UnderTest.minSubArrayLenBS(11, new int[] { 1,1,1,1,1,1,1,1 }));
    }
}
