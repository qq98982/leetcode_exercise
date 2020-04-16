package com.home.henry.array_01;

import java.util.Arrays;

/**
 * 1099. Two Sum Less Than K
 *
 * array中有两个数相加小于k, 如果有,返回这两个数相加和, 否则返回-1
 */
public class TwoSumLessThanK_L1099_043_1 {
    static class Solution {
        public static int twoSumK(int[] nums, int k) {
            int res = -1;
            Arrays.sort(nums);
            int start = 0, end = nums.length - 1;
            while (start < end) {
                if (nums[start] + nums[end] <= k) {
                    end--;
                } else {
                    res = Math.max(res, nums[start] + nums[end]);
                    start++;
                }
            }
            return res;
        }

        public static int twoSumKBruteForce(int[] nums, int k) {
            int res = -1;
            for (int i = 0; i < nums.length; i++) {
                for (int j = i + 1; i < nums.length; i++) {
                    if (nums[i] + nums[j] < k) {
                        res = Math.max(res, nums[i] + nums[j]);
                    }
                }
            }
            return res;
        }
    }
}
