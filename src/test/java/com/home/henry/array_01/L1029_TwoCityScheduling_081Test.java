package com.home.henry.array_01;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class L1029_TwoCityScheduling_081Test {

    private L1029_TwoCityScheduling_081 l1029TwoCityScheduling081UnderTest;

    @BeforeEach
    void setUp() throws Exception {
        l1029TwoCityScheduling081UnderTest = new L1029_TwoCityScheduling_081();
    }

    @Test
    void testTwoCitySchedCost() {
        assertEquals(110, l1029TwoCityScheduling081UnderTest.twoCitySchedCost(
                new int[][] { { 10, 20 }, { 30, 200 }, { 400, 50 }, { 30, 20 } }));
        assertEquals(1859, l1029TwoCityScheduling081UnderTest.twoCitySchedCost(new int[][] {
                { 259, 770 }, { 448, 54 }, { 926, 667 }, { 184, 139 }, { 840, 118 }, { 577, 469 }
        }));
        assertEquals(3086, l1029TwoCityScheduling081UnderTest.twoCitySchedCost(new int[][] {
                { 515, 563 }, { 451, 713 }, { 537, 709 }, { 343, 819 }, { 855, 779 }, { 457, 60 }, { 650, 359 },
                { 631, 42 }
        }));
    }
}
