package com.home.henry.stack_pq_11;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.home.henry.stack_pq_11.L769_MaxChunksToMakeSorted_003.Solution;

class L769_MaxChunksToMakeSorted_003Test {

    @Test
    void maxChunksToSorted() {
        assertEquals(1, Solution.maxChunksToSorted(new int[] { 4, 3, 2, 1, 0 }));
        assertEquals(4, Solution.maxChunksToSorted(new int[] { 1, 0, 2, 3, 4 }));
        assertEquals(1, Solution.maxChunksToSorted(new int[] { 2, 0, 1 }));
        assertEquals(2, Solution.maxChunksToSorted(new int[] { 1, 2, 0, 3 }));
    }
}