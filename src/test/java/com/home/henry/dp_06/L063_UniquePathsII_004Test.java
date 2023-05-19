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
        assertEquals(1, l063UniquePathsII004UnderTest.uniquePathsWithObstacles(
                new int[][] { { 0, 1 }, { 0, 0 } }));
        assertEquals(2, l063UniquePathsII004UnderTest.uniquePathsWithObstacles(
                new int[][] { { 0, 0, 0 }, { 0, 1, 0 }, { 0, 0, 0 } }));
        assertEquals(0, l063UniquePathsII004UnderTest.uniquePathsWithObstacles(
                new int[][] { { 1, 0 } }));
        assertEquals(0, l063UniquePathsII004UnderTest.uniquePathsWithObstacles(
                new int[][] { { 0, 0 }, { 1, 1 }, { 0, 0 } }));
    }

    @Test
    void testUniquePathsWithObstacles2() {

        assertEquals(1, l063UniquePathsII004UnderTest.uniquePathsWithObstacles2(
                new int[][] { { 0, 1 }, { 0, 0 } }));
        assertEquals(2, l063UniquePathsII004UnderTest.uniquePathsWithObstacles2(
                new int[][] { { 0, 0, 0 }, { 0, 1, 0 }, { 0, 0, 0 } }));
        assertEquals(0, l063UniquePathsII004UnderTest.uniquePathsWithObstacles2(
                new int[][] { { 1, 0 } }));
        assertEquals(0, l063UniquePathsII004UnderTest.uniquePathsWithObstacles2(
                new int[][] { { 0, 0 }, { 1, 1 }, { 0, 0 } }));
    }
}
