package com.home.henry.binary_search_08;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class L1337_TheKWeakestRowsInAMatrix_021Test {

    private L1337_TheKWeakestRowsInAMatrix_021 l1337TheKWeakestRowsInAMatrix021UnderTest;

    @BeforeEach
    void setUp() {
        l1337TheKWeakestRowsInAMatrix021UnderTest = new L1337_TheKWeakestRowsInAMatrix_021();
    }

    @Test
    void testKWeakestRows() {
        // Setup
        final int[][] mat = new int[][] {
                { 1, 1, 0, 0, 0 }, { 1, 1, 1, 1, 0 }, { 1, 0, 0, 0, 0 }, { 1, 1, 0, 0, 0 }, { 1, 1, 1, 1, 1 }
        };
        final int[][] mat2 = new int[][] { { 1, 0, 0, 0 }, { 1, 1, 1, 1 }, { 1, 0, 0, 0 }, { 1, 0, 0, 0 } };

        // Run the test
        final int[] result = l1337TheKWeakestRowsInAMatrix021UnderTest.kWeakestRows(mat, 3);
        final int[] result2 = l1337TheKWeakestRowsInAMatrix021UnderTest.kWeakestRows(mat2, 2);

        // Verify the results
        assertArrayEquals(new int[] { 2, 0, 3 }, result);
        assertArrayEquals(new int[] { 0, 2 }, result2);
    }

}
