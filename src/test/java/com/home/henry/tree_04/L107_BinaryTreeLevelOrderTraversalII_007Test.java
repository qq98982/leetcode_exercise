package com.home.henry.tree_04;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.home.henry.tool.TreeTools;

class L107_BinaryTreeLevelOrderTraversalII_007Test {

    private L107_BinaryTreeLevelOrderTraversalII_007 l107BinaryTreeLevelOrderTraversalII007UnderTest;

    @BeforeEach
    void setUp() {
        l107BinaryTreeLevelOrderTraversalII007UnderTest = new L107_BinaryTreeLevelOrderTraversalII_007();
    }

    @Test
    void testLevelOrderBottom() {
        assertEquals(Arrays.asList(Arrays.asList(15, 7), Arrays.asList(9, 20), Arrays.asList(3)), l107BinaryTreeLevelOrderTraversalII007UnderTest.levelOrderBottom(
                TreeTools.strTreeNodes("3,9,20,null,null,15,7")));
        assertEquals(Arrays.asList(Arrays.asList(4,5),Arrays.asList(2,3),Arrays.asList(1)), l107BinaryTreeLevelOrderTraversalII007UnderTest.levelOrderBottom(
                TreeTools.strTreeNodes("1,2,3,4,5")));
    }

    @Test
    void testLevelOrderBottomBFS() {
        assertEquals(Arrays.asList(Arrays.asList(15,7),Arrays.asList(9,20),Arrays.asList(3)), l107BinaryTreeLevelOrderTraversalII007UnderTest.levelOrderBottomBFS(
                TreeTools.strTreeNodes("3,9,20,null,null,15,7")));
        assertEquals(Arrays.asList(Arrays.asList(4,5),Arrays.asList(2,3),Arrays.asList(1)), l107BinaryTreeLevelOrderTraversalII007UnderTest.levelOrderBottomBFS(
                TreeTools.strTreeNodes("1,2,3,4,5")));
    }
}
