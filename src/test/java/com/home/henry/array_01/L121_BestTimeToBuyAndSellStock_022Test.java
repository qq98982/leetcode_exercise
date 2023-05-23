package com.home.henry.array_01;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class L121_BestTimeToBuyAndSellStock_022Test {

    private L121_BestTimeToBuyAndSellStock_022 l121BestTimeToBuyAndSellStock022UnderTest;

    @BeforeEach
    void setUp() throws Exception {
        l121BestTimeToBuyAndSellStock022UnderTest = new L121_BestTimeToBuyAndSellStock_022();
    }

    @Test
    void testMaxProfit() {
        assertEquals(5, l121BestTimeToBuyAndSellStock022UnderTest.maxProfit(new int[] { 7,1,5,3,6,4 }));
        assertEquals(0, l121BestTimeToBuyAndSellStock022UnderTest.maxProfit(new int[] { 7,6,4,3,1 }));
        assertEquals(0, l121BestTimeToBuyAndSellStock022UnderTest.maxProfit(new int[] { 0 }));
    }

    @Test
    void testMaxProfit2() {
        assertEquals(5, l121BestTimeToBuyAndSellStock022UnderTest.maxProfit2(new int[] { 7,1,5,3,6,4 }));
        assertEquals(0, l121BestTimeToBuyAndSellStock022UnderTest.maxProfit2(new int[] { 7,6,4,3,1 }));
        assertEquals(0, l121BestTimeToBuyAndSellStock022UnderTest.maxProfit2(new int[] { 0 }));
    }
}
