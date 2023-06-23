package com.home.henry.array_01;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class L011_ContainerWithMostWater_028Test {

    private L011_ContainerWithMostWater_028 l011ContainerWithMostWater028UnderTest;

    @BeforeEach
    void setUp() throws Exception {
        l011ContainerWithMostWater028UnderTest = new L011_ContainerWithMostWater_028();
    }

    @Test
    void testMaxArea() {
        assertEquals(1, l011ContainerWithMostWater028UnderTest.maxArea(new int[]{1,1}));
        assertEquals(49, l011ContainerWithMostWater028UnderTest.maxArea(new int[]{1,8,6,2,5,4,8,3,7}));
    }
}
