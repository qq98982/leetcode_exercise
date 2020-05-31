package com.home.henry.dp_06;

/**
 * 97. Interleaving String
 *
 * Given s1, s2, s3, find whether s3 is formed by the interleaving of s1 and s2.
 *
 * Input: s1 = "aabcc", s2 = "dbbca", s3 = "aadbbcbcac" Output: true
 *
 * Input: s1 = "aabcc", s2 = "dbbca", s3 = "aadbbbaccc" Output: false
 * 双序列dp
 */
public class InterleavingString_L097_011 {
    static class Solution {
        public static boolean isInterleave(String s1, String s2, String s3) {
            char[] c1 = s1.toCharArray();
            char[] c2 = s2.toCharArray();
            char[] c3 = s3.toCharArray();
            int m = c1.length, n = c2.length;
            // 先看最明显的退出条件
            if (s3.length() != m + n) {return false;}
            boolean[][] f = new boolean[m + 1][n + 1];
            // m + 1个
            for (int i = 0; i <= m; i++) {
                // n + 1个
                for (int j = 0; j <= n; j++) {
                    // init
                    if (i == 0 && j == 0) {
                        f[i][j] = true;
                        continue;
                    }
                    // init非0为false
                    f[i][j] = false;
                    // 前i+j个字符由(s1前i-1和s2前j|s3[i+j-1]=s1[i-1]|)或(s1前i和s2前j-1|s3[i+j-1)=s2[j-1]|)组成
                    // 3的字符从1来
                    if (i > 0 && c3[i + j - 1] == c1[i - 1]) {
                        f[i][j] |= f[i - 1][j];
                    }
                    // 或3的字符从2来
                    if (j > 0 && c3[i + j - 1] == c2[j - 1]) {
                        f[i][j] |= f[i][j - 1];
                    }
                }
            }
            return f[m][n];
        }
    }

    public static void main(String[] args) {
        assert Solution.isInterleave("aabcc", "dbbca", "aadbbcbcac");
        assert Solution.isInterleave("s", "t", "st");
        assert !Solution.isInterleave("aabcc", "dbbca", "aadbbbaccc");
        assert !Solution.isInterleave("a", "", "c");
    }
}
