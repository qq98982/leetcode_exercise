package com.home.henry.math_03;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class L231_PowerOfTwo_017Test {

    private L231_PowerOfTwo_017 l231PowerOfTwo017UnderTest;

    @BeforeEach
    void setUp() {
        l231PowerOfTwo017UnderTest = new L231_PowerOfTwo_017();
    }

    @Test
    void testIsPowerOfTwo() {
        assertFalse(l231PowerOfTwo017UnderTest.isPowerOfTwo(3));
        assertTrue(l231PowerOfTwo017UnderTest.isPowerOfTwo(1));
        assertTrue(l231PowerOfTwo017UnderTest.isPowerOfTwo(16));
        assertFalse(l231PowerOfTwo017UnderTest.isPowerOfTwo(0));
        assertTrue(l231PowerOfTwo017UnderTest.isPowerOfTwo(1));
        assertFalse(l231PowerOfTwo017UnderTest.isPowerOfTwo(15));
        assertFalse(l231PowerOfTwo017UnderTest.isPowerOfTwo(-16));
    }
}
