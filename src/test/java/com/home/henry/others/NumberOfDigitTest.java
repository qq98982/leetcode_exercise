package com.home.henry.others;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class NumberOfDigitTest {

    private NumberOfDigit numberOfDigitUnderTest;

    @BeforeEach
    void setUp() {
        numberOfDigitUnderTest = new NumberOfDigit();
    }

    @Test
    void testNumOfDigits() {
        assertArrayEquals(new int[] { 2,3,5 }, numberOfDigitUnderTest.numOfDigits(new int[] { 25,2,3,57,38,41 }));
    }
}
