package com.home.henry.binary_search_08;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class L1498_NumberOfSubsequencesThatSatisfyTheGivenSumCondition_025Test {

    private L1498_NumberOfSubsequencesThatSatisfyTheGivenSumCondition_025
            l1498NumberOfSubsequencesThatSatisfyTheGivenSumCondition025UnderTest;

    @BeforeEach
    void setUp() {
        l1498NumberOfSubsequencesThatSatisfyTheGivenSumCondition025UnderTest =
                new L1498_NumberOfSubsequencesThatSatisfyTheGivenSumCondition_025();
    }

    @Test
    void testNumSubseq() {
        assertEquals(4, l1498NumberOfSubsequencesThatSatisfyTheGivenSumCondition025UnderTest.numSubseq(
                new int[] { 3, 5, 6, 7 }, 9));
        assertEquals(6, l1498NumberOfSubsequencesThatSatisfyTheGivenSumCondition025UnderTest.numSubseq(
                new int[] { 3, 3, 6, 8 }, 10));
        assertEquals(61, l1498NumberOfSubsequencesThatSatisfyTheGivenSumCondition025UnderTest.numSubseq(
                new int[] { 2, 3, 3, 4, 6, 7 }, 12));
    }
}
