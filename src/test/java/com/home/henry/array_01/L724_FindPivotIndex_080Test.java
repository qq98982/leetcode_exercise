package com.home.henry.array_01;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class L724_FindPivotIndex_080Test {

    private L724_FindPivotIndex_080 l724FindPivotIndex080UnderTest;

    @BeforeEach
    void setUp() throws Exception {
        l724FindPivotIndex080UnderTest = new L724_FindPivotIndex_080();
    }

    @Test
    void testPivotIndex() {
        assertEquals(3, l724FindPivotIndex080UnderTest.pivotIndex(new int[] { 1, 7, 3, 6, 5, 6 }));
        assertEquals(-1, l724FindPivotIndex080UnderTest.pivotIndex(new int[] { 1, 2, 3 }));
        assertEquals(0, l724FindPivotIndex080UnderTest.pivotIndex(new int[] { 2, 1, -1 }));
    }
}
