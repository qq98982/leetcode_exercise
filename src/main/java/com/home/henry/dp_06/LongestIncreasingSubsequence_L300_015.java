package com.home.henry.dp_06;

/**
 * 300. Longest Increasing Subsequence
 * Given an unsorted array of integers, find the length of longest increasing subsequence.
 *
 * Example: Input: [10,9,2,5,3,7,101,18] Output: 4
 * Explanation: The longest increasing subsequence is [2,3,7,101], therefore the length is 4.
 * explanation in 9c dp video 4
 */
public class LongestIncreasingSubsequence_L300_015 {

    class Solution {
        public int lengthOfLIS(int[] nums) {
            if (nums == null || nums.length == 0) {
                return 0;
            }
            int n = nums.length;
            int[] f = new int[n];
            int res = 0;
            int j, i;
            for (j = 0; j < n; j++) {
                // case 1
                f[j] = 1;

                // case 2
                for (i = 0; i < j; i++) {
                    if (nums[i] < nums[j] && f[i] + 1 > f[j]) {
                        f[j] = f[i] + 1;
                    }
                }

                res = Math.max(res, f[j]);
            }
            return res;
        }
    }
}
