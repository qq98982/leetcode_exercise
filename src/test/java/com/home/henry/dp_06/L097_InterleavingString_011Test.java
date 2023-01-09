package com.home.henry.dp_06;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.home.henry.dp_06.L097_InterleavingString_011.Solution;

class L097_InterleavingString_011Test {

    @Test
    void testMain() {
        Assertions.assertTrue(Solution.isInterleave("aabcc", "dbbca", "aadbbcbcac"));
        Assertions.assertTrue(Solution.isInterleave("s", "t", "st"));
        Assertions.assertFalse(Solution.isInterleave("aabcc", "dbbca", "aadbbbaccc"));
        Assertions.assertFalse(Solution.isInterleave("a", "", "c"));
    }
}
