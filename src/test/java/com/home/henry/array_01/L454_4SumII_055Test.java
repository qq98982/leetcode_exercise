package com.home.henry.array_01;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class L454_4SumII_055Test {

    private L454_4SumII_055 l4544SumII055UnderTest;

    @BeforeEach
    void setUp() throws Exception {
        l4544SumII055UnderTest = new L454_4SumII_055();
    }

    @Test
    void testFourSumCount() {
        assertEquals(2,
                     l4544SumII055UnderTest.fourSumCount(new int[] { 1, 2 }, new int[] { -2, -1 },
                                                         new int[] { -1, 2 },
                                                         new int[] { 0, 2 }));
        assertEquals(1,
                     l4544SumII055UnderTest.fourSumCount(new int[] { 0 }, new int[] { 0 },
                                                         new int[] { 0 },
                                                         new int[] { 0 }));
        assertEquals(6,
                     l4544SumII055UnderTest.fourSumCount(new int[] { -1, -1 }, new int[] { -1, 1 },
                                                         new int[] { -1, 1 },
                                                         new int[] { 1, -1 }));
    }
}
