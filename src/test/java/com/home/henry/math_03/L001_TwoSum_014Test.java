package com.home.henry.math_03;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class L001_TwoSum_014Test {

    private L001_TwoSum_014 l001TwoSum014UnderTest;

    @BeforeEach
    void setUp() {
        l001TwoSum014UnderTest = new L001_TwoSum_014();
    }

    @Test
    void testTwoSum() {
        assertArrayEquals(new int[] { 0, 1 }, l001TwoSum014UnderTest.twoSum(new int[] { 2, 7, 11, 15 }, 9));
        assertArrayEquals(new int[] { 1, 2 }, l001TwoSum014UnderTest.twoSum(new int[] { 3, 2, 4 }, 6));
        assertArrayEquals(new int[] { 0, 1 }, l001TwoSum014UnderTest.twoSum(new int[] { 3, 3 }, 6));
    }
}
