package com.home.henry.array_01;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class L325_1_MaximumSizeSubarraySumCloseToK_048_5Test {

    private L325_1_MaximumSizeSubarraySumCloseToK_048_5 l325MaximumSizeSubarraySumCloseToK0485UnderTest;

    @BeforeEach
    void setUp() throws Exception {
        l325MaximumSizeSubarraySumCloseToK0485UnderTest = new L325_1_MaximumSizeSubarraySumCloseToK_048_5();
    }

    @Test
    void testMaxSubarrayCloseToK() {
        assertEquals(3, l325MaximumSizeSubarraySumCloseToK0485UnderTest.maxSubarrayCloseToK(new int[]{1,-1,5,-2,3}, 3));
        assertEquals(1, l325MaximumSizeSubarraySumCloseToK0485UnderTest.maxSubarrayCloseToK(new int[]{-2,-1,2,1}, 1));
        assertEquals(6, l325MaximumSizeSubarraySumCloseToK0485UnderTest.maxSubarrayCloseToK(new int[]{-2,1,-3,4,-1,2,1,-5,4}, 6));
    }
}
