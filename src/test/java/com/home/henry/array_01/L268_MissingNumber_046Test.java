package com.home.henry.array_01;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class L268_MissingNumber_046Test {

    private L268_MissingNumber_046 l268MissingNumber046UnderTest;

    @BeforeEach
    void setUp() throws Exception {
        l268MissingNumber046UnderTest = new L268_MissingNumber_046();
    }

    @Test
    void testMissingNumber() {
        assertEquals(2, l268MissingNumber046UnderTest.missingNumber(new int[] { 3,0,1 }));
        assertEquals(2, l268MissingNumber046UnderTest.missingNumber(new int[] { 0,1 }));
        assertEquals(8, l268MissingNumber046UnderTest.missingNumber(new int[] { 9,6,4,2,3,5,7,0,1 }));
    }
}
