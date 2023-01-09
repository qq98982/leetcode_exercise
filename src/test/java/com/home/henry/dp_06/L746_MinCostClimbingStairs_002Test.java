package com.home.henry.dp_06;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class L746_MinCostClimbingStairs_002Test {

    private L746_MinCostClimbingStairs_002 l746MinCostClimbingStairs002UnderTest;

    @BeforeEach
    void setUp() {
        l746MinCostClimbingStairs002UnderTest = new L746_MinCostClimbingStairs_002();
    }

    @Test
    void testMinCostClimbingStairs() {
        assertEquals(15, l746MinCostClimbingStairs002UnderTest.minCostClimbingStairs(new int[] { 10, 15, 20 }));
        assertEquals(6, l746MinCostClimbingStairs002UnderTest.minCostClimbingStairs(new int[] { 1, 100, 1, 1, 1, 100, 1, 1, 100, 1 }));
    }
}
