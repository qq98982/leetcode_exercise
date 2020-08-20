package com.home.henry.array_01;

/**
 * 188. Best Time to Buy and Sell Stock IV
 * 允许k次交易, 买卖最大利润是多少
 * 典型DP
 */
public class L188_BestTimeToBuyAndSellStockIV_025 {


    class Solution {
        public int maxProfit(int k, int[] prices) {
            int n = prices.length;

            if (k >= n / 2) {
                // 这种情况下该问题退化为普通的股票交易问题
                int total = 0;
                for (int i = 1; i < prices.length; i++) {
                    if (prices[i] > prices[i - 1]) {
                        total += prices[i] - prices[i - 1];
                    }
                }
                return total;
            }

            int[][] dp = new int[k + 1][n];
            // i是外层循环, 代表总共(买+卖)/2多少次交易
            for (int i = 1; i <= k; i++) {
                // tmpMax(买入后)最大值. 第一次是买入0的价格
                int tmpMax = -prices[0];
                // j代表每次考虑价格, 算出利润最大值
                for (int j = 1; j < n; j++) {
                    // i次卖price[j-1](现在不能卖了)和右边的卖了现在的相比,tmpMax也是滚动更新的
                    // 上次(买入后)最大值加上这次的价格,合起来就是这次的利润, 这个利润和这次什么都不做的利润相比, 其最大值就是dp要记录的
                    dp[i][j] = Math.max(dp[i][j - 1],  tmpMax + prices[j]);
                    tmpMax = Math.max(tmpMax, dp[i - 1][j - 1] - prices[j]);
                }
            }
            return dp[k][n - 1];
        }
    }
}
