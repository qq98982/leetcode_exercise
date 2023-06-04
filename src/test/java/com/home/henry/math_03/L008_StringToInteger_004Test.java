package com.home.henry.math_03;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class L008_StringToInteger_004Test {

    private L008_StringToInteger_004 l008StringToInteger004UnderTest;

    @BeforeEach
    void setUp() {
        l008StringToInteger004UnderTest = new L008_StringToInteger_004();
    }

    @Test
    void testMyAtoi() {
        assertEquals(42, l008StringToInteger004UnderTest.myAtoi("42"));
        assertEquals(-42, l008StringToInteger004UnderTest.myAtoi("   -42"));
        assertEquals(4193, l008StringToInteger004UnderTest.myAtoi("4193 with words"));
        assertEquals(0, l008StringToInteger004UnderTest.myAtoi("+-12"));
    }

    @Test
    void testMyAtoi2() {
        assertEquals(42, l008StringToInteger004UnderTest.myAtoi2("42"));
        assertEquals(-42, l008StringToInteger004UnderTest.myAtoi2("   -42"));
        assertEquals(4193, l008StringToInteger004UnderTest.myAtoi2("4193 with words"));
        assertEquals(0, l008StringToInteger004UnderTest.myAtoi2("+-12"));
    }
}
