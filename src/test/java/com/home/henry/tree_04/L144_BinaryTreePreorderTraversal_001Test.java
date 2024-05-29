package com.home.henry.tree_04;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.home.henry.tool.TreeTools;

class L144_BinaryTreePreorderTraversal_001Test {
    private L144_BinaryTreePreorderTraversal_001 treePreorderTraversal;

    @BeforeEach
    void setUp() {
        treePreorderTraversal = new L144_BinaryTreePreorderTraversal_001();
    }

    @Test
    void testPreorderTraversalIterativeSimple() {
        final TreeNode root = TreeTools.strTreeNodes("1,null,2,3");

        final List<Integer> result =
                treePreorderTraversal.preorderTraversalIterativeSimple(root);

        assertEquals(Arrays.asList(1, 2, 3), result);
        assertTrue(
                treePreorderTraversal.preorderTraversalIterativeSimple(
                        TreeTools.strTreeNodes("")).isEmpty());
        assertEquals(Arrays.asList(1),
                     treePreorderTraversal.preorderTraversalIterativeSimple(
                             TreeTools.strTreeNodes("1")));
        assertEquals(Arrays.asList(1, 2, 4, 5, 3),
                     treePreorderTraversal.preorderTraversalIterativeSimple(
                             TreeTools.strTreeNodes("1 2 3 4 5")));
    }

    @Test
    void testPreorderTraversal() {
        final TreeNode root = TreeTools.strTreeNodes("1,null,2,3");

        final List<Integer> result =
                treePreorderTraversal.preorderTraversal(root);

        assertEquals(Arrays.asList(1, 2, 3), result);
        assertTrue(
                treePreorderTraversal.preorderTraversal(
                        TreeTools.strTreeNodes("")).isEmpty());
        assertEquals(Arrays.asList(1),
                     treePreorderTraversal.preorderTraversal(
                             TreeTools.strTreeNodes("1")));
        assertEquals(Arrays.asList(1, 2, 4, 5, 3),
                     treePreorderTraversal.preorderTraversal(
                             TreeTools.strTreeNodes("1 2 3 4 5")));
    }
}
