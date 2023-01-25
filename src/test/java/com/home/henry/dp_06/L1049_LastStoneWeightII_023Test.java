package com.home.henry.dp_06;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class L1049_LastStoneWeightII_023Test {

    private L1049_LastStoneWeightII_023 l1049LastStoneWeightII023UnderTest;

    @BeforeEach
    void setUp() {
        l1049LastStoneWeightII023UnderTest = new L1049_LastStoneWeightII_023();
    }

    @Test
    void testLastStoneWeightII() {
        assertEquals(1, l1049LastStoneWeightII023UnderTest.lastStoneWeightII(new int[] { 2,7,4,1,8,1 }));
        assertEquals(5, l1049LastStoneWeightII023UnderTest.lastStoneWeightII(new int[] { 31,26,33,21,40 }));
    }
}
