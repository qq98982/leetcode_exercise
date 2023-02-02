package com.home.henry.tree_04;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.home.henry.tool.TreeTools;

class L101_SymmetricTree_012Test {

    @Test
    void isSymmetricTreeRecurTest() {
        Assertions.assertTrue(L101_SymmetricTree_012.Solution.isSymmetric(TreeTools.strTreeNodes("1")));
        Assertions.assertTrue(L101_SymmetricTree_012.Solution.isSymmetric(TreeTools.strTreeNodes("1,2,2,3,4,4,3")));
        Assertions.assertFalse(L101_SymmetricTree_012.Solution.isSymmetric(TreeTools.strTreeNodes("1,2,2,3,4,5,3")));
        Assertions.assertFalse(
                L101_SymmetricTree_012.Solution.isSymmetric(TreeTools.strTreeNodes("1,2,2,null,3,null,3")));
    }

    @Test
    void isSymmetricTreeIterTest() {
        Assertions.assertTrue(L101_SymmetricTree_012.Solution2.isSymmetric(TreeTools.strTreeNodes("1")));
        Assertions.assertTrue(
                L101_SymmetricTree_012.Solution2.isSymmetric(TreeTools.strTreeNodes("1,2,2,3,4,4,3")));
        Assertions.assertFalse(L101_SymmetricTree_012.Solution2.isSymmetric(TreeTools.strTreeNodes("1,2,2,3,4,5,3")));

        Assertions.assertFalse(
                L101_SymmetricTree_012.Solution2.isSymmetric(TreeTools.strTreeNodes("1,2,2,null,3,null,3")));
    }
}
