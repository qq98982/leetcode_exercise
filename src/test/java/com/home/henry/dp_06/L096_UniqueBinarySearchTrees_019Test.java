package com.home.henry.dp_06;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class L096_UniqueBinarySearchTrees_019Test {

    @Test
    void testNumTrees() {
        Assertions.assertEquals(1, L096_UniqueBinarySearchTrees_019.Solution.numTrees(1));
        Assertions.assertEquals(2, L096_UniqueBinarySearchTrees_019.Solution.numTrees(2));
        Assertions.assertEquals(5, L096_UniqueBinarySearchTrees_019.Solution.numTrees(3));
        Assertions.assertEquals(14, L096_UniqueBinarySearchTrees_019.Solution.numTrees(4));
        Assertions.assertEquals(42, L096_UniqueBinarySearchTrees_019.Solution.numTrees(5));
    }
}
