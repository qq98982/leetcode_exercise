package com.home.henry.dp_06;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class L740_DeleteAndEarn_012Test {

    private L740_DeleteAndEarn_012 l740DeleteAndEarn012UnderTest;

    @BeforeEach
    void setUp() {
        l740DeleteAndEarn012UnderTest = new L740_DeleteAndEarn_012();
    }
    @Test
    void deleteAndEarnTest() {
        Assertions.assertEquals(6, L740_DeleteAndEarn_012.Solution.deleteAndEarn(new int[] {3,4,2}));
    }
}
