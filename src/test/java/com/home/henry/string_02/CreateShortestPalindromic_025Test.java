package com.home.henry.string_02;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class CreateShortestPalindromic_025Test {

    @Test
    void testCreateShortestPalindrome() {
        assertEquals("abc12321cba", CreateShortestPalindromic_025.createShortestPalindrome("12321cba"));
        assertEquals("abcba", CreateShortestPalindromic_025.createShortestPalindrome("abcba"));
        assertEquals("aaacecaaa", CreateShortestPalindromic_025.createShortestPalindrome("aacecaaa"));
        assertEquals("dcbabcd", CreateShortestPalindromic_025.createShortestPalindrome("abcd"));
    }

}
