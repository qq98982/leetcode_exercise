package com.home.henry.dp_06;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class L1143_LongestCommonSubsequence_010Test {

    @Test
    void longestCommonSubsequenceTest() {
        Assertions.assertEquals(3, L1143_LongestCommonSubsequence_010.Solution.longestCommonSubsequence("abcde",
                                                                                                        "ace"));
        Assertions.assertEquals(3, L1143_LongestCommonSubsequence_010.Solution.longestCommonSubsequence("abc",
                                                                                                        "abc"));
        Assertions.assertEquals(0, L1143_LongestCommonSubsequence_010.Solution.longestCommonSubsequence("abc",
                                                                                                        "def"));
    }
}
