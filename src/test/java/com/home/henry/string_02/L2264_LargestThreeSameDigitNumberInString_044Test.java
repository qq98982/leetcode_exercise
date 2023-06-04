package com.home.henry.string_02;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class L2264_LargestThreeSameDigitNumberInString_044Test {

    private L2264_LargestThreeSameDigitNumberInString_044 l2264LargestThreeSameDigitNumberInString044UnderTest;

    @BeforeEach
    void setUp() throws Exception {
        l2264LargestThreeSameDigitNumberInString044UnderTest =
                new L2264_LargestThreeSameDigitNumberInString_044();
    }

    @Test
    void testLargestGoodInteger() {
        assertEquals("777", l2264LargestThreeSameDigitNumberInString044UnderTest.largestGoodInteger("6777133339"));
        assertEquals("000", l2264LargestThreeSameDigitNumberInString044UnderTest.largestGoodInteger("2300019"));
        assertEquals("", l2264LargestThreeSameDigitNumberInString044UnderTest.largestGoodInteger("42352338"));
    }
}
