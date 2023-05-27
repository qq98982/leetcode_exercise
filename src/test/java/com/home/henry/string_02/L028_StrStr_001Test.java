package com.home.henry.string_02;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class L028_StrStr_001Test {

    private L028_StrStr_001 l028StrStr001UnderTest;

    @BeforeEach
    void setUp() {
        l028StrStr001UnderTest = new L028_StrStr_001();
    }

    @Test
    void testStrStr3() {
        assertEquals(0, l028StrStr001UnderTest.strStr3("sadbutsad", "sad"));
        assertEquals(-1, l028StrStr001UnderTest.strStr3("leetcode", "leeto"));
        assertEquals(0, l028StrStr001UnderTest.strStr3("a", "a"));


    }

}
