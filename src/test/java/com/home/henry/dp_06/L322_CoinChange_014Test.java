package com.home.henry.dp_06;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class L322_CoinChange_014Test {

    private L322_CoinChange_014 l322CoinChange014UnderTest;

    @BeforeEach
    void setUp() {
        l322CoinChange014UnderTest = new L322_CoinChange_014();
    }

    @Test
    void testCoinChange() {
        assertEquals(3, l322CoinChange014UnderTest.coinChange(new int[] { 1,2,5 }, 11));
        assertEquals(-1, l322CoinChange014UnderTest.coinChange(new int[] { 2 }, 3));
    }
}
