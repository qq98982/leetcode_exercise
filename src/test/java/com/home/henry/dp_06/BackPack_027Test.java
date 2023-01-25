package com.home.henry.dp_06;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BackPack_027Test {

    private BackPack_027 backPack027UnderTest;

    @BeforeEach
    void setUp() throws Exception {
        backPack027UnderTest = new BackPack_027();
    }

    @Test
    void testBackPackV() {
        assertEquals(6, backPack027UnderTest.backPack27(new int[] { 1, 2, 4}, 4));
        assertEquals(22, backPack027UnderTest.backPack27(new int[] { 5, 7, 13, 17}, 32));
    }
}
