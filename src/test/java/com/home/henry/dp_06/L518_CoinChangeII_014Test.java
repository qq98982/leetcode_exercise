package com.home.henry.dp_06;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class L518_CoinChangeII_014Test {

    private L518_CoinChangeII_014 l518CoinChangeII014UnderTest;

    @BeforeEach
    void setUp() throws Exception {
        l518CoinChangeII014UnderTest = new L518_CoinChangeII_014();
    }

    @Test
    void testChange() {
        assertEquals(4, l518CoinChangeII014UnderTest.change(5, new int[] { 1,2,5}));
        assertEquals(0, l518CoinChangeII014UnderTest.change(3, new int[] { 2}));
        assertEquals(1, l518CoinChangeII014UnderTest.change(10, new int[] { 10}));
    }
}
