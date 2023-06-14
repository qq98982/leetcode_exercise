package com.home.henry.tree_04;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.home.henry.tool.TreeTools;

class L333_LargestBSTSubtree_070Test {

    private L333_LargestBSTSubtree_070 l333LargestBSTSubtree070UnderTest;

    @BeforeEach
    void setUp() throws Exception {
        l333LargestBSTSubtree070UnderTest = new L333_LargestBSTSubtree_070();
    }

    @Test
    void testLargestBSTSubtree() {
        assertEquals(3, l333LargestBSTSubtree070UnderTest.largestBSTSubtree(
                TreeTools.strTreeNodes("10,5,15,1,8,null,7")));
        assertEquals(2, l333LargestBSTSubtree070UnderTest.largestBSTSubtree(
                TreeTools.strTreeNodes("4,2,7,2,3,5,null,2,null,null,null,null,null,1")));
    }

}
