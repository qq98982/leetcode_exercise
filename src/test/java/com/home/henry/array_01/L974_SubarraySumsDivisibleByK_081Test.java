package com.home.henry.array_01;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class L974_SubarraySumsDivisibleByK_081Test {

    private L974_SubarraySumsDivisibleByK_081 l974SubarraySumsDivisibleByK081UnderTest;

    @BeforeEach
    void setUp() throws Exception {
        l974SubarraySumsDivisibleByK081UnderTest = new L974_SubarraySumsDivisibleByK_081();
    }

    @Test
    void testSubarraysDivByK() {
        assertEquals(7,
                     l974SubarraySumsDivisibleByK081UnderTest.subarraysDivByK(new int[] { 4, 5, 0, -2, -3, 1 },
                                                                              5));
        assertEquals(0, l974SubarraySumsDivisibleByK081UnderTest.subarraysDivByK(new int[] { 5 }, 9));
    }
}
