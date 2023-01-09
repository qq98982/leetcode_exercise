package com.home.henry.tree_04;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.home.henry.tool.TreeTools;

class L257_BinaryTreePaths_018Test {

    private L257_BinaryTreePaths_018 l257BinaryTreePaths018UnderTest;

    @BeforeEach
    void setUp() {
        l257BinaryTreePaths018UnderTest = new L257_BinaryTreePaths_018();
    }

    @Test
    void testBinaryTreePaths() {
        assertEquals(List.of("1->2->5", "1->3"),
                     l257BinaryTreePaths018UnderTest.binaryTreePaths(TreeTools.strTreeNodes("1,2,3,null,5")));
        assertEquals(List.of("1"),
                     l257BinaryTreePaths018UnderTest.binaryTreePaths(TreeTools.strTreeNodes("1")));
    }
}
