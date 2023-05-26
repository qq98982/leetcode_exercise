package com.home.henry.math_03;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class L067_AddBinary_006Test {

    private L067_AddBinary_006 l067AddBinary006UnderTest;

    @BeforeEach
    void setUp() {
        l067AddBinary006UnderTest = new L067_AddBinary_006();
    }

    @Test
    void testAddBinary() {
        assertEquals("100", l067AddBinary006UnderTest.addBinary("11", "1"));
        assertEquals("10101", l067AddBinary006UnderTest.addBinary("1010", "1011"));
    }
}
