package com.home.henry.others;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class L560_SubarraySumEqualsK_GoogleTest {

    @Test
    void testSubarraySum() {
        assertEquals(2, L560_SubarraySumEqualsK_Google.subarraySum(new int[] { 1, 1, 1 }, 2));
        assertEquals(2, L560_SubarraySumEqualsK_Google.subarraySum(new int[] { 1, 2, 3 }, 3));
        assertEquals(6, L560_SubarraySumEqualsK_Google.subarraySum(new int[] { 3, 4, 7, -2, 2, 1, 4, 2 }, 7));
        assertEquals(3, L560_SubarraySumEqualsK_Google.subarraySum(new int[] { 2, 3, 6, 5, 4, 1, 10 }, 5));
        assertEquals(3, L560_SubarraySumEqualsK_Google.subarraySum(
                new int[] { -4, 3, 6, -2, 1, -1, 0, 2, -2, 3, 1 }, 5));
    }

    @Test
    void testLongestSubarrayLength() {
        assertEquals(1, L560_SubarraySumEqualsK_Google.longestSubarrayLength(new int[] { 0 }, 0));
    }

    @Test
    void testLongestSubArrayLengthOfAddMinus() {
        assertEquals(0, L560_SubarraySumEqualsK_Google.longestSubArrayLengthOfAddMinus(new int[] { 0 }));
    }

}
