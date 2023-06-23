package com.home.henry.array_01;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class L713_SubarrayProductLessThanK_087Test {

    private L713_SubarrayProductLessThanK_087 l713SubarrayProductLessThanK087UnderTest;

    @BeforeEach
    void setUp() throws Exception {
        l713SubarrayProductLessThanK087UnderTest = new L713_SubarrayProductLessThanK_087();
    }

    @Test
    void testNumSubarrayProductLessThanK() {
        assertEquals(8, l713SubarrayProductLessThanK087UnderTest.numSubarrayProductLessThanK(new int[]{10, 5, 2, 6}, 100));
        assertEquals(0, l713SubarrayProductLessThanK087UnderTest.numSubarrayProductLessThanK(new int[]{1, 2, 3}, 0));
    }
}
