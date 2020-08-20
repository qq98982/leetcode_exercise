package com.home.henry.dp_06;

/**
 * 740. Delete and Earn
 * Given an array nums of integers, you can perform operations on the array.
 * In each operation, you pick any nums[i] and delete it to earn nums[i] points. After, you must delete
 * every element equal to nums[i] - 1 or nums[i] + 1.
 * You start with 0 points. Return the maximum number of points you can earn by applying such operations.
 *
 * Example 1: Input: nums = [3, 4, 2] Output: 6
 * Explanation: Delete 4 to earn 4 points, consequently 3 is also deleted. Then, delete 2 to earn 2 points. 6 total points are earned.
 *
 * This problem can be solved using every solution from house robbery.
 */
public class L740_DeleteAndEarn_012 {

    static class Solution {
        public int deleteAndEarn(int[] nums) {
            int[] bucket = new int[10001];
            for(int num: nums) {
                bucket[num] += num;
            }
            int[] dp = new int[10001];
            dp[0] = bucket[0];
            dp[1] = bucket[1];
            for (int i = 2; i < bucket.length; i++) {
                dp[i] = Math.max(bucket[i] + dp[i - 2], dp[i - 1]);
            }
            return dp[10000];
        }
        // House Robbery
        public int rob(int[] nums) {
            int len  = nums.length;
            if (len == 0) {
                return 0;
            }
            if (len == 1) {
                return nums[0];
            }
            int[] dp = new int[len];
            dp[0] = nums[0];
            for (int i = 1; i < len; i++) {
                if (i == 1) {
                    dp[i] = Math.max(nums[i],dp[i - 1]);
                    continue;
                }
                dp[i] = Math.max(nums[i] + dp[i - 2], dp[i - 1]);
            }
            return dp[len-1];
        }
    }
}
