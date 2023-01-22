package com.home.henry.math_03;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class L015_ThreeSum_017Test {

    private L015_ThreeSum_017 l015ThreeSum017UnderTest;

    @BeforeEach
    void setUp() {
        l015ThreeSum017UnderTest = new L015_ThreeSum_017();
    }

    @Test
    void testThreeSum() {
        assertEquals(List.of(List.of(-1,-1,2),List.of(-1,0,1)), l015ThreeSum017UnderTest.threeSum(new int[] { -1,0,1,2,-1,-4 }));
        assertEquals(List.of(List.of(0,0,0)), l015ThreeSum017UnderTest.threeSum(new int[] { 0,0,0 }));
        assertEquals(Collections.emptyList(), l015ThreeSum017UnderTest.threeSum(new int[] { 0,1,1 }));
    }
    @Test
    void testThreeSumSet() {
        assertEquals(List.of(List.of(-1,-1,2),List.of(-1,0,1)), l015ThreeSum017UnderTest.threeSumSet(new int[] { -1,0,1,2,-1,-4 }));
        assertEquals(List.of(List.of(0,0,0)), l015ThreeSum017UnderTest.threeSumSet(new int[] { 0,0,0 }));
        assertEquals(Collections.emptyList(), l015ThreeSum017UnderTest.threeSumSet(new int[] { 0,1,1 }));
    }

}
