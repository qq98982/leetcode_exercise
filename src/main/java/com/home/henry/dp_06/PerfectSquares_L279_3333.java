package com.home.henry.dp_06;

import java.util.Arrays;

/**
 * 279. Perfect Squares
 */
public class PerfectSquares_L279_3333 {

    static class Solution {

        public int numSquares(int n) {
            int[] res = new int[n + 1];
            Arrays.fill(res, Integer.MAX_VALUE);
            res[0] = 0;
            for (int i = 0; i <= n; i++) {
                for (int j = 1; j * j <= i; j++) {
                    res[i] = Math.min(res[i], res[i - j * j] + 1);
                }
            }
            return res[n];
        }
    }
}
