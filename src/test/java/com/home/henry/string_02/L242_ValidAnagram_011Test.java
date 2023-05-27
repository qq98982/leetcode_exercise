package com.home.henry.string_02;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class L242_ValidAnagram_011Test {

    private L242_ValidAnagram_011 l242ValidAnagram011UnderTest;

    @BeforeEach
    void setUp() {
        l242ValidAnagram011UnderTest = new L242_ValidAnagram_011();
    }

    @Test
    void testIsAnagram() {
        assertFalse(l242ValidAnagram011UnderTest.isAnagram("s", "t"));
        assertFalse(l242ValidAnagram011UnderTest.isAnagram("rat", "car"));
        assertFalse(l242ValidAnagram011UnderTest.isAnagram("rat", "cars"));
        assertFalse(l242ValidAnagram011UnderTest.isAnagram("nl", "cx"));
        assertTrue(l242ValidAnagram011UnderTest.isAnagram("anagram", "nagaram"));
    }

    @Test
    void testIsAnagram2() {
        assertFalse(l242ValidAnagram011UnderTest.isAnagram2("nl", "cx"));
    }
}
