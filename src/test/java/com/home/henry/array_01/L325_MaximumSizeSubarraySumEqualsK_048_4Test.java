package com.home.henry.array_01;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class L325_MaximumSizeSubarraySumEqualsK_048_4Test {

    private L325_MaximumSizeSubarraySumEqualsK_048_4 l325MaximumSizeSubarraySumEqualsK0484UnderTest;

    @BeforeEach
    void setUp() throws Exception {
        l325MaximumSizeSubarraySumEqualsK0484UnderTest = new L325_MaximumSizeSubarraySumEqualsK_048_4();
    }

    @Test
    void testMaxSubArrayEqualsK() {
        assertEquals(2, l325MaximumSizeSubarraySumEqualsK0484UnderTest.maxSubArrayEqualsK(new int[]{-2,-1,2,1}, 1));
        assertEquals(4, l325MaximumSizeSubarraySumEqualsK0484UnderTest.maxSubArrayEqualsK(new int[]{1,-1,5,-2,3}, 3));
        assertEquals(4, l325MaximumSizeSubarraySumEqualsK0484UnderTest.maxSubArrayEqualsK(new int[]{-2,1,-3,4,-1,2,1,-5,4}, 6));
    }
}
