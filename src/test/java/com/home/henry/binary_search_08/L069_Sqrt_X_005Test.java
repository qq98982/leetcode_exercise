package com.home.henry.binary_search_08;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class L069_Sqrt_X_005Test {

    private L069_Sqrt_X_005 l069SqrtX005UnderTest;

    @BeforeEach
    void setUp() {
        l069SqrtX005UnderTest = new L069_Sqrt_X_005();
    }

    @Test
    void testMySqrt2() {
        assertEquals(2, l069SqrtX005UnderTest.mySqrt2(4));
        assertEquals(2, l069SqrtX005UnderTest.mySqrt2(8));
    }

    @Test
    void testMySqrt() {
        assertEquals(2, l069SqrtX005UnderTest.mySqrt(4));
        assertEquals(2, l069SqrtX005UnderTest.mySqrt(8));
    }

}
