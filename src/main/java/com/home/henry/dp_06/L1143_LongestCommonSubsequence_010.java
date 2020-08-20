package com.home.henry.dp_06;

/**
 * 1143. Longest Common Subsequence
 *
 * Given two strings text1 and text2, return the length of their longest common subsequence.
 *
 * A subsequence of a string is a new string generated from the original string with some characters
 * (can be none) deleted without changing the relative order of the remaining characters.
 * (eg, "ace" is a subsequence of "abcde" while "aec" is not). A common subsequence of two strings is a
 * subsequence that is common to both strings.
 *
 * If there is no common subsequence, return 0.
 * Input: text1 = "abcde", text2 = "ace" Output: 3
 * Explanation: The longest common subsequence is "ace" and its length is 3.
 *
 * Input: text1 = "abc", text2 = "abc" Output: 3
 * Explanation: The longest common subsequence is "abc" and its length is 3.
 *
 * Input: text1 = "abc", text2 = "def" Output: 0
 * Explanation: There is no such common subsequence, so the result is 0.
 * 典型的双序列dp, 可以看九章的dp视频
 */
public class L1143_LongestCommonSubsequence_010 {
    static class Solution {
        public static int longestCommonSubsequence(String text1, String text2) {
            if (text1 == null || text2 == null) {return 0;}
            char[] a = text1.toCharArray();
            char[] b = text2.toCharArray();
            int m = a.length;
            int n = b.length;
            int[][] f = new int[m + 1][n + 1];
            for (int i = 0; i <= m; i++) {
                // init
                for (int j = 0; j <= n; j++) {
                    if (i == 0 || j == 0) {
                        f[i][j] = 0;
                        continue;
                    }
                    f[i][j] = Math.max(f[i - 1][j], f[i][j - 1]);
                    if (a[i - 1] == b[j - 1]) {
                        f[i][j] = Math.max(f[i][j], f[i - 1][j - 1] + 1);
                    }
                }
            }
            return f[m][n];
        }
    }

    public static void main(String[] args) {
        assert Solution.longestCommonSubsequence("abcde", "ace") == 3;
        assert Solution.longestCommonSubsequence("abc", "abc") == 3;
        assert Solution.longestCommonSubsequence("abc", "def") == 0;
    }
}
