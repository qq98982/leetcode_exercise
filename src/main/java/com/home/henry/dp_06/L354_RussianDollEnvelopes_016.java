package com.home.henry.dp_06;

import java.util.Arrays;

/**
 * 354. Russian Doll Envelopes
 * <p>
 * You have a number of envelopes with widths and heights given as a pair of integers (w, h). One envelope can fit into another if and only if both the width and height of one envelope is greater than the width and height of the other envelope.
 * What is the maximum number of envelopes can you Russian doll? (put one inside other)
 * Note: Rotation is not allowed.
 * <p>
 * Example: Input: [[5,4],[6,4],[6,7],[2,3]] Output: 3
 * Explanation: The maximum number of envelopes you can Russian doll is 3 ([2,3] => [5,4] => [6,7]).
 * 9c dp video 4
 */
public class L354_RussianDollEnvelopes_016 {
    public static class Solution {
        public static int maxEnvelopes(int[][] envelopes) {
            if (envelopes == null || envelopes.length == 0) {
                return 0;
            }

            int n = envelopes.length;
            int[] f = new int[n];
            Arrays.sort(envelopes, (a, b) -> {
                if (a[0] == b[0]) {
                    return a[1] - b[1];
                } else {
                    return a[0] - b[0];
                }
            });

            int i, j, res = 0;
            for (i = 0; i < n; i++) {
                f[i] = 1;
                for (j = 0; j < i; j++) {
                    if (envelopes[j][0] < envelopes[i][0] && envelopes[j][1] < envelopes[i][1]) {
                        f[i] = Math.max(f[i], f[j] + 1);
                    }
                }
                res = Math.max(res, f[i]);
            }
            return res;
        }
    }
}
