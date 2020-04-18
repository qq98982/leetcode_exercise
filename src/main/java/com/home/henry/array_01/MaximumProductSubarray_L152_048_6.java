package com.home.henry.array_01;

/**
 * 152. Maximum Product Subarray
 *
 * Given an integer array nums, find the contiguous subarray within an array (containing at least one number)
 * which has the largest product.
 *
 * Input: [2,3,-2,4] Output: 6 Explanation: [2,3] has the largest product 6.
 * Input: [-2,0,-1] Output: 0 Explanation: The result cannot be 2, because [-2,-1] is not a subarray.
 */
public class MaximumProductSubarray_L152_048_6 {

    static class Solution {
        // time: O(n)
        public int maxProduct(int[] nums) {
            int[] max = new int[nums.length];
            int[] min = new int[nums.length];
            int res = nums[0];
            max[0] = min[0] = nums[0];
            for (int i = 1; i < nums.length; i++) {
                if (nums[i] > 0) {
                    max[i] = Math.max(nums[i], max[i - 1] * nums[i]);
                    min[i] = Math.min(nums[i], min[i - 1] * nums[i]);
                } else {
                    max[i] = Math.max(nums[i], min[i - 1] * nums[i]);
                    min[i] = Math.min(nums[i], max[i - 1] * nums[i]);
                }
                res = Math.max(res, max[i]);
            }
            return res;
        }
    }
}
