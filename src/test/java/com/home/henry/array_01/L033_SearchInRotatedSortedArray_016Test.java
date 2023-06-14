package com.home.henry.array_01;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class L033_SearchInRotatedSortedArray_016Test {

    private L033_SearchInRotatedSortedArray_016 l033SearchInRotatedSortedArray016UnderTest;

    @BeforeEach
    void setUp() throws Exception {
        l033SearchInRotatedSortedArray016UnderTest = new L033_SearchInRotatedSortedArray_016();
    }

    @Test
    void testSearch() {
        assertEquals(1, l033SearchInRotatedSortedArray016UnderTest.search(new int[] { 3,1 }, 1));
        assertEquals(4, l033SearchInRotatedSortedArray016UnderTest.search(new int[] { 4,5,6,7,0,1,2 }, 0));
        assertEquals(-1, l033SearchInRotatedSortedArray016UnderTest.search(new int[] { 4,5,6,7,0,1,2 }, 3));
        assertEquals(-1, l033SearchInRotatedSortedArray016UnderTest.search(new int[] { 1 }, 0));
        assertEquals(2, l033SearchInRotatedSortedArray016UnderTest.search(new int[] { 5,1,3 }, 3));
        assertEquals(-1, l033SearchInRotatedSortedArray016UnderTest.search(new int[] { 1,3 }, 2));
    }

}
