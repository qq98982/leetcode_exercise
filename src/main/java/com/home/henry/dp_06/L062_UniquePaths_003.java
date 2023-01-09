package com.home.henry.dp_06;

/**
 * 62. Unique Paths
 *
 * A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).
 * The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).
 * How many possible unique paths are there?
 * Input: m = 3, n = 7 Output: 28
 * Input: m = 3, n = 2 Output: 3
 */
public class L062_UniquePaths_003 {

    public int uniquePaths(int m, int n) {
        if (m < 1 || n < 1) {
            return 0;
        }
        int[] res = new int[n];
        res[0] = 1;
        for (int i = 0; i < m; i++) {
            for (int j = 1; j < n; j++) {
                res[j] = res[j] + res[j - 1];
            }
        }
        return res[n - 1];
    }

    public int uniquePaths2(int m, int n) {
        if (m < 1 || n < 1) {
            return 0;
        }

        int[][] f = new int[m][n];
        f[0][0] = 0;
        for (int i = 0; i < f.length; i++) {
            for (int j = 0; j < f[0].length; j++) {
                if (i == 0 || j == 0) {
                    f[i][j] = 1;
                } else {
                    f[i][j] = f[i - 1][j] + f[i][j - 1];
                }
            }
        }
        return f[m-1][n-1];
    }

}
