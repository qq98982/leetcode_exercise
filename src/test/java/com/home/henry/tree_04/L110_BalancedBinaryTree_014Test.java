package com.home.henry.tree_04;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.home.henry.tool.TreeTools;

class L110_BalancedBinaryTree_014Test {

    private L110_BalancedBinaryTree_014 l110BalancedBinaryTree014UnderTest;

    @BeforeEach
    void setUp() {
        l110BalancedBinaryTree014UnderTest = new L110_BalancedBinaryTree_014();
    }

    @Test
    void testIsBalanced() {
        final TreeNode root = new TreeNode(0);
        final boolean result = l110BalancedBinaryTree014UnderTest.isBalanced(root);
        assertTrue(result);
        root.left = new TreeNode(5);
        root.right = new TreeNode(-3);
        root.right.right = new TreeNode(11);
        root.left.left = new TreeNode(3);
        root.left.left.right = new TreeNode(-2);
        root.left.right = new TreeNode(2);
        root.left.right.right = new TreeNode(1);
        root.left.right.right.right = new TreeNode(1);
        root.left.right.right.right.right = new TreeNode(1);
        final boolean result2 = l110BalancedBinaryTree014UnderTest.isBalanced(root);
        assertFalse(result2);
        final TreeNode treeNode = TreeTools.strTreeNodes("3 9 20 null null 15 7");
        assertTrue(l110BalancedBinaryTree014UnderTest.isBalanced(treeNode));
        final TreeNode treeNode2 = TreeTools.strTreeNodes("1 2 2 3 3 null null 4 4");
        assertFalse(l110BalancedBinaryTree014UnderTest.isBalanced(treeNode2));
    }
}
