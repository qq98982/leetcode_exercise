package com.home.henry.math_03;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class L043_MultiplyStrings_007Test {

    private L043_MultiplyStrings_007 l043MultiplyStrings007UnderTest;

    @BeforeEach
    void setUp() {
        l043MultiplyStrings007UnderTest = new L043_MultiplyStrings_007();
    }

    @Test
    void testMultiply() {
        assertEquals("6", l043MultiplyStrings007UnderTest.multiply("2", "3"));
        assertEquals("56088", l043MultiplyStrings007UnderTest.multiply("123", "456"));
    }
}
