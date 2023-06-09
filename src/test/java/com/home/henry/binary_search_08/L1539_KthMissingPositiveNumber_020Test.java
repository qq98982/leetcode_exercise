package com.home.henry.binary_search_08;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class L1539_KthMissingPositiveNumber_020Test {

    private L1539_KthMissingPositiveNumber_020 l1539KthMissingPositiveNumber020UnderTest;

    @BeforeEach
    void setUp() {
        l1539KthMissingPositiveNumber020UnderTest = new L1539_KthMissingPositiveNumber_020();
    }

    @Test
    void testFindKthPositive() {
        assertEquals(6, l1539KthMissingPositiveNumber020UnderTest.findKthPositive(new int[] { 1, 2, 3, 4 }, 2));
        assertEquals(9, l1539KthMissingPositiveNumber020UnderTest.findKthPositive(new int[] { 2, 3, 4, 7, 11 }, 5));
    }
}
