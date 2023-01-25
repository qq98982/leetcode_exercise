package com.home.henry.dp_06;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class L416_PartitionEqualSubsetSum_022Test {

    private L416_PartitionEqualSubsetSum_022 l416PartitionEqualSubsetSum022UnderTest;

    @BeforeEach
    void setUp() {
        l416PartitionEqualSubsetSum022UnderTest = new L416_PartitionEqualSubsetSum_022();
    }

    @Test
    void testCanPartition() {
        assertTrue(l416PartitionEqualSubsetSum022UnderTest.canPartition(new int[] { 1,5,11,5 }));
        assertFalse(l416PartitionEqualSubsetSum022UnderTest.canPartition(new int[] { 1,2,3,5 }));
    }
}
