package com.home.henry.array_01;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class L027_RemoveElement_001Test {

    private L027_RemoveElement_001 l027RemoveElement001UnderTest;

    @BeforeEach
    void setUp() {
        l027RemoveElement001UnderTest = new L027_RemoveElement_001();
    }

    @Test
    void testRemoveElement1() {
        int[] numsOne = { 1, 2, 3, 5, 3, 4 };
        int resOne = 4;
        assertEquals(resOne, l027RemoveElement001UnderTest.removeElement(numsOne, 3));
        int[] numsOneNew = new int[resOne];
        System.arraycopy(numsOne,0,numsOneNew,0,resOne);
        for (int i = 0; i < numsOneNew.length; i++) {
            Assertions.assertTrue(numsOneNew[i] != 3);
        }
    }

    @Test
    void testRemoveElement2() {
        int[] numsOne = { 3,2,2,3 };
        int resOne = 2;
        assertEquals(resOne, l027RemoveElement001UnderTest.removeElement(numsOne, 3));
        int[] numsOneNew = new int[resOne];
        System.arraycopy(numsOne,0,numsOneNew,0,resOne);
        for (int i = 0; i < numsOneNew.length; i++) {
            Assertions.assertTrue(numsOneNew[i] != 3);
        }
    }

    @Test
    void testRemoveElement3() {
        int[] numsOne = { 0,1,2,2,3,0,4,2 };
        int resOne = 5;
        assertEquals(resOne, l027RemoveElement001UnderTest.removeElement(numsOne, 2));
        int[] numsOneNew = new int[resOne];
        System.arraycopy(numsOne,0,numsOneNew,0,resOne);
        for (int i = 0; i < numsOneNew.length; i++) {
            Assertions.assertTrue(numsOneNew[i] != 2);
        }
    }

}
