package com.home.henry.tree_04;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.home.henry.tool.TreeTools;

class L102_BinaryTreeLevelOrderTraversal_006Test {

    private L102_BinaryTreeLevelOrderTraversal_006 l102BinaryTreeLevelOrderTraversal006UnderTest;

    @BeforeEach
    void setUp() {
        l102BinaryTreeLevelOrderTraversal006UnderTest = new L102_BinaryTreeLevelOrderTraversal_006();
    }

    @Test
    void testLevelOrderBFS() {
        final TreeNode root = TreeTools.strTreeNodes("3,9,20,null,null,15,7");
        final List<List<Integer>> result = l102BinaryTreeLevelOrderTraversal006UnderTest.levelOrderBFS(root);
        assertEquals(List.of(List.of(3), List.of(9, 20), List.of(15, 7)), result);
        assertEquals(List.of(),
                     l102BinaryTreeLevelOrderTraversal006UnderTest.levelOrderBFS(TreeTools.strTreeNodes("")));
        assertEquals(List.of(List.of(1)),
                     l102BinaryTreeLevelOrderTraversal006UnderTest.levelOrderBFS(TreeTools.strTreeNodes("1")));
    }

    @Test
    void testLevelOrderDFS() {
        final TreeNode root = TreeTools.strTreeNodes("3,9,20,null,null,15,7");
        final List<List<Integer>> result = l102BinaryTreeLevelOrderTraversal006UnderTest.levelOrderDFS(root);
        assertEquals(List.of(List.of(3), List.of(9, 20), List.of(15, 7)), result);
        assertEquals(List.of(),
                     l102BinaryTreeLevelOrderTraversal006UnderTest.levelOrderDFS(TreeTools.strTreeNodes("")));
        assertEquals(List.of(List.of(1)),
                     l102BinaryTreeLevelOrderTraversal006UnderTest.levelOrderDFS(TreeTools.strTreeNodes("1")));
    }
}
