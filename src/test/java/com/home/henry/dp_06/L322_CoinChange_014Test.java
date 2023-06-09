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
        assertEquals(0, l322CoinChange014UnderTest.coinChange(new int[] { 0 }, 0));
        assertEquals(8, l322CoinChange014UnderTest.coinChange(new int[] { 474,83,404,3 }, 264));
    }
    @Test
    void testCoinChange2() {
        assertEquals(3, l322CoinChange014UnderTest.coinChange2(new int[] { 1,2,5 }, 11));
        assertEquals(-1, l322CoinChange014UnderTest.coinChange2(new int[] { 2 }, 3));
        assertEquals(0, l322CoinChange014UnderTest.coinChange2(new int[] { 0 }, 0));
        assertEquals(8, l322CoinChange014UnderTest.coinChange2(new int[] { 474,83,404,3 }, 264));
    }
}
