package com.home.henry.dp_06;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class L139_WordBreak_017Test {

    private L139_WordBreak_017 l139WordBreak017UnderTest;

    @BeforeEach
    void setUp() throws Exception {
        l139WordBreak017UnderTest = new L139_WordBreak_017();
    }

    @Test
    void testWordBreak() {
        assertTrue(l139WordBreak017UnderTest.wordBreak("leetcode", Arrays.asList("leet", "code")));
        assertTrue(l139WordBreak017UnderTest.wordBreak("applepenapple", Arrays.asList("apple", "pen")));
        assertFalse(
                l139WordBreak017UnderTest.wordBreak("catsandog", Arrays.asList("cats", "dog", "sand", "and", "cat")));
    }
}
