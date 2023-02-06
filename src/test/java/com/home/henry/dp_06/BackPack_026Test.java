package com.home.henry.dp_06;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BackPack_026Test {

    private BackPack_026 backPack026UnderTest;

    @BeforeEach
    void setUp() throws Exception {
        backPack026UnderTest = new BackPack_026();
    }

    @Test
    void testBackPackV() {
        assertEquals(2, backPack026UnderTest.backPack26(new int[] { 1, 2, 3, 3, 7 }, 7));
        assertEquals(5, backPack026UnderTest.backPack26(new int[] { 1, 1, 1, 1, 1 }, 1));
    }
}
