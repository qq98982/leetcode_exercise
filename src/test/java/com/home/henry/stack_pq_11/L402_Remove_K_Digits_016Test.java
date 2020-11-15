package com.home.henry.stack_pq_11;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.home.henry.stack_pq_11.L402_Remove_K_Digits_016.Solution;

class L402_Remove_K_Digits_016Test {
    @Test
    void removeKdigitsTest() {
        assertEquals("1219", Solution.removeKdigits("1432219", 3));
        assertEquals("0", Solution.removeKdigits("9", 1));
        assertEquals("11", Solution.removeKdigits("1111", 2));
        assertEquals("0", Solution.removeKdigits("10", 1));
        assertEquals("200", Solution.removeKdigits("10200", 1));
        assertEquals("125", Solution.removeKdigits("43125", 2));
        assertEquals("11", Solution.removeKdigits("112", 1));
    }
}