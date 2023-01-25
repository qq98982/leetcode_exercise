package com.home.henry.dp_06;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BackPack_029Test {

    private BackPack_029 backPack029UnderTest;

    @BeforeEach
    void setUp() throws Exception {
        backPack029UnderTest = new BackPack_029();
    }

    @Test
    void testBackPack29() {
        assertEquals(15, backPack029UnderTest.backPack29(10, new int[] { 2,3,5,7 }, new int[] { 1,5,2,4 }));
    }
}
