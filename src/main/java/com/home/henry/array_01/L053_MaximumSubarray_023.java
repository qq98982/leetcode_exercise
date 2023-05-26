package com.home.henry.array_01;

/**
 * 53. Maximum Subarray
 *
 * Find the contiguous subarray within an array (containing at least one number) which has the largest sum.
 *
 * For example, given the array [−2,1,−3,4,−1,2,1,−5,4], the contiguous subarray [4,−1,2,1] has the largest sum = 6.
 *
 * 一个是正常解法, time O(n), space O(1), DP的解法 time O(n), space O(n), 前者用的也是DP的思路, 空间上要好点
 */
public class L053_MaximumSubarray_023 {

    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {return Integer.MIN_VALUE;}
        int res = nums[0];
        final int[] dp = new int[nums.length];
        dp[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = nums[i] + Math.max(dp[i - 1], 0);
            res = Math.max(dp[i], res);
        }
        return res;
    }
}
