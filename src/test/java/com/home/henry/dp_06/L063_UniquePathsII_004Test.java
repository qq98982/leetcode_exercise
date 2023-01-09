package com.home.henry.dp_06;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class L063_UniquePathsII_004Test {

    private L063_UniquePathsII_004 l063UniquePathsII004UnderTest;

    @BeforeEach
    void setUp() {
        l063UniquePathsII004UnderTest = new L063_UniquePathsII_004();
    }

    @Test
    void testUniquePathsWithObstacles1() {
        final int[][] obstacleGrid = { { 0, 0, 0}, { 0, 1, 0}, { 0, 0, 0} };

        final int result = l063UniquePathsII004UnderTest.uniquePathsWithObstacles2(obstacleGrid);

        assertEquals(2, result);
    }
    @Test
    void testUniquePathsWithObstacles2() {
        final int[][] obstacleGrid = { { 0, 1}, { 0, 0} };

        final int result = l063UniquePathsII004UnderTest.uniquePathsWithObstacles2(obstacleGrid);

        assertEquals(1, result);
    }
}
