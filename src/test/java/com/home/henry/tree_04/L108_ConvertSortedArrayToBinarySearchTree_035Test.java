package com.home.henry.tree_04;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.home.henry.tool.TreeTools;

class L108_ConvertSortedArrayToBinarySearchTree_035Test {

    private L108_ConvertSortedArrayToBinarySearchTree_035 l108ConvertSortedArrayToBinarySearchTree035UnderTest;

    @BeforeEach
    void setUp() throws Exception {
        l108ConvertSortedArrayToBinarySearchTree035UnderTest =
                new L108_ConvertSortedArrayToBinarySearchTree_035();
    }

    @Test
    void testSortedArrayToBST() {
        final TreeNode result = l108ConvertSortedArrayToBinarySearchTree035UnderTest.sortedArrayToBST(
                new int[] { -10,-3,0,5,9 });
        System.out.println(TreeTools.treeStr(result).equals("0 -10 5 null -3 null 9"));
        System.out.println(TreeTools.treeStr(result).equals("0,-3,9,-10,null,5"));
        // [1,3] -> [1,null,3], [3,1]
    }
}
