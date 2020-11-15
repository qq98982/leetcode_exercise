package com.home.henry.stack_pq_11;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.home.henry.stack_pq_11.L768_MaxChunksToMakeSortedII_004.Solution;

public class L768_MaxChunksToMakeSortedII_004Test {

    @Test
    void maxChunksToSorted() {
        assertEquals(2, Solution.maxChunksToSorted(new int[] { 1, 1, 0, 0, 1 }));
        assertEquals(1, Solution.maxChunksToSorted(new int[] { 5, 4, 3, 2, 1 }));
        assertEquals(4, Solution.maxChunksToSorted(new int[] { 2, 1, 3, 4, 4 }));
        assertEquals(2, Solution.maxChunksToSorted(new int[] { 2, 1, 1, 3 }));
    }
}