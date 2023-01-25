package com.home.henry.dp_06;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class L474_Ones_and_Zeroes_025Test {

    private L474_Ones_and_Zeroes_025 l474OnesAndZeroes025UnderTest;

    @BeforeEach
    void setUp() throws Exception {
        l474OnesAndZeroes025UnderTest = new L474_Ones_and_Zeroes_025();
    }

    @Test
    void testFindMaxForm() {
        assertEquals(4, l474OnesAndZeroes025UnderTest.findMaxForm(
                new String[] { "10", "0001", "111001", "1", "0" }, 5, 3));
        assertEquals(2, l474OnesAndZeroes025UnderTest.findMaxForm(
                new String[] { "10","0","1" }, 1, 1));
    }
}
