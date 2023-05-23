package com.home.henry.array_01;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class L053_MaximumSubarray_023Test {

    private L053_MaximumSubarray_023 l053MaximumSubarray023UnderTest;

    @BeforeEach
    void setUp() throws Exception {
        l053MaximumSubarray023UnderTest = new L053_MaximumSubarray_023();
    }

    @Test
    void testMaxSubArray() {
        assertEquals(6, l053MaximumSubarray023UnderTest.maxSubArray(new int[] { -2,1,-3,4,-1,2,1,-5,4 }));
        assertEquals(1, l053MaximumSubarray023UnderTest.maxSubArray(new int[] {1}));
        assertEquals(23, l053MaximumSubarray023UnderTest.maxSubArray(new int[] { 5,4,-1,7,8}));
    }

    @Test
    void testMaxSubArrayDP() {
        assertEquals(6, l053MaximumSubarray023UnderTest.maxSubArrayDP(new int[] { -2,1,-3,4,-1,2,1,-5,4 }));
        assertEquals(1, l053MaximumSubarray023UnderTest.maxSubArrayDP(new int[] {1}));
        assertEquals(23, l053MaximumSubarray023UnderTest.maxSubArrayDP(new int[] { 5,4,-1,7,8}));
    }
}
