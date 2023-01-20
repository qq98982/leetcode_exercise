package com.home.henry.array_01;

/**
 * 59. Spiral Matrix II
 *
 * Given a positive integer n, generate an n x n matrix filled with elements from 1 to n^2 in spiral order.
 * Input: n = 3 Output: [[1,2,3],[8,9,4],[7,6,5]]
 * Input: n = 1 Output: [[1]]
 */
public class L059_SpiralMatrixII_052 {
    /**
     * 统一的左闭右开
     */
    public int[][] generateMatrix(int n) {
        // 每个圈循环几次，例如n为奇数3，那么loop = 1 只是循环一圈，矩阵中间的值需要单独处理
        int loop = 0;
        int[][] res = new int[n][n];
        // 每次循环的开始点(start, start) start的值可以简化为loop - 1
        int start = 0;
        // 定义填充数字
        int count = 1;
        int i, j;

        // 判断边界后，loop从1开始
        while (loop++ < n / 2) {
            // 模拟上侧从左到右
            for (j = start; j < n - loop; j++) {
                res[start][j] = count++;
            }

            // 模拟右侧从上到下
            for (i = start; i < n - loop; i++) {
                res[i][j] = count++;
            }

            // 模拟下侧从右到左
            for (; j >= loop; j--) {
                res[i][j] = count++;
            }

            // 模拟左侧从下到上
            for (; i >= loop; i--) {
                res[i][j] = count++;
            }
            start++;
        }

        if (n % 2 == 1) {
            res[start][start] = count;
        }

        return res;
    }
}
