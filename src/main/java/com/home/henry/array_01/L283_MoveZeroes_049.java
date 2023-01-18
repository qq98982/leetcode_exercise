package com.home.henry.array_01;

/**
 * 283. Move Zeroes
 *
 * Given an integer array nums, move all 0's to the end of it while maintaining the
 * relative order of the non-zero elements.
 *
 * Note that you must do this in-place without making a copy of the array.
 *
 * Input: nums = [0,1,0,3,12] Output: [1,3,12,0,0]
 * Input: nums = [0] Output: [0]
 */
public class L283_MoveZeroes_049 {
    public void moveZeroes(int[] nums) {
        if (nums == null || nums.length == 0) {return;}
        int start = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[start++] = nums[i];
            }
        }
        for (int i = start; i < nums.length; i++) {
            nums[i] = 0;
        }
    }
}
