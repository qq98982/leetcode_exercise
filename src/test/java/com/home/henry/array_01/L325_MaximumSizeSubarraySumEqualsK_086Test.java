package com.home.henry.array_01;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class L325_MaximumSizeSubarraySumEqualsK_086Test {

    private L325_MaximumSizeSubarraySumEqualsK_086 l325MaximumSizeSubarraySumEqualsK086UnderTest;

    @BeforeEach
    void setUp() throws Exception {
        l325MaximumSizeSubarraySumEqualsK086UnderTest = new L325_MaximumSizeSubarraySumEqualsK_086();
    }

    @Test
    void testMaxSubArrayLen() {
        assertEquals(4, l325MaximumSizeSubarraySumEqualsK086UnderTest.maxSubArrayLen(new int[]{1, -1, 5, -2, 3}, 3));
        assertEquals(2, l325MaximumSizeSubarraySumEqualsK086UnderTest.maxSubArrayLen(new int[]{-2, -1, 2, 1}, 1));
    }
}
