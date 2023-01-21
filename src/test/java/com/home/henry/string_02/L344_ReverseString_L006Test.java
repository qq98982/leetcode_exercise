package com.home.henry.string_02;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * 344. Reverse String
 *
 * Write a function that reverses a string. The input string is given as an array of characters s.
 *
 * You must do this by modifying the input array in-place with O(1) extra memory.
 *
 * Input: s = ["h","e","l","l","o"] Output: ["o","l","l","e","h"]
 *
 * Input: s = ["H","a","n","n","a","h"] Output: ["h","a","n","n","a","H"]
 */
class L344_ReverseString_L006Test {

    private L344_ReverseString_L006 l344ReverseStringL006UnderTest;

    @BeforeEach
    void setUp() {
        l344ReverseStringL006UnderTest = new L344_ReverseString_L006();
    }

    @Test
    void testReverseString1() {
        char[] s = { 'h', 'e', 'l', 'l', 'o' };
        l344ReverseStringL006UnderTest.reverseString(s);
        Assertions.assertEquals("olleh", String.valueOf(s));
    }

    @Test
    void testReverseString2() {
        char[] s = "".toCharArray();
        l344ReverseStringL006UnderTest.reverseString(s);
        Assertions.assertEquals("", String.valueOf(s));
    }

    @Test
    void testReverseString3() {
        char[] s = "a".toCharArray();
        l344ReverseStringL006UnderTest.reverseString(s);
        Assertions.assertEquals("a", String.valueOf(s));
    }

    @Test
    void testReverseString4() {
        char[] s = "h e l ".toCharArray();
        l344ReverseStringL006UnderTest.reverseString(s);
        Assertions.assertEquals(" l e h", String.valueOf(s));
    }

    @Test
    void testReverseString5() {
        char[] s = "Hannah".toCharArray();
        l344ReverseStringL006UnderTest.reverseString(s);
        Assertions.assertEquals("hannaH", String.valueOf(s));
    }
}
