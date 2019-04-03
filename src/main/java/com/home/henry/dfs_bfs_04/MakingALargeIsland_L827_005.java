package com.home.henry.dfs_bfs_04;

/**
 * 827. Making A Large Island
 * In a 2D grid of 0s and 1s, we change at most one 0 to a 1.
 * After, what is the size of the largest island? (An island is a 4-directionally connected group of 1s).
 * Input: [[1, 0], [0, 1]] Output: 3
 * Explanation: Change one 0 to 1 and connect two 1s, then we get an island with area = 3.
 * Input: [[1, 1], [1, 0]] Output: 4
 * Explanation: Change the 0 to 1 and make the island bigger, only one island with area = 4.
 * Input: [[1, 1], [1, 1]] Output: 4
 * Explanation: Can't change any 0 to 1, only one island with area = 4.
 */
public class MakingALargeIsland_L827_005 {
    public int largestIsland(int[][] grid) {
        int max = -1, n = grid.length;
        if (n == 0) {return 0;}
        int m = grid[0].length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 0) {
                    grid[i][j] = 1;
                    max = Math.max(max, dfs(grid, i, j, new boolean[n][m]));
                    // You turn the grid from 0 to 1 and try to get a bigger island. Then you turn it back and try another 0 grid.
                    // If you don't turn it back, finally all the grid will be 1 and there would be only one island.
                    grid[i][j] = 0;
                }
            }
        }
        return max == -1 ? m * n : max;
    }

    private int dfs(int[][] grid, int i, int j, boolean[][] seen) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] != 1 || seen[i][j]) {
            return 0;
        }
        seen[i][j] = true;
        return 1 + dfs(grid, i + 1, j, seen) + dfs(grid, i - 1, j, seen) + dfs(grid, i, j + 1, seen) + dfs(
                grid, i, j - 1, seen);
    }
}
