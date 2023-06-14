package com.home.henry.string_02;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class L005_LongestPalindromicSubstring_024Test {

    private L005_LongestPalindromicSubstring_024 l005LongestPalindromicSubstring024UnderTest;

    @BeforeEach
    void setUp() {
        l005LongestPalindromicSubstring024UnderTest = new L005_LongestPalindromicSubstring_024();
    }

    @Test
    void testLongestPalindrome() {
        assertEquals("s", l005LongestPalindromicSubstring024UnderTest.longestPalindrome("s"));
        assertEquals("bab", l005LongestPalindromicSubstring024UnderTest.longestPalindrome("babad"));
        assertEquals("bb", l005LongestPalindromicSubstring024UnderTest.longestPalindrome("cbbd"));
        assertEquals("aaaa", l005LongestPalindromicSubstring024UnderTest.longestPalindrome("abaaaa"));
        assertEquals("a", l005LongestPalindromicSubstring024UnderTest.longestPalindrome("abcda"));
        assertEquals("1234567887654321", l005LongestPalindromicSubstring024UnderTest.longestPalindrome("HYTBCABADEFGHABCDEDCBAGHTFYW1234567887654321ZWETYGDE"));
    }

    @Test
    void testLongestPalindrome2() {
        assertEquals("s", l005LongestPalindromicSubstring024UnderTest.longestPalindrome2("s"));
        assertEquals("bab", l005LongestPalindromicSubstring024UnderTest.longestPalindrome2("babad"));
        assertEquals("bb", l005LongestPalindromicSubstring024UnderTest.longestPalindrome2("cbbd"));
        assertEquals("aaaa", l005LongestPalindromicSubstring024UnderTest.longestPalindrome2("abaaaa"));
        assertEquals("a", l005LongestPalindromicSubstring024UnderTest.longestPalindrome2("abcda"));
        assertEquals("1234567887654321", l005LongestPalindromicSubstring024UnderTest.longestPalindrome2("HYTBCABADEFGHABCDEDCBAGHTFYW1234567887654321ZWETYGDE"));
    }

}
