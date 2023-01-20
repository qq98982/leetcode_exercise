package com.home.henry.array_01;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class L349_IntersectionOfTwoArrays_039_3Test {

    private L349_IntersectionOfTwoArrays_039_3 l349IntersectionOfTwoArrays0393UnderTest;

    @BeforeEach
    void setUp() {
        l349IntersectionOfTwoArrays0393UnderTest = new L349_IntersectionOfTwoArrays_039_3();
    }

    @Test
    void testIntersection() {
        assertArrayEquals(new int[] { 2 },
                          l349IntersectionOfTwoArrays0393UnderTest.intersection(new int[] { 1, 2, 2, 1 },
                                                                                new int[] { 2, 2 }));
        assertArrayEquals(new int[] { 4, 9 },
                          l349IntersectionOfTwoArrays0393UnderTest.intersection(new int[] { 4, 9, 5 },
                                                                                new int[] { 9, 4, 9, 8, 4 }));
        assertArrayEquals(new int[] {},
                          l349IntersectionOfTwoArrays0393UnderTest.intersection(new int[] { 4, 9, 5 },
                                                                                new int[] {}));
        assertArrayEquals(new int[] { 1 },
                          l349IntersectionOfTwoArrays0393UnderTest.intersection(new int[] { 5, 1 },
                                                                                new int[] { 1 }));
        assertArrayEquals(new int[] { 4, 8, 9 },
                          l349IntersectionOfTwoArrays0393UnderTest.intersection(new int[] { 9, 4, 9, 8, 4 },
                                                                                new int[] { 9, 4, 9, 8, 4 }));
    }
}
