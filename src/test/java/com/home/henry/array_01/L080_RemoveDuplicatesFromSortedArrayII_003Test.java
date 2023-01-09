package com.home.henry.array_01;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class L080_RemoveDuplicatesFromSortedArrayII_003Test {

    private L080_RemoveDuplicatesFromSortedArrayII_003 l080RemoveDuplicatesFromSortedArrayII003UnderTest;

    @BeforeEach
    void setUp() {
        l080RemoveDuplicatesFromSortedArrayII003UnderTest = new L080_RemoveDuplicatesFromSortedArrayII_003();
    }

    @Test
    void testRemoveDuplicates1() {
        int[] nums = { 1, 1, 1, 2, 2, 3 };
        int res = 5;
        assertEquals(res, l080RemoveDuplicatesFromSortedArrayII003UnderTest.removeDuplicates(nums));
    }

    @Test
    void testRemoveDuplicates2() {
        int[] nums = { 0, 0, 1, 1, 1, 1, 2, 3, 3 };
        int res = 7;
        assertEquals(res, l080RemoveDuplicatesFromSortedArrayII003UnderTest.removeDuplicates(nums));
    }
}
