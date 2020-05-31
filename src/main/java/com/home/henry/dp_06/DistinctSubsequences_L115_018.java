package com.home.henry.dp_06;

/**
 * 115. Distinct Subsequences
 *
 * Given a string S and a string T, count the number of distinct subsequences of S which equals T.
 *
 * A subsequence of a string is a new string which is formed from the original string by deleting some
 * (can be none) of the characters without disturbing the relative positions of the remaining characters.
 * (ie, "ACE" is a subsequence of "ABCDE" while "AEC" is not).
 *
 * Input: S = "rabbbit", T = "rabbit"
 * Output: 3
 * As shown below, there are 3 ways you can generate "rabbit" from S.
 * (The caret symbol ^ means the chosen letters)
 *
 * rabbbit
 * ^^^^ ^^
 * rabbbit
 * ^^ ^^^^
 * rabbbit
 * ^^^ ^^^
 *
 * DP的解法:
 *
 * s is the longer string [0, i-1], t is the shorter substring [0, j-1]. We can assume t is fixed,
 * and s is increasing in character one by on
 *
 * The first case is easy to catch. When the new character in s, s[i-1], is not equal with the head char
 * in t, t[j-1], we can no longer increment the number of distinct subsequences, it is the same as the
 * situation before incrementing the s, so dp[i][j] = dp[i-1][j].
 *
 * However, when the new incrementing character in s, s[i-1] is equal with t[j-1], which contains two
 * case:
 * We don't match those two characters, which means that it still has original number of distinct
 * subsequences, so dp[i][j] = dp[i-1][j].
 * We match those two characters, in this way. dp[i][j] = dp[i-1][j-1];
 * Thus, including both two case, dp[i][j] = dp[i-1][j] + dp[i-1][j-1]
 * 双序列, 9c dp视频中有讲解
 */
public class DistinctSubsequences_L115_018 {

    static class Solution {
        public static int numDistinct(String s, String t) {
            int m = s.length(), n = t.length();
            int[][] f = new int[m + 1][n + 1];
            // f[i][j]是t前j个字符[0..j-1]在A前i个字符[0..i-1]中出现多少次
            // 转移方程 f[i][j] = f[i-1][j-1]|A[i-1]=B[i-1] + f[i-1][j]
            for (int i = 0; i <= m; i++) {
                for (int j = 0; j <= n; j++) {
                    // t是空, t在s中出现的次数是1 非常重要
                    if (j == 0) {
                        f[i][j] = 1;
                        continue;
                    }
                    // s是空而t不是空, t在s中出现的次数为0
                    // 这个和上面的不能换位置
                    if (i == 0) {
                        f[i][j] = 0;
                        continue;
                    }
                    f[i][j] = f[i - 1][j];
                    if (s.charAt(i - 1) == t.charAt(j - 1)) {
                        f[i][j] += f[i - 1][j - 1];
                    }
                }
            }
            return f[m][n];
        }
    }

    public static void main(String[] args) {
        assert Solution.numDistinct("rabbbit", "rabbit") == 3;
    }
}
