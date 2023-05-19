package com.home.henry.tree_04;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;

import com.home.henry.tool.TreeTools;

class L637_AverageOfLevelsInBinaryTree_036Test {

    @Test
    void testAverageOfLevels() {
        assertEquals(List.of(3.0, 14.5, 11.0), L637_AverageOfLevelsInBinaryTree_036.averageOfLevels(TreeTools.strTreeNodes("3,9,20,null,null,15,7")));
        assertEquals(List.of(3.0, 14.5, 11.0), L637_AverageOfLevelsInBinaryTree_036.averageOfLevels(TreeTools.strTreeNodes("3,9,20,15,7")));
        assertEquals(List.of(2147483647.00000, 2147483647.00000), L637_AverageOfLevelsInBinaryTree_036.averageOfLevels(TreeTools.strTreeNodes("2147483647,2147483647,2147483647")));
    }
}
