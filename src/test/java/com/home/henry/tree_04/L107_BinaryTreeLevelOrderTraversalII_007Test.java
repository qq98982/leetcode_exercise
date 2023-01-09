package com.home.henry.tree_04;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
        assertEquals(List.of(List.of(15,7),List.of(9,20),List.of(3)), l107BinaryTreeLevelOrderTraversalII007UnderTest.levelOrderBottom(
                TreeTools.strTreeNodes("3,9,20,null,null,15,7")));
    }

    @Test
    void testLevelOrderBottomBFS() {
        assertEquals(List.of(List.of(15,7),List.of(9,20),List.of(3)), l107BinaryTreeLevelOrderTraversalII007UnderTest.levelOrderBottomBFS(
                TreeTools.strTreeNodes("3,9,20,null,null,15,7")));
    }
}
