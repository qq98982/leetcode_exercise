package com.home.henry.dp_06;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class L343_Integer_Break_021Test {

    private L343_Integer_Break_021 l343IntegerBreak021UnderTest;

    @BeforeEach
    void setUp() {
        l343IntegerBreak021UnderTest = new L343_Integer_Break_021();
    }

    @Test
    void testIntegerBreak() {
        assertEquals(1, l343IntegerBreak021UnderTest.integerBreak(2));
        assertEquals(36, l343IntegerBreak021UnderTest.integerBreak(10));
    }
}
