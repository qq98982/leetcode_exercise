package com.home.henry.string_02;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class L383_RansomNote_005Test {

    private L383_RansomNote_005 l383RansomNote005UnderTest;

    @BeforeEach
    void setUp() {
        l383RansomNote005UnderTest = new L383_RansomNote_005();
    }

    @Test
    void testCanConstruct() {
        assertFalse(l383RansomNote005UnderTest.canConstruct("ransomNote", "magazine"));
        assertFalse(l383RansomNote005UnderTest.canConstruct("ransomNote", ""));
        assertTrue(l383RansomNote005UnderTest.canConstruct("", "magazine"));
        assertFalse(l383RansomNote005UnderTest.canConstruct("a", "b"));
        assertFalse(l383RansomNote005UnderTest.canConstruct("aa", "ab"));
        assertTrue(l383RansomNote005UnderTest.canConstruct("aa", "aba"));
        assertTrue(l383RansomNote005UnderTest.canConstruct("aa", "aab"));
    }
}
