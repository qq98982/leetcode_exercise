package com.home.henry.array_01;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class L238_ProductOfArrayExceptSelf_082Test {

    private L238_ProductOfArrayExceptSelf_082 l238ProductOfArrayExceptSelf082UnderTest;

    @BeforeEach
    void setUp() throws Exception {
        l238ProductOfArrayExceptSelf082UnderTest = new L238_ProductOfArrayExceptSelf_082();
    }

    @Test
    void testProductExceptSelf() {
        assertArrayEquals(new int[] { 24, 12, 8, 6 },
                          l238ProductOfArrayExceptSelf082UnderTest.productExceptSelf(new int[] { 1, 2, 3, 4 }));
        assertArrayEquals(new int[] { 0, 0, 9, 0, 0 },
                          l238ProductOfArrayExceptSelf082UnderTest.productExceptSelf(
                                  new int[] { -1, 1, 0, -3, 3 }));
    }
}
