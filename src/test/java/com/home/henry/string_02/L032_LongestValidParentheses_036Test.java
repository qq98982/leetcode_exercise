package com.home.henry.string_02;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class L032_LongestValidParentheses_036Test {

    private L032_LongestValidParentheses_036 l032LongestValidParentheses036UnderTest;

    @BeforeEach
    void setUp() {
        l032LongestValidParentheses036UnderTest = new L032_LongestValidParentheses_036();
    }

    @Test
    void testLongestValidParentheses() {
        assertEquals(4, l032LongestValidParentheses036UnderTest.longestValidParentheses(")()())"));
        assertEquals(2, l032LongestValidParentheses036UnderTest.longestValidParentheses("(()"));
    }
}
