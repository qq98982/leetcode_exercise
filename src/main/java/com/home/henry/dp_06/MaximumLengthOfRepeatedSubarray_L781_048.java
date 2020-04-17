package com.home.henry.dp_06;

/**
 * 718. Maximum Length of Repeated Subarray
 *
 * Given two integer arrays A and B, return the maximum length of an subarray that appears in both arrays.
 * Input: A: [1,2,3,2,1] B: [3,2,1,4,7] Output: 3
 * Explanation:
 * The repeated subarray with maximum length is [3, 2, 1].
 *
 * 1 <= len(A), len(B) <= 1000
 * 0 <= A[i], B[i] < 100
 */
public class MaximumLengthOfRepeatedSubarray_L781_048 {

    // 如果两个匹配上了, 那么位置i+1和j+1的数量比i和j对应的+1
    static class Solution {
        public int findLength(int[] A, int[] B) {
            if (A == null || A.length == 0) {return 0;}
            if (B == null || B.length == 0) {return 0;}
            int[][] dp = new int[A.length + 1][B.length + 1];
            int max = Integer.MIN_VALUE;
            for (int i = 0; i < A.length; i++) {
                for (int j = 0; j < B.length; j++) {
                    if (A[i] == B[j]) {
                        dp[i + 1][j + 1] = 1 + dp[i][j];
                        max = Math.max(max, dp[i + 1][j + 1]);
                    }
                }
            }
            return max == Integer.MIN_VALUE ? 0 : max;
        }
    }
}
