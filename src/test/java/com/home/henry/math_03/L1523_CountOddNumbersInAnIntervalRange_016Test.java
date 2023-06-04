package com.home.henry.math_03;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class L1523_CountOddNumbersInAnIntervalRange_016Test {

    private L1523_CountOddNumbersInAnIntervalRange_016 l1523CountOddNumbersInAnIntervalRange016UnderTest;

    @BeforeEach
    void setUp() {
        l1523CountOddNumbersInAnIntervalRange016UnderTest = new L1523_CountOddNumbersInAnIntervalRange_016();
    }

    @Test
    void testCountOdds() {
        assertEquals(3, l1523CountOddNumbersInAnIntervalRange016UnderTest.countOdds(3, 7));
        assertEquals(1, l1523CountOddNumbersInAnIntervalRange016UnderTest.countOdds(8, 10));
    }
}
