package com.home.henry.others.recite;

import java.util.Arrays;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.home.henry.tool.GenRandomArray;

class MergeSortTest {

    @Test
    void testSort() {
        // Setup
        for (int i = 0; i < 100; i++) {
            final int[] oriInts = GenRandomArray.generateRandomArray(10000, 10000);
            final int[] cpInts = GenRandomArray.copyArray(oriInts);
            MergeSort.sort(oriInts);
            Arrays.sort(cpInts);
            // Run the test
            Assertions.assertTrue(GenRandomArray.isEqual(oriInts, cpInts));
        }
    }
}
