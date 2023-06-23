package com.home.henry.string_02;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class L214CreateShortestPalindromic_025Test {

    @Test
    void testCreateShortestPalindrome() {
        assertEquals("abc12321cba", L214_CreateShortestPalindromic_025.createShortestPalindrome("12321cba"));
        assertEquals("abcba", L214_CreateShortestPalindromic_025.createShortestPalindrome("abcba"));
        assertEquals("aaacecaaa", L214_CreateShortestPalindromic_025.createShortestPalindrome("aacecaaa"));
        assertEquals("dcbabcd", L214_CreateShortestPalindromic_025.createShortestPalindrome("abcd"));
    }

}
