package com.home.henry.dp_06;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class L494_TargetSum_024Test {

    private L494_TargetSum_024 l494TargetSum024UnderTest;

    @BeforeEach
    void setUp() {
        l494TargetSum024UnderTest = new L494_TargetSum_024();
    }

    @Test
    void testFindTargetSumWays() {
        assertEquals(5, l494TargetSum024UnderTest.findTargetSumWays(new int[] { 1, 1, 1, 1, 1 }, 3));
        assertEquals(1, l494TargetSum024UnderTest.findTargetSumWays(new int[] { 1 }, 1));
        assertEquals(32, l494TargetSum024UnderTest.findTargetSumWays(new int[] { 0, 0, 0, 0, 0 }, 0));
    }
}
