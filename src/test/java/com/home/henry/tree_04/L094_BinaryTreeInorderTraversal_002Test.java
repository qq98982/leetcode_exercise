package com.home.henry.tree_04;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.home.henry.tool.TreeTools;

class L094_BinaryTreeInorderTraversal_002Test {

    @Test
    void solutionRecurTest() {
        Assertions.assertEquals(List.of(4, 2, 5, 1, 3),
                                L094_BinaryTreeInorderTraversal_002.SolutionRecur.inorderTraversal(
                                        TreeTools.strTreeNodes("1 2 3 4 5")));
        Assertions.assertEquals(List.of(1, 3, 2),
                                L094_BinaryTreeInorderTraversal_002.SolutionRecur.inorderTraversal(
                                        TreeTools.strTreeNodes("1,null,2,3")));
        Assertions.assertEquals(List.of(), L094_BinaryTreeInorderTraversal_002.SolutionRecur.inorderTraversal(
                TreeTools.strTreeNodes("")));
        Assertions.assertEquals(List.of(1), L094_BinaryTreeInorderTraversal_002.SolutionRecur.inorderTraversal(
                TreeTools.strTreeNodes("1")));
    }

    @Test
    void inorderTraversalTest() {
        Assertions.assertEquals(List.of(4, 2, 5, 1, 3),
                                L094_BinaryTreeInorderTraversal_002.Solution.inorderTraversal(
                                        TreeTools.strTreeNodes("1 2 3 4 5")));
        Assertions.assertEquals(List.of(1, 3, 2), L094_BinaryTreeInorderTraversal_002.Solution.inorderTraversal(
                TreeTools.strTreeNodes("1,null,2,3")));
        Assertions.assertEquals(List.of(), L094_BinaryTreeInorderTraversal_002.Solution.inorderTraversal(
                TreeTools.strTreeNodes("")));
        Assertions.assertEquals(List.of(1), L094_BinaryTreeInorderTraversal_002.Solution.inorderTraversal(
                TreeTools.strTreeNodes("1")));
    }
}
