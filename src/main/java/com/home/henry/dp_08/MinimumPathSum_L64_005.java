package com.home.henry.dp_08;

/**
 * Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right which minimizes the sum of all numbers along its path.
 * Note: You can only move either down or right at any point in time.
 * i = 0 是第一行, j = 0 是第一列
 */
public class MinimumPathSum_L64_005 {

    public int minPathSum(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (i == 0 && j != 0) {
                    grid[i][j] += grid[i][j - 1];
                }
                if (j == 0 && i != 0) {
                    grid[i][j] += grid[i - 1][j];
                }
                if (i != 0 && j != 0) {
                    grid[i][j] += Math.min(grid[i - 1][j], grid[i][j - 1]);
                }
            }
        }
        return grid[grid.length - 1][grid[0].length - 1];
    }

    /**
     * 滚动数组
     */
    public int minPathSumRollingArray(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int m = grid.length;
        int n = grid[0].length;
        int[][] f = new int[2][n];
        int old = 1, now = 0;
        int i, j , t1, t2;
        for (i = 0; i < m; i++) {
            // old is row i-1
            old = now;
            // now is row i
            now = 1 -now;
            for (j =0; j < n; j++) {
                if (i == 0 && j == 0) {
                    f[now][j] = grid[i][j];
                    continue;
                }
                f[now][j] = grid[i][j];
                // from top
                if (i > 0) {
                    t1 = f[old][j];
                } else {
                    t1 = Integer.MAX_VALUE;
                }
                // from left
                if (j > 0) {
                    t2 = f[now][j - 1];
                } else {
                    t2 = Integer.MAX_VALUE;
                }
                if (t1 < t2) {
                    f[now][j] += t1;
                } else {
                    f[now][j] += t2;
                }
            }
        }
        return f[now][n - 1];
    }
}
