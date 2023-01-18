package com.home.henry.array_01;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class L977_SquaresOfASortedArray_036Test {

    private L977_SquaresOfASortedArray_036 l977SquaresOfASortedArray036UnderTest;

    @BeforeEach
    void setUp() {
        l977SquaresOfASortedArray036UnderTest = new L977_SquaresOfASortedArray_036();
    }

    @Test
    void testSortedSquares() {
        assertArrayEquals(new int[] { 0, 1, 9, 16, 100 },
                          l977SquaresOfASortedArray036UnderTest.sortedSquares(new int[] { -4, -1, 0, 3, 10 }));
        assertArrayEquals(new int[] { 4, 9, 9, 49, 121 },
                          l977SquaresOfASortedArray036UnderTest.sortedSquares(new int[] { -7, -3, 2, 3, 11 }));
    }
}
