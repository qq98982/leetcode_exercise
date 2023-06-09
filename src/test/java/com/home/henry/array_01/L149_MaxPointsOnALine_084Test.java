package com.home.henry.array_01;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class L149_MaxPointsOnALine_084Test {

    private L149_MaxPointsOnALine_084 l149MaxPointsOnALine084UnderTest;

    @BeforeEach
    void setUp() throws Exception {
        l149MaxPointsOnALine084UnderTest = new L149_MaxPointsOnALine_084();
    }

    @Test
    void testMaxPoints() {
        // Verify the results
        assertEquals(3, l149MaxPointsOnALine084UnderTest.maxPoints(new int[][] { { 1,1 },{2,2},{3,3} }));
        assertEquals(4, l149MaxPointsOnALine084UnderTest.maxPoints(new int[][] {{1,1},{3,2},{5,3},{4,1},{2,3},{1,4}}));
        assertEquals(1, l149MaxPointsOnALine084UnderTest.maxPoints(new int[][] { { 0 } }));
    }
}
