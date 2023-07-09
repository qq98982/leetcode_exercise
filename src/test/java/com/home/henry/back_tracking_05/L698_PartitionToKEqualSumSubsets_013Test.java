package com.home.henry.back_tracking_05;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class L698_PartitionToKEqualSumSubsets_013Test {

    private L698_PartitionToKEqualSumSubsets_013 l698PartitionToKEqualSumSubsets013UnderTest;

    @BeforeEach
    void setUp() {
        l698PartitionToKEqualSumSubsets013UnderTest = new L698_PartitionToKEqualSumSubsets_013();
    }

    @Test
    void testCanPartitionKSubsets() {
        assertTrue(l698PartitionToKEqualSumSubsets013UnderTest.canPartitionKSubsets(new int[] { 4,3,2,3,5,2,1 }, 4));
        assertFalse(l698PartitionToKEqualSumSubsets013UnderTest.canPartitionKSubsets(new int[] { 1,2,3,4 }, 3));
        assertTrue(l698PartitionToKEqualSumSubsets013UnderTest.canPartitionKSubsets(new int[] { 4,4,4,6,1,2,2,9,4,6 }, 3));
        assertFalse(l698PartitionToKEqualSumSubsets013UnderTest.canPartitionKSubsets(new int[] { 2,2,2,2,3,4,5 }, 4));
    }
}
