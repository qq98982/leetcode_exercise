package com.home.henry.string_02;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class L151_ReverseWordsInAString_007Test {

    private L151_ReverseWordsInAString_007 l151ReverseWordsInAString007UnderTest;

    @BeforeEach
    void setUp() {
        l151ReverseWordsInAString007UnderTest = new L151_ReverseWordsInAString_007();
    }

    @Test
    void testReverseWords() {
        assertEquals("s", l151ReverseWordsInAString007UnderTest.reverseWords("s"));
        assertEquals("s", l151ReverseWordsInAString007UnderTest.reverseWords("s "));
        assertEquals("world! hello", l151ReverseWordsInAString007UnderTest.reverseWords("  hello world!  "));
        assertEquals("blue is sky the", l151ReverseWordsInAString007UnderTest.reverseWords("the sky is blue"));
        assertEquals("example good a", l151ReverseWordsInAString007UnderTest.reverseWords("a good   example"));
    }
}
