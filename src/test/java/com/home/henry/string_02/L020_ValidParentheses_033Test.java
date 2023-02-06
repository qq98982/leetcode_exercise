package com.home.henry.string_02;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class L020_ValidParentheses_033Test {

    private L020_ValidParentheses_033 l020ValidParentheses033UnderTest;

    @BeforeEach
    void setUp() {
        l020ValidParentheses033UnderTest = new L020_ValidParentheses_033();
    }

    @Test
    void testIsValid() {
        assertFalse(l020ValidParentheses033UnderTest.isValid("s"));
        assertFalse(l020ValidParentheses033UnderTest.isValid("(]"));
        assertFalse(l020ValidParentheses033UnderTest.isValid("([)]"));
        assertTrue(l020ValidParentheses033UnderTest.isValid("()"));
        assertTrue(l020ValidParentheses033UnderTest.isValid("()[]{}"));
        assertTrue(l020ValidParentheses033UnderTest.isValid("{[]}"));
    }
}
