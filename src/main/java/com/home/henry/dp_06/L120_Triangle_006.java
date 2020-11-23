package com.home.henry.dp_06;

import java.util.List;

/**
 * 120. Triangle
 *
 * Given a triangle, find the minimum path sum from top to bottom. Each step you may move to adjacent numbers
 * on the row below.
 * For example, given the following triangle
 * [
 *      [2],
 *     [3,4],
 *    [6,5,7],
 *   [4,1,8,3]
 * ]
 * The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).
 *
 * dp[i][j] 表示从点 (i, j)(i,j) 到底边的最小路径和。
 * dp[i][j]=min(dp[i+1][j],dp[i+1][j+1])+triangle[i][j]
 * 因为计算 dp[i][j]dp[i][j] 时，只用到了下一行的 dp[i + 1][j]dp[i+1][j] 和 dp[i + 1][j + 1]dp[i+1][j+1]。
 * 因此 dp 数组不需要定义 N 行，只要定义 1 行就可以
 */
public class L120_Triangle_006 {

    public int minimumTotal(List<List<Integer>> triangle) {
        int[] A = new int[triangle.size() + 1];
        for (int i = triangle.size() - 1; i >= 0; i--) {
            for (int j = 0; j < triangle.get(i).size(); j++) {
                A[j] = Math.min(A[j], A[j + 1]) + triangle.get(i).get(j);
            }
        }
        return A[0];
    }

}
