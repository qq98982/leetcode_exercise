package com.home.henry.dp_06;

/**
 * 343. Integer Break
 *
 * Given an integer n, break it into the sum of k positive integers, where k >= 2,
 * and maximize the product of those integers.
 *
 * Return the maximum product you can get.
 *
 * Input: n = 2 Output: 1
 * Explanation: 2 = 1 + 1, 1 × 1 = 1.
 *
 * Input: n = 10 Output: 36
 * Explanation: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36.
 */
public class L343_Integer_Break_021 {
    public int integerBreak(int n) {
        if (n == 0) {return 0;}
        int[] dp = new int[n + 1];
        dp[2] = 1;
        for (int i = 3; i <= n; i++) {
            for (int j = 1; j <= i / 2; j++) {
                dp[i] = Math.max(dp[i], Math.max((i - j) * j, dp[i - j] * j));
            }
        }
        return dp[n];
    }
}
