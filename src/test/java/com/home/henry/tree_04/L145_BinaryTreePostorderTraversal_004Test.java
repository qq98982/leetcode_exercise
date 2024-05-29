package com.home.henry.tree_04;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.home.henry.tool.TreeTools;

class L145_BinaryTreePostorderTraversal_004Test {

    @Test
    void testPostorderTraversal() {
        assertEquals(Arrays.asList(3, 2, 1), L145_BinaryTreePostorderTraversal_004.postorderTraversal(TreeTools.strTreeNodes("1,null,2,3")));
        assertEquals(Arrays.asList(1,2,3), L145_BinaryTreePostorderTraversal_004.postorderTraversal(TreeTools.strTreeNodes("3,1,2")));
        assertEquals(Arrays.asList(7,8,6,4,2,5,3,1), L145_BinaryTreePostorderTraversal_004.postorderTraversal(TreeTools.strTreeNodes("1,2,3,4,null,null,5,null,6,null,null,7,8")));
        assertEquals(Arrays.asList(), L145_BinaryTreePostorderTraversal_004.postorderTraversal(TreeTools.strTreeNodes("")));
        assertEquals(Arrays.asList(1), L145_BinaryTreePostorderTraversal_004.postorderTraversal(TreeTools.strTreeNodes("1")));
    }

    @Test
    void testPostRecursive() {
        assertEquals(Arrays.asList(3,2,1), L145_BinaryTreePostorderTraversal_004.postRecursive(TreeTools.strTreeNodes("1,null,2,3")));
        assertEquals(Arrays.asList(1,2,3), L145_BinaryTreePostorderTraversal_004.postRecursive(TreeTools.strTreeNodes("3,1,2")));
        assertEquals(Arrays.asList(7,8,6,4,2,5,3,1), L145_BinaryTreePostorderTraversal_004.postRecursive(TreeTools.strTreeNodes("1,2,3,4,null,null,5,null,6,null,null,7,8")));
        assertEquals(Arrays.asList(1), L145_BinaryTreePostorderTraversal_004.postRecursive(TreeTools.strTreeNodes("1")));
        assertEquals(Arrays.asList(), L145_BinaryTreePostorderTraversal_004.postRecursive(TreeTools.strTreeNodes("")));
    }
}
