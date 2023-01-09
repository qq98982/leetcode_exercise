package com.home.henry.dp_06;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class L062_UniquePaths_003Test {

    private L062_UniquePaths_003 l062UniquePaths003UnderTest;

    @BeforeEach
    void setUp() {
        l062UniquePaths003UnderTest = new L062_UniquePaths_003();
    }

    @Test
    void testUniquePaths() {
        assertEquals(28, l062UniquePaths003UnderTest.uniquePaths(3, 7));
        assertEquals(3, l062UniquePaths003UnderTest.uniquePaths(3, 2));
    }

    @Test
    void testUniquePaths2() {
        assertEquals(28, l062UniquePaths003UnderTest.uniquePaths2(3, 7));
        assertEquals(3, l062UniquePaths003UnderTest.uniquePaths2(3, 2));
    }
}
