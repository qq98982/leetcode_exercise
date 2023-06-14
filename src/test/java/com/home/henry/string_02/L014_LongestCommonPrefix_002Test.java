package com.home.henry.string_02;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.home.henry.tool.GenerateRandomStringArray;

class L014_LongestCommonPrefix_002Test {
    @Test
    void testLongestCommonPrefix() {
        assertEquals("a", L014_LongestCommonPrefix_002.longestCommonPrefix(new String[] { "abcd", "aba", "aaab" }));
        assertEquals("a", L014_LongestCommonPrefix_002.longestCommonPrefix(new String[] { "ab", "a" }));
        assertEquals("", L014_LongestCommonPrefix_002.longestCommonPrefix(new String[] { "dog","racecar","car" }));
        assertEquals("fl", L014_LongestCommonPrefix_002.longestCommonPrefix(new String[] { "flower","flow","flight" }));
    }

    @Test
    void testLongestCommonPrefix2() {
        String[] strings = GenerateRandomStringArray.generateStringArray();
        assertEquals(L014_LongestCommonPrefix_002.longestCommonPrefix(strings), L014_LongestCommonPrefix_002.longestCommonPrefix2(strings));
    }

}
