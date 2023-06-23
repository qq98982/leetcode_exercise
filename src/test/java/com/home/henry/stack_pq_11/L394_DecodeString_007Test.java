package com.home.henry.stack_pq_11;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class L394_DecodeString_007Test {

    private L394_DecodeString_007 l394DecodeString007UnderTest;

    @BeforeEach
    void setUp() {
        l394DecodeString007UnderTest = new L394_DecodeString_007();
    }

    @Test
    void testDecodeString() {
        assertEquals("aaabcbc", l394DecodeString007UnderTest.decodeString("3[a]2[bc]"));
        assertEquals("accaccacc", l394DecodeString007UnderTest.decodeString("3[a2[c]]"));
        assertEquals("abcabccdcdcdef", l394DecodeString007UnderTest.decodeString("2[abc]3[cd]ef"));
    }
}
