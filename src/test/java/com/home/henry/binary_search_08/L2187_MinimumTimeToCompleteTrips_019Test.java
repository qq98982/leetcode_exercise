package com.home.henry.binary_search_08;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class L2187_MinimumTimeToCompleteTrips_019Test {

    private L2187_MinimumTimeToCompleteTrips_019 l2187MinimumTimeToCompleteTrips019UnderTest;

    @BeforeEach
    void setUp() {
        l2187MinimumTimeToCompleteTrips019UnderTest = new L2187_MinimumTimeToCompleteTrips_019();
    }

    @Test
    void testMinimumTime() {
        assertEquals(3L, l2187MinimumTimeToCompleteTrips019UnderTest.minimumTime(new int[] { 1, 2, 3 }, 5));
        assertEquals(2L, l2187MinimumTimeToCompleteTrips019UnderTest.minimumTime(new int[] { 2 }, 1));
        assertEquals(25L, l2187MinimumTimeToCompleteTrips019UnderTest.minimumTime(new int[] { 5, 10, 10 }, 9));
    }
}
