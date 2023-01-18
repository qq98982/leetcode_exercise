package com.home.henry.array_01;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.home.henry.tool.GenRandomArray;

class L283_MoveZeroes_049Test {

    private L283_MoveZeroes_049 l283MoveZeroes049UnderTest;

    @BeforeEach
    void setUp() {
        l283MoveZeroes049UnderTest = new L283_MoveZeroes_049();
    }

    @Test
    void testMoveZeroes1() {
        int[] nums = { 0, 1, 0, 3, 12 };
        l283MoveZeroes049UnderTest.moveZeroes(nums);
        Assertions.assertTrue(GenRandomArray.isEqual(new int[]{1,3,12,0,0},nums));
    }
    @Test
    void testMoveZeroes2() {
        int[] nums = { 0 };
        l283MoveZeroes049UnderTest.moveZeroes(nums);
        Assertions.assertTrue(GenRandomArray.isEqual(new int[]{0},nums));
    }
}
