package com.home.henry.array_01;

import java.util.Arrays;

/**
 * 1099. Two Sum Less Than K
 *
 * Given an array A of integers and integer K, return the maximum S such that there exists i < j
 * with A[i] + A[j] = S and S < K. If no i, j exist satisfying this equation, return -1.
 * Input: A = [34,23,1,24,75,33,54,8], K = 60 Output: 58
 * Explanation: We can use 34 and 24 to sum 58 which is less than 60.
 *
 * Input: A = [10,20,30], K = 15 Output: -1
 * Explanation: In this case it's not possible to get a pair sum less that 15.
 *
 * array中有两个数相加小于k, 如果有,返回这两个数相加和最大值, 否则返回-1
 */
public class L1099_TwoSumLessThanK_043_1 {
    static class Solution {
        public static int twoSumK(int[] nums, int k) {
            int res = -1;
            Arrays.sort(nums);
            int start = 0, end = nums.length - 1;
            while (start < end) {
                int sum = nums[start] + nums[end];
                if (sum >= k) {
                    end--;
                } else {
                    res = Math.max(res, sum);
                    start++;
                }
            }
            return res;
        }

        public static int twoSumKBruteForce(int[] nums, int k) {
            int res = -1;
            for (int i = 0; i < nums.length - 1; i++) {
                for (int j = i + 1; j < nums.length; j++) {
                    if (nums[i] + nums[j] < k) {
                        res = Math.max(res, nums[i] + nums[j]);
                    }
                }
            }
            return res;
        }
    }

    public static void main(String[] args) {
        assert Solution.twoSumK(new int[] { 34, 23, 1, 24, 75, 33, 54, 8 }, 60) == 58;
        assert Solution.twoSumK(new int[] { 10, 20, 30 }, 15) == -1;
    }
}
