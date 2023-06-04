package com.home.henry.array_01;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.api.Test;

class L056_MergeIntervals_046Test {

    @Test
    void testMerge() {
        // Verify the results
        assertArrayEquals(new int[][] { { 1, 6 }, { 8, 10 }, { 15, 18 } }, L056_MergeIntervals_046.merge(
                new int[][] { { 1, 3 }, { 2, 6 }, { 8, 10 }, { 15, 18 } }));

        assertArrayEquals(new int[][] { { 1, 5 } },
                          L056_MergeIntervals_046.merge(new int[][] { { 1, 4 }, { 4, 5 } }));
    }

}
