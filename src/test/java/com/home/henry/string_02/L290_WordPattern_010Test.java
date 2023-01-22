package com.home.henry.string_02;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class L290_WordPattern_010Test {

    private L290_WordPattern_010 l290WordPattern010UnderTest;

    @BeforeEach
    void setUp() {
        l290WordPattern010UnderTest = new L290_WordPattern_010();
    }

    @Test
    void testWordPattern() {
        assertTrue(l290WordPattern010UnderTest.wordPattern("abba", "dog cat cat dog"));
        assertFalse(l290WordPattern010UnderTest.wordPattern("abba", "dog cat cat fish"));
        assertFalse(l290WordPattern010UnderTest.wordPattern("aaaa", "dog cat cat dog"));
        assertFalse(l290WordPattern010UnderTest.wordPattern("aaaa", "dog dog dog"));
    }

    @Test
    void testWordPattern2() {
        assertTrue(l290WordPattern010UnderTest.wordPattern2("abba", "dog cat cat dog"));
        assertFalse(l290WordPattern010UnderTest.wordPattern2("abba", "dog cat cat fish"));
        assertFalse(l290WordPattern010UnderTest.wordPattern2("aaaa", "dog cat cat dog"));
        assertFalse(l290WordPattern010UnderTest.wordPattern2("aaaa", "dog dog dog"));
    }

}
