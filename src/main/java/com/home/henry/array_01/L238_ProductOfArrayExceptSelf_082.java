package com.home.henry.array_01;

/**
 * 238. Product of Array Except Self
 *
 * Given an integer array nums, return an array answer such that answer[i] is equal to the product of all the elements of nums except nums[i].
 *
 * The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.
 *
 * You must write an algorithm that runs in O(n) time and without using the division operation.
 *
 * Input: nums = [1,2,3,4] Output: [24,12,8,6]
 *
 * Input: nums = [-1,1,0,-3,3] Output: [0,0,9,0,0]
 */
public class L238_ProductOfArrayExceptSelf_082 {

    public int[] productExceptSelf(int[] nums) {
        if (nums == null || nums.length == 0) {return nums;}
        int[] res = new int[nums.length];
        res[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            res[i] = res[i - 1] * nums[i - 1];
        }
        int right = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            res[i] *= right;
            right *= nums[i];
        }
        return res;
    }

}
