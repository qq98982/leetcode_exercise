package com.home.henry.dp;

/**
 * 198. House Robber
 * Input: [1,2,3,1] Output: 4
 * Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3). Total amount you can rob = 1 + 3 = 4.
 */
public class HouseRobber_L198_007 {

    static class Solution {
        public int rob(int[] nums) {
            int[] dp = new int[nums.length + 2];
            for (int i = 0; i < nums.length; i++) {
                dp[i + 2] = Math.max(dp[i] + nums[i], dp[i + 1]);
            }
            return dp[dp.length - 1];
        }

        public int robSec(int[] nums) {
            int prev = 0, sec = 0;
            for (int i = 0; i < nums.length; i++) {
                int tmp = prev;
                prev = Math.max(sec + nums[i], prev);
                sec = tmp;
            }
            return prev;
        }
    }

}
