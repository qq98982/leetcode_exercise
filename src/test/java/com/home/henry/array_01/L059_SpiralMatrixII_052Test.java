package com.home.henry.array_01;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class L059_SpiralMatrixII_052Test {

    private L059_SpiralMatrixII_052 l059SpiralMatrixII052UnderTest;

    @BeforeEach
    void setUp() {
        l059SpiralMatrixII052UnderTest = new L059_SpiralMatrixII_052();
    }

    @Test
    void testGenerateMatrix1() {
        // Setup
        final int[][] expectedResult = new int[][] { { 1, 2, 3 }, { 8, 9, 4 }, { 7, 6, 5 } };

        // Run the test
        final int[][] result = l059SpiralMatrixII052UnderTest.generateMatrix(3);

        // Verify the results
        assertArrayEquals(expectedResult, result);
    }

    @Test
    void testGenerateMatrix2() {
        // Setup
        final int[][] expectedResult = new int[][] { { 1 } };

        // Run the test
        final int[][] result = l059SpiralMatrixII052UnderTest.generateMatrix(1);

        // Verify the results
        assertArrayEquals(expectedResult, result);
    }

    @Test
    void testGenerateMatrix3() {
        // Setup
        final int[][] expectedResult =
                new int[][] { { 1, 2, 3, 4 }, { 12, 13, 14, 5 }, { 11, 16, 15, 6 }, { 10, 9, 8, 7 } };

        // Run the test
        final int[][] result = l059SpiralMatrixII052UnderTest.generateMatrix(4);

        // Verify the results
        assertArrayEquals(expectedResult, result);
    }
}
