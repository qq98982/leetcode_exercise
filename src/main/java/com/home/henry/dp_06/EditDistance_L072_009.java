package com.home.henry.dp_06;

/**
 * 72. Edit Distance
 *
 * Given two words word1 and word2, find the minimum number of operations required to convert word1 to word2.
 *
 * You have the following 3 operations permitted on a word:
 *
 * Insert a character
 * Delete a character
 * Replace a character
 *
 * Input: word1 = "horse", word2 = "ros"
 * Output: 3
 * Explanation:
 * horse -> rorse (replace 'h' with 'r')
 * rorse -> rose (remove 'r')
 * rose -> ros (remove 'e')
 *
 * Input: word1 = "intention", word2 = "execution"
 * Output: 5
 * Explanation:
 * intention -> inention (remove 't')
 * inention -> enention (replace 'i' with 'e')
 * enention -> exention (replace 'n' with 'x')
 * exention -> exection (replace 'n' with 'c')
 * exection -> execution (insert 'u')
 */
public class EditDistance_L072_009 {

    static class Solution {
        public static int minDistance(String word1, String word2) {
            if (word1 == null || word2 == null) {return 0;}
            int m = word1.length(), n = word2.length();
            int[][] f = new int[m + 1][n + 1];
            for (int i = 0; i <= m; i++) {
                for (int j = 0; j <= n; j++) {
                    // init
                    if (i == 0) {
                        f[i][j] = j;
                        continue;
                    }
                    if (j == 0) {
                        f[i][j] = i;
                        continue;
                    }
                    // delete        //add
                    f[i][j] = Math.min(f[i - 1][j] + 1, f[i][j - 1] + 1);
                    // replace
                    f[i][j] = Math.min(f[i][j], f[i - 1][j - 1] + 1);
                    // same
                    if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                        f[i][j] = Math.min(f[i][j], f[i - 1][j - 1]);
                    }
                }
            }
            return f[m][n];
        }
    }

    public static void main(String[] args) {
        assert Solution.minDistance("horse", "rose") == 2;
        assert Solution.minDistance("horse", "ros") == 3;
        assert Solution.minDistance("intention", "execution") == 5;
    }
}
