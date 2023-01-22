package com.home.henry.binary_search_08;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.home.henry.tool.GenRandomArray;

class L704_BinarySearch_003Test {

    private L704_BinarySearch_003 l704BinarySearch003UnderTest;

    @BeforeEach
    void setUp() {
        l704BinarySearch003UnderTest = new L704_BinarySearch_003();
    }

    @Test
    void testBinary_search() {
        assertEquals(4, l704BinarySearch003UnderTest.binary_search(new int[] { -1,0,3,5,9,12 }, 9));
        assertEquals(-1, l704BinarySearch003UnderTest.binary_search(new int[] { -1,0,3,5,9,12 }, 2));
    }

    @Test
    void testLeft_bound() {
        assertEquals(4, l704BinarySearch003UnderTest.left_bound(new int[] { -1,0,3,5,9,12 }, 9));
        assertEquals(-1, l704BinarySearch003UnderTest.left_bound(new int[] { -1,0,3,5,9,12 }, 2));
    }

    @Test
    void testRight_bound() {
        assertEquals(4, l704BinarySearch003UnderTest.right_bound(new int[] { -1,0,3,5,9,12 }, 9));
        assertEquals(-1, l704BinarySearch003UnderTest.right_bound(new int[] { -1,0,3,5,9,12 }, 2));
    }

    @Test
    void testSearch() {
        assertEquals(4, l704BinarySearch003UnderTest.search(new int[] { -1,0,3,5,9,12 }, 9));
        assertEquals(-1, l704BinarySearch003UnderTest.search(new int[] { -1,0,3,5,9,12 }, 2));
    }

    @Test
    void testSearch2() {
        assertEquals(4, l704BinarySearch003UnderTest.search2(new int[] { -1,0,3,5,9,12 }, 9));
        assertEquals(-1, l704BinarySearch003UnderTest.search2(new int[] { -1,0,3,5,9,12 }, 2));
    }

    @Test
    void testSearch3() {
        assertEquals(4, l704BinarySearch003UnderTest.search3(new int[] { -1,0,3,5,9,12 }, 9));
        assertEquals(-1, l704BinarySearch003UnderTest.search3(new int[] { -1,0,3,5,9,12 }, 2));
    }
}
