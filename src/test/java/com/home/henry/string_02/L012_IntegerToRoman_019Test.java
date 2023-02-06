package com.home.henry.string_02;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class L012_IntegerToRoman_019Test {

    @Test
    void testIntToRoman() {
        assertEquals("III", L012_IntegerToRoman_019.intToRoman(3));
        assertEquals("IV", L012_IntegerToRoman_019.intToRoman(4));
        assertEquals("IX", L012_IntegerToRoman_019.intToRoman(9));
        assertEquals("LVIII", L012_IntegerToRoman_019.intToRoman(58));
        assertEquals("MCMXCIV", L012_IntegerToRoman_019.intToRoman(1994));
    }

}
