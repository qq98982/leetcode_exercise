package com.home.henry.tree_04;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.home.henry.tool.TreeTools;

class L104_MaximumDepthBinaryTree_013Test {

    private L104_MaximumDepthBinaryTree_013 l104MaximumDepthBinaryTree013UnderTest;

    @BeforeEach
    void setUp() {
        l104MaximumDepthBinaryTree013UnderTest = new L104_MaximumDepthBinaryTree_013();
    }

    @Test
    void testMaxDepth() {
        assertEquals(3, l104MaximumDepthBinaryTree013UnderTest.maxDepth(
                TreeTools.strTreeNodes("3,9,20,null,null,15,7")));
        assertEquals(2, l104MaximumDepthBinaryTree013UnderTest.maxDepth(TreeTools.strTreeNodes("1,null,2")));
    }
}
