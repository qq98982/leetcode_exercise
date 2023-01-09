package com.home.henry.math_03;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class L050_Pow_X_010Test {

    private L050_Pow_X_010 l050PowX010UnderTest;

    @BeforeEach
    void setUp() {
        l050PowX010UnderTest = new L050_Pow_X_010();
    }

    @Test
    void testMyPow() {
        assertEquals(1024.0, l050PowX010UnderTest.myPow(2.0, 10), 0.0001);
        assertEquals(9.2610, l050PowX010UnderTest.myPow(2.1, 3), 0.0001);
        assertEquals(0.25, l050PowX010UnderTest.myPow(2, -2), 0.0001);
        assertEquals(1, l050PowX010UnderTest.myPow(-1, Integer.MIN_VALUE), 0.0001);
        assertEquals(0, l050PowX010UnderTest.myPow(2, Integer.MIN_VALUE), 0.0001);
    }
}
