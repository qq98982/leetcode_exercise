package com.home.henry.array_01;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class L026_RemoveDuplicatesFromSortedArray_002Test {

    private L026_RemoveDuplicatesFromSortedArray_002 l26RemoveDuplicatesFromSortedArray002UnderTest;

    @BeforeEach
    void setUp() {
        l26RemoveDuplicatesFromSortedArray002UnderTest = new L026_RemoveDuplicatesFromSortedArray_002();
    }

    @Test
    void testRemoveDuplicates() {
        int[] numsOne = { 0, 0, 1, 1, 1, 2, 2, 3, 3, 4 };
        int resOne = 5;
        assertEquals(resOne, l26RemoveDuplicatesFromSortedArray002UnderTest.removeDuplicates(numsOne));
        int[] numsOneNew = new int[resOne];
        System.arraycopy(numsOne, 0, numsOneNew, 0, resOne);
        Assertions.assertTrue(isSorted(numsOneNew));

        int[] numsTwo = { 1, 1, 2 };
        int resTwo = 2;
        assertEquals(resTwo, l26RemoveDuplicatesFromSortedArray002UnderTest.removeDuplicates(numsTwo));
        int[] numsTwoNew = new int[resTwo];
        System.arraycopy(numsTwo, 0, numsTwoNew, 0, resTwo);
        Assertions.assertTrue(isSorted(numsTwoNew));
    }

    @Test
    void testRemoveDuplicates2() {
        int[] numsOne = { 1,2,3 };
        int resOne = 3;
        assertEquals(resOne, l26RemoveDuplicatesFromSortedArray002UnderTest.removeDuplicates(numsOne));
        int[] numsOneNew = new int[resOne];
        System.arraycopy(numsOne, 0, numsOneNew, 0, resOne);
        Assertions.assertTrue(isSorted(numsOneNew));
    }

    static boolean isSorted(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] > array[i + 1]) {return false;}
        }
        return true;
    }
}
