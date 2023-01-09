package com.home.henry.tree_04;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.home.henry.tool.TreeTools;

class L226_InvertBinaryTree_017Test {

    private L226_InvertBinaryTree_017 l226InvertBinaryTree017UnderTest;

    @BeforeEach
    void setUp() {
        l226InvertBinaryTree017UnderTest = new L226_InvertBinaryTree_017();
    }

    @Test
    void testInvertTree() {
        Assertions.assertTrue(TreeTools.isSameTree(
                l226InvertBinaryTree017UnderTest.invertTree(TreeTools.strTreeNodes("4,2,7,1,3,6,9")),
                TreeTools.strTreeNodes("4,7,2,9,6,3,1")));
        Assertions.assertTrue(TreeTools.isSameTree(
                l226InvertBinaryTree017UnderTest.invertTree(TreeTools.strTreeNodes("2,1,3")),
                TreeTools.strTreeNodes("2,3,1")));
        Assertions.assertTrue(TreeTools.isSameTree(
                l226InvertBinaryTree017UnderTest.invertTree(TreeTools.strTreeNodes("")),
                TreeTools.strTreeNodes("")));
    }

    @Test
    void testInvertTree3() {
        Assertions.assertTrue(TreeTools.isSameTree(
                l226InvertBinaryTree017UnderTest.invertTree3(TreeTools.strTreeNodes("4,2,7,1,3,6,9")),
                TreeTools.strTreeNodes("4,7,2,9,6,3,1")));
        Assertions.assertTrue(TreeTools.isSameTree(
                l226InvertBinaryTree017UnderTest.invertTree3(TreeTools.strTreeNodes("2,1,3")),
                TreeTools.strTreeNodes("2,3,1")));
        Assertions.assertTrue(TreeTools.isSameTree(
                l226InvertBinaryTree017UnderTest.invertTree3(TreeTools.strTreeNodes("")),
                TreeTools.strTreeNodes("")));
    }

    @Test
    void testInvertTree2() {
        Assertions.assertTrue(TreeTools.isSameTree(
                l226InvertBinaryTree017UnderTest.invertTree2(TreeTools.strTreeNodes("4,2,7,1,3,6,9")),
                TreeTools.strTreeNodes("4,7,2,9,6,3,1")));
        Assertions.assertTrue(TreeTools.isSameTree(
                l226InvertBinaryTree017UnderTest.invertTree2(TreeTools.strTreeNodes("2,1,3")),
                TreeTools.strTreeNodes("2,3,1")));
        Assertions.assertTrue(TreeTools.isSameTree(
                l226InvertBinaryTree017UnderTest.invertTree2(TreeTools.strTreeNodes("")),
                TreeTools.strTreeNodes("")));
    }
}
