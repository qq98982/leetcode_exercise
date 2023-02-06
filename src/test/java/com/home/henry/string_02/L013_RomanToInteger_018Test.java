package com.home.henry.string_02;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class L013_RomanToInteger_018Test {

    @Test
    void testRomanToInt() {
        assertEquals(3, L013_RomanToInteger_018.romanToInt("III"));
        assertEquals(4, L013_RomanToInteger_018.romanToInt("IV"));
        assertEquals(9, L013_RomanToInteger_018.romanToInt("IX"));
        assertEquals(58, L013_RomanToInteger_018.romanToInt("LVIII"));
        assertEquals(1994, L013_RomanToInteger_018.romanToInt("MCMXCIV"));
    }

}
