package com.home.henry.tree_04;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;

import com.home.henry.tool.TreeTools;

class L145_BinaryTreePostorderTraversal_004Test {

    @Test
    void testPostorderTraversal() {
        assertEquals(List.of(3,2,1), L145_BinaryTreePostorderTraversal_004.postorderTraversal(TreeTools.strTreeNodes("1,null,2,3")));
        assertEquals(List.of(7,8,6,4,2,5,3,1), L145_BinaryTreePostorderTraversal_004.postorderTraversal(TreeTools.strTreeNodes("1,2,3,4,null,null,5,null,6,null,null,7,8")));
        assertEquals(List.of(), L145_BinaryTreePostorderTraversal_004.postorderTraversal(TreeTools.strTreeNodes("")));
        assertEquals(List.of(1), L145_BinaryTreePostorderTraversal_004.postorderTraversal(TreeTools.strTreeNodes("1")));
    }

    @Test
    void testPostRecursive() {
        assertEquals(List.of(3,2,1), L145_BinaryTreePostorderTraversal_004.postRecursive(TreeTools.strTreeNodes("1,null,2,3")));
        assertEquals(List.of(7,8,6,4,2,5,3,1), L145_BinaryTreePostorderTraversal_004.postRecursive(TreeTools.strTreeNodes("1,2,3,4,null,null,5,null,6,null,null,7,8")));

        assertEquals(List.of(1), L145_BinaryTreePostorderTraversal_004.postRecursive(TreeTools.strTreeNodes("1")));
        assertEquals(List.of(), L145_BinaryTreePostorderTraversal_004.postRecursive(TreeTools.strTreeNodes("")));
    }
}
