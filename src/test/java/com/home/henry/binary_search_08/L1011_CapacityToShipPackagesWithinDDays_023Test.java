package com.home.henry.binary_search_08;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class L1011_CapacityToShipPackagesWithinDDays_023Test {

    private L1011_CapacityToShipPackagesWithinDDays_023 l1011CapacityToShipPackagesWithinDDays023UnderTest;

    @BeforeEach
    void setUp() {
        l1011CapacityToShipPackagesWithinDDays023UnderTest = new L1011_CapacityToShipPackagesWithinDDays_023();
    }

    @Test
    void testShipWithinDays() {
        assertEquals(15, l1011CapacityToShipPackagesWithinDDays023UnderTest.shipWithinDays(new int[] { 1,2,3,4,5,6,7,8,9,10 }, 5));
        assertEquals(6, l1011CapacityToShipPackagesWithinDDays023UnderTest.shipWithinDays(new int[] { 3,2,2,4,1,4 }, 3));
        assertEquals(3, l1011CapacityToShipPackagesWithinDDays023UnderTest.shipWithinDays(new int[] { 1,2,3,1,1 }, 4));
    }
}
