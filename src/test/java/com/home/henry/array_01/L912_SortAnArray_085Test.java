package com.home.henry.array_01;

import com.home.henry.tool.GenRandomArray;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

class L912_SortAnArray_085Test {

    private L912_SortAnArray_085 l912SortAnArray085UnderTest;

    @BeforeEach
    void setUp() throws Exception {
        l912SortAnArray085UnderTest = new L912_SortAnArray_085();
    }

    @Test
    void testSortArray() {
        for (int i = 0; i < 100; i++) {
            final int[] oriInts = GenRandomArray.generateRandomArray(10000, 10000);
            final int[] cpInts = GenRandomArray.copyArray(oriInts);
            l912SortAnArray085UnderTest.sortArray(oriInts);
            Arrays.sort(cpInts);
            // Run the test
            Assertions.assertTrue(GenRandomArray.isEqual(oriInts, cpInts));
        }
    }
}
