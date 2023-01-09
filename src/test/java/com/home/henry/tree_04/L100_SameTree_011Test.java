package com.home.henry.tree_04;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.home.henry.tool.TreeTools;

class L100_SameTree_011Test {

    private L100_SameTree_011 l100SameTree011UnderTest;

    @BeforeEach
    void setUp() {
        l100SameTree011UnderTest = new L100_SameTree_011();
    }

    @Test
    void testIsSameTree() {
        assertTrue(l100SameTree011UnderTest.isSameTree(TreeTools.strTreeNodes("1,2,3"),
                                                       TreeTools.strTreeNodes("1,2,3")));
        assertFalse(l100SameTree011UnderTest.isSameTree(TreeTools.strTreeNodes("1,2"),
                                                        TreeTools.strTreeNodes("1,null,2")));
        assertFalse(l100SameTree011UnderTest.isSameTree(TreeTools.strTreeNodes("1,2,1"),
                                                        TreeTools.strTreeNodes("1,1,2")));
        assertTrue(
                l100SameTree011UnderTest.isSameTree(TreeTools.strTreeNodes("1"), TreeTools.strTreeNodes("1")));
        assertTrue(l100SameTree011UnderTest.isSameTree(TreeTools.strTreeNodes(""), TreeTools.strTreeNodes("")));
    }
}
