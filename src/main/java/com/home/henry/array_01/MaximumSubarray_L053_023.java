package com.home.henry.array_01;

/**
 * 53. Maximum Subarray
 *
 * 一个是正常解法, time O(n), space O(1), DP的解法 time O(n), space O(n), 前者用的也是DP的思路, 空间上要好点
 */
public class MaximumSubarray_L053_023 {
    class Solution {
        public int maxSubArray(int[] nums) {
            if (nums == null || nums.length == 0) {return Integer.MIN_VALUE;}
            int res = nums[0];
            int sum = nums[0];
            for (int i = 1; i < nums.length; i++) {
                sum = Math.max(sum, sum + nums[i]);
                res = Math.max(sum, res);
            }
            return res;
        }
    }

    class SolutionDP {
        public int maxSubArray(int[] nums) {
            if (nums == null || nums.length == 0) {return Integer.MIN_VALUE;}
            int res = nums[0];
            int[] dp = new int[nums.length];
            dp[0] = nums[0];
            for (int i = 1; i < nums.length; i++) {
                dp[i] = nums[i] + (dp[i - 1] < 0 ? 0 : dp[i - 1]);
                res = Math.max(dp[i], res);
            }
            return res;
        }
    }
}
