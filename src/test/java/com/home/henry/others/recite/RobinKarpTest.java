package com.home.henry.others.recite;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class RobinKarpTest {

    private RobinKarp robinKarpUnderTest;

    @BeforeEach
    void setUp() {
        robinKarpUnderTest = new RobinKarp();
    }

    @Test
    void testStrStr() {
        assertEquals(-1, robinKarpUnderTest.strStr("source", "target"));
        assertEquals(6, robinKarpUnderTest.strStr("robin karp", "karp"));
        assertEquals(0, robinKarpUnderTest.strStr("robin karp", "robin"));
        assertEquals(3, robinKarpUnderTest.strStr("robin karp", "i"));
        assertEquals(3, robinKarpUnderTest.strStr("abc....", "."));
        assertEquals(-1, robinKarpUnderTest.strStr("abc....", "e"));
        assertEquals(0, robinKarpUnderTest.strStr("abc....", ""));
        assertEquals(0, robinKarpUnderTest.strStr("", ""));
        assertEquals(-1, robinKarpUnderTest.strStr("", "abc"));
    }
}
