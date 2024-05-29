package com.home.henry.back_tracking_05;

import static org.junit.jupiter.api.Assertions.assertIterableEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class L039_CombinationSum_004Test {

    private L039_CombinationSum_004 l039CombinationSum004UnderTest;

    @BeforeEach
    void setUp() {
        l039CombinationSum004UnderTest = new L039_CombinationSum_004();
    }

    @Test
    void testCombinationSum() {
        assertIterableEquals(Arrays.asList(Arrays.asList(2, 2, 3), Arrays.asList(7)),
                             l039CombinationSum004UnderTest.combinationSum(new int[] { 2, 3, 6, 7 }, 7));
        assertIterableEquals(Arrays.asList(Arrays.asList(2, 2, 2, 2), Arrays.asList(2, 3, 3), Arrays.asList(3, 5)),
                             l039CombinationSum004UnderTest.combinationSum(new int[] { 2, 3, 5 }, 8));
    }
}
