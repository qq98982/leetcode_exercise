package com.home.henry.tree_04;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.home.henry.tool.TreeTools;

class L112_PathSum_020Test {

    private L112_PathSum_020 l112PathSum020UnderTest;

    @BeforeEach
    void setUp() throws Exception {
        l112PathSum020UnderTest = new L112_PathSum_020();
    }

    @Test
    void testHasPathSum() {
        assertFalse(l112PathSum020UnderTest.hasPathSum(TreeTools.strTreeNodes("1 2"), 1));

        assertTrue(l112PathSum020UnderTest.hasPathSum(TreeTools.strTreeNodes("5,4,8,11,null,13,4,7,2,null,null,null,1"), 22));

        assertFalse(l112PathSum020UnderTest.hasPathSum(TreeTools.strTreeNodes("1 2 3"), 5));
        assertFalse(l112PathSum020UnderTest.hasPathSum(TreeTools.strTreeNodes(""), 0));
    }

    @Test
    void testHasPathSum2() {
        assertFalse(l112PathSum020UnderTest.hasPathSum2(TreeTools.strTreeNodes("1 2"), 1));

        assertTrue(l112PathSum020UnderTest.hasPathSum2(TreeTools.strTreeNodes("5,4,8,11,null,13,4,7,2,null,null,null,1"), 22));

        assertFalse(l112PathSum020UnderTest.hasPathSum2(TreeTools.strTreeNodes("1 2 3"), 5));
        assertFalse(l112PathSum020UnderTest.hasPathSum2(TreeTools.strTreeNodes(""), 0));
    }
}
