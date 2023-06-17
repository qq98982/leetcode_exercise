package com.home.henry.array_01;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class L088_MergeSortedArray_088Test {

    private L088_MergeSortedArray_088 l088MergeSortedArray088UnderTest;

    @BeforeEach
    void setUp() throws Exception {
        l088MergeSortedArray088UnderTest = new L088_MergeSortedArray_088();
    }

    @Test
    void testMerge() {
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        l088MergeSortedArray088UnderTest.merge(nums1, 3, new int[]{2, 5, 6}, 3);
        Assertions.assertArrayEquals(new int[]{1, 2, 2, 3, 5, 6}, nums1);
    }
}
