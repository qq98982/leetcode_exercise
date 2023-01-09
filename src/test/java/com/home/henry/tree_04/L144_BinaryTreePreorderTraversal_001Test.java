package com.home.henry.tree_04;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;

import com.home.henry.tool.TreeTools;

class L144_BinaryTreePreorderTraversal_001Test {

    @Test
    void testPreorderTraversalIterativeSimple() {
        final TreeNode root = TreeTools.strTreeNodes("1,null,2,3");

        final List<Integer> result =
                L144_BinaryTreePreorderTraversal_001.preorderTraversalIterativeSimple(root);

        assertEquals(List.of(1, 2, 3), result);
        assertTrue(
                L144_BinaryTreePreorderTraversal_001.preorderTraversalIterativeSimple(
                        TreeTools.strTreeNodes("")).isEmpty());
        assertEquals(List.of(1),
                     L144_BinaryTreePreorderTraversal_001.preorderTraversalIterativeSimple(
                             TreeTools.strTreeNodes("1")));
        assertEquals(List.of(1,2,4,5,3),
                     L144_BinaryTreePreorderTraversal_001.preorderTraversalIterativeSimple(
                             TreeTools.strTreeNodes("1 2 3 4 5")));
    }

    @Test
    void testPreorderTraversal() {
        final TreeNode root = TreeTools.strTreeNodes("1,null,2,3");

        final List<Integer> result =
                L144_BinaryTreePreorderTraversal_001.preorderTraversal(root);

        assertEquals(List.of(1, 2, 3), result);
        assertTrue(
                L144_BinaryTreePreorderTraversal_001.preorderTraversal(
                        TreeTools.strTreeNodes("")).isEmpty());
        assertEquals(List.of(1),
                     L144_BinaryTreePreorderTraversal_001.preorderTraversal(
                             TreeTools.strTreeNodes("1")));
        assertEquals(List.of(1,2,4,5,3),
                     L144_BinaryTreePreorderTraversal_001.preorderTraversal(
                             TreeTools.strTreeNodes("1 2 3 4 5")));
    }
}
