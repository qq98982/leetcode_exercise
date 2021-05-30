package com.home.henry.dp_06;

/**
 * 63. Unique Paths II
 *
 * A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).
 * The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).
 * Now consider if some obstacles are added to the grids. How many unique paths would there be?
 *
 * Input:
 * [
 *   [0,0,0],
 *   [0,1,0],
 *   [0,0,0]
 * ]
 * Output: 2
 */
public class L063_UniquePathsII_004 {

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        // width = obstacleGrid[0].length
        // height = obstacleGrid.length
        int length = obstacleGrid[0].length;
        int[] res = new int[length];
        res[0] = 1;
        for (int i = 0; i < obstacleGrid.length; i++) {
            for (int j = 0; j < length; j++) {
                if (obstacleGrid[i][j] == 1) {
                    res[j] = 0;
                } else if (j > 0) {
                    res[j] += res[j - 1];
                }
            }
        }
        return res[length - 1];
    }

    class Solution {
        public int uniquePathsWithObstacles(int[][] obstacleGrid) {

            int m = obstacleGrid.length;
            if (m == 0) {return 0;}
            int n = obstacleGrid[0].length;
            if (n == 0) {return 0;}
            if (obstacleGrid[0][0] == 1) {return 0;}

            int[][] f = new int[m][n];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (obstacleGrid[i][j] == 1) {
                        f[i][j] = 0;
                    } else {
                        // 这里要初始化
                        if (i == 0 && j == 0) {
                            f[i][j] = 1;
                        } else {
                            // 这里这样写是为了减少判断的复杂度
                            f[i][j] = 0;
                            if (i >= 1) {
                                f[i][j] += f[i - 1][j];
                            }
                            if (j >= 1) {
                                f[i][j] += f[i][j - 1];
                            }
                        }
                    }
                }
            }
            return f[m - 1][n - 1];
        }
    }

}
