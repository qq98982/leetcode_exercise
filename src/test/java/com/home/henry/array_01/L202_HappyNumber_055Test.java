package com.home.henry.array_01;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class L202_HappyNumber_055Test {

    private L202_HappyNumber_055 l202HappyNumber055UnderTest;

    @BeforeEach
    void setUp() {
        l202HappyNumber055UnderTest = new L202_HappyNumber_055();
    }

    @Test
    void testIsHappy() {
        assertFalse(l202HappyNumber055UnderTest.isHappy(2));
        assertTrue(l202HappyNumber055UnderTest.isHappy(19));
    }
}
