package com.home.henry.tree_04;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.home.henry.tool.TreeTools;

class L101_SymmetricTree_012Test {

    private L101_SymmetricTree_012 l101SymmetricTree012UnderTest;

    @BeforeEach
    void setUp() throws Exception {
        l101SymmetricTree012UnderTest = new L101_SymmetricTree_012();
    }

    @Test
    void testIsSymmetric() {
        Assertions.assertTrue(l101SymmetricTree012UnderTest.isSymmetric(TreeTools.strTreeNodes("1")));
        Assertions.assertTrue(
                l101SymmetricTree012UnderTest.isSymmetric(TreeTools.strTreeNodes("1,2,2,3,4,4,3")));
        Assertions.assertFalse(
                l101SymmetricTree012UnderTest.isSymmetric(TreeTools.strTreeNodes("1,2,2,3,4,5,3")));
        Assertions.assertFalse(
                l101SymmetricTree012UnderTest.isSymmetric(TreeTools.strTreeNodes("1,2,2,null,3,null,3")));
    }

    @Test
    void testIsSymmetric2() {
        Assertions.assertTrue(l101SymmetricTree012UnderTest.isSymmetric(TreeTools.strTreeNodes("1")));
        Assertions.assertTrue(
                l101SymmetricTree012UnderTest.isSymmetric(TreeTools.strTreeNodes("1,2,2,3,4,4,3")));
        Assertions.assertFalse(
                l101SymmetricTree012UnderTest.isSymmetric(TreeTools.strTreeNodes("1,2,2,3,4,5,3")));

        Assertions.assertFalse(
                l101SymmetricTree012UnderTest.isSymmetric(TreeTools.strTreeNodes("1,2,2,null,3,null,3")));
    }
}
