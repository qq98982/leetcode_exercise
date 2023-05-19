package com.home.henry.tree_04;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.home.henry.tool.TreeTools;

class L872_Leaf_SimilarTrees_009Test {

    private L872_Leaf_SimilarTrees_009 l872LeafSimilarTrees009UnderTest;

    @BeforeEach
    void setUp() {
        l872LeafSimilarTrees009UnderTest = new L872_Leaf_SimilarTrees_009();
    }

    @Test
    void testLeafSimilar() {
        final TreeNode root1 = TreeTools.strTreeNodes("3,5,1,6,2,9,8,null,null,7,4");
        final TreeNode root2 = TreeTools.strTreeNodes("3,5,1,6,7,4,2,null,null,null,null,null,null,9,8");

        final boolean result = l872LeafSimilarTrees009UnderTest.leafSimilar(root1, root2);

        assertTrue(result);

        assertFalse(l872LeafSimilarTrees009UnderTest.leafSimilar(TreeTools.strTreeNodes("1,2,3"),
                                                                 TreeTools.strTreeNodes("1,3,2")));
    }
    @Test
    void testLeafSimilarIterator() {
        final TreeNode root1 = TreeTools.strTreeNodes("3,5,1,6,2,9,8,null,null,7,4");
        final TreeNode root2 = TreeTools.strTreeNodes("3,5,1,6,7,4,2,null,null,null,null,null,null,9,8");

        final boolean result = L872_Leaf_SimilarTrees_009.Solution.leafSimilar(root1, root2);

        assertTrue(result);

        assertFalse(L872_Leaf_SimilarTrees_009.Solution.leafSimilar(TreeTools.strTreeNodes("1,2,3"), TreeTools.strTreeNodes("1,3,2")));
    }
}
