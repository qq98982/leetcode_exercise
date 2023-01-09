package com.home.henry.others.recite;

import java.util.Arrays;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.home.henry.tool.GenRandomArray;

class QuickSortTest {

    @Test
    void testQuickSort() {
        // Setup
        for (int i = 0; i < 100; i++) {
            final int[] oriInts = GenRandomArray.generateRandomArray(10000, 10000);
            final int[] cpInts = GenRandomArray.copyArray(oriInts);
            QuickSort.quickSort(oriInts);
            Arrays.sort(cpInts);
            // Run the test
            Assertions.assertTrue(GenRandomArray.isEqual(oriInts, cpInts));
        }
    }

}
