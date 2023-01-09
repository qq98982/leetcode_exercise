package com.home.henry.dp_06;

/**
 * 256.Paint-House
 *
 * There are a row of n houses, each house can be painted with one of the three colors: red, blue or green. The cost of painting each house with a certain color is different. You have to paint all the houses such that no two adjacent houses have the same color.
 * The cost of painting each house with a certain color is represented by a n x 3 cost matrix. For example, costs[0][0] is the cost of painting house 0 with color red; costs[1][2] is the cost of painting house 1 with color green, and so on... Find the minimum cost to paint all houses.
 * Note:
 * All costs are positive integers.
 *
 * Input: [[17,2,17],[16,16,5],[14,3,19]] Output: 10
 * Explanation: Paint house 0 into blue, paint house 1 into green, paint house 2 into blue.
 *              Minimum cost: 2 + 5 + 3 = 10.
 * 状态方程: f[i][0] = min{f[i-1][1] + cost[i-1][0], f[i-1][2] + cost[i-1][0]}
 * 油漆前i栋房子 并且第i-1栋颜色为0 最小花费 ->  min(油漆前i-1栋房子并且最后一个的颜色为1 + 第i-1栋颜色为0
 *                                            油漆前i-1栋房子并且最后一个的颜色为2 + 第i-1栋颜色为0)
 * 序列型动态规划
 *
 * https://github.com/grandyang/leetcode/issues/256
 * 这道题说有n个房子，每个房子可以用红绿蓝三种颜色刷，每个房子的用每种颜色刷的花费都不同，限制条件是相邻的房子不能用相同
 * 的颜色来刷，现在让求刷完所有的房子的最低花费是多少。这题跟 House Robber II 和 House Robber 很类似，不过那题不是
 * 每个房子都抢，相邻的房子不抢，而这道题是每个房子都刷，相邻的房子不能刷同一种颜色，而 Paint Fence 那道题主要考察有多
 * 少种刷法。这几道题很类似，但都不一样，需要分别区分。但是它们的解题思想都一样，需要用动态规划 Dynamic Programming
 * 来做，这道题需要维护一个二维的动态数组 dp，其中 dp[i][j] 表示刷到第 i+1 房子用颜色j的最小花费，状态转移方程为:
 * dp[i][j] = dp[i][j] + min(dp[i - 1][(j + 1) % 3], dp[i - 1][(j + 2) % 3])；
 * 这个也比较好理解，如果当前的房子要用红色刷，则上一个房子只能用绿色或蓝色来刷，那么要求刷到当前房子，且当前房子用红色
 * 刷的最小花费就等于当前房子用红色刷的钱加上刷到上一个房子用绿色和刷到上一个房子用蓝色中的较小值，这样当算到最后一个
 * 房子时，只要取出三个累计花费的最小值即可
 *
 * https://wentao-shao.gitbook.io/leetcode/dynamic-programming/1.position/256.paint-house
 * 题解里使用的是min(dp[n-1][0],dp[n-1][1],dp[n-1][2])
 */
public class L256_Paint_House_020 {
    public static class Solution {
        public static int minCost(int[][] costs) {
            if (costs == null || costs.length == 0) { return 0; }
            int n = costs.length;
            int[][] dp = new int[n][3];

            dp[0][0] = costs[0][0];
            dp[0][1] = costs[0][1];
            dp[0][2] = costs[0][2];

            for (int i = 1; i < n; i++) {
                dp[i][0] = Math.min(dp[i - 1][1], dp[i - 1][2]) + costs[i][0];
                dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][2]) + costs[i][1];
                dp[i][2] = Math.min(dp[i - 1][0], dp[i - 1][1]) + costs[i][2];
            }

            return Math.min(dp[n - 1][0],
                            Math.min(dp[n - 1][1], dp[n - 1][2]));
        }
    }
}
