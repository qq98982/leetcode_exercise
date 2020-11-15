package com.home.henry.stack_pq_11;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.home.henry.stack_pq_11.L084_LargestRectangleInHistogram_009.Solution;

class L084_LargestRectangleInHistogram_009Test {

    @Test
    void largestRectangleAreaTest() {
        assertEquals(10, Solution.largestRectangleArea(new int[] { 2, 1, 5, 6, 2, 3 }));
        assertEquals(8, Solution.largestRectangleArea(new int[] { 7, 2, 1, 4, 5, 1, 3, 3 }));
        assertEquals(4000, Solution.largestRectangleArea(new int[] { 4, 1000, 1000, 1000, 1000 }));
        assertEquals(0, Solution.largestRectangleArea(new int[] { 0 }));
    }

}