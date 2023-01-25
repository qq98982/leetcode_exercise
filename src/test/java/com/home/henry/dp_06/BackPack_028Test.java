package com.home.henry.dp_06;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BackPack_028Test {

    private BackPack_028 backPack028UnderTest;

    @BeforeEach
    void setUp() throws Exception {
        backPack028UnderTest = new BackPack_028();
    }

    @Test
    void testBackPack28() {
        assertEquals(9,
                     backPack028UnderTest.backPack28(10, new int[] { 2, 3, 5, 7 }, new int[] { 1, 5, 2, 4 }));
    }
}
