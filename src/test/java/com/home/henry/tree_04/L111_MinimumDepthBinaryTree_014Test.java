package com.home.henry.tree_04;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.home.henry.tool.TreeTools;

class L111_MinimumDepthBinaryTree_014Test {

    private L111_MinimumDepthBinaryTree_014 l111MinimumDepthBinaryTree014UnderTest;
    TreeNode root = new TreeNode(0);
    TreeNode treeNode1;
    TreeNode treeNode2;

    @BeforeEach
    void setUp() {
        l111MinimumDepthBinaryTree014UnderTest = new L111_MinimumDepthBinaryTree_014();
        root.left = new TreeNode(5);
        root.right = new TreeNode(-3);
        root.right.right = new TreeNode(11);
        root.left.left = new TreeNode(3);
        root.left.left.right = new TreeNode(-2);
        root.left.right = new TreeNode(2);
        root.left.right.right = new TreeNode(1);
        treeNode1 = TreeTools.strTreeNodes("3,9,20,null,null,15,7");
        treeNode2 = TreeTools.strTreeNodes("2,null,3,null,4,null,5,null,6");
    }

    @Test
    void testMinDepth() {
        final int result = l111MinimumDepthBinaryTree014UnderTest.minDepth(root);
        assertEquals(3, result);
        assertEquals(2, l111MinimumDepthBinaryTree014UnderTest.minDepth(treeNode1));
        assertEquals(5, l111MinimumDepthBinaryTree014UnderTest.minDepth(treeNode2));
    }

    @Test
    void testMinDepthClean() {
        final int result = l111MinimumDepthBinaryTree014UnderTest.minDepthClean(root);
        assertEquals(3, result);
        assertEquals(2, l111MinimumDepthBinaryTree014UnderTest.minDepthClean(treeNode1));
        assertEquals(5, l111MinimumDepthBinaryTree014UnderTest.minDepthClean(treeNode2));
    }
}
