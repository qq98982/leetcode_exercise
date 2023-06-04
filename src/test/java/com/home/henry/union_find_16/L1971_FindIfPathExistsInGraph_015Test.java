package com.home.henry.union_find_16;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class L1971_FindIfPathExistsInGraph_015Test {

    private L1971_FindIfPathExistsInGraph_015 l1971FindIfPathExistsInGraph015UnderTest;

    @BeforeEach
    void setUp() {
        l1971FindIfPathExistsInGraph015UnderTest = new L1971_FindIfPathExistsInGraph_015();
    }

    @Test
    void testValidPath() {
        // Setup
        final int[][] edges = new int[][] { { 0, 1 }, { 1, 2 }, { 2, 0 } };

        // Run the test

        // Verify the results
        assertTrue(l1971FindIfPathExistsInGraph015UnderTest.validPath(3, edges, 0, 2));
        assertFalse(l1971FindIfPathExistsInGraph015UnderTest.validPath(6, new int[][] {
                { 0, 1 }, { 0, 2 }, { 3, 5 }, { 5, 4 }, { 4, 3 }
        }, 0, 5));
    }
}
