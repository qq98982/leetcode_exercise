package com.home.henry.array_01;

/**
 * 188. Best Time to Buy and Sell Stock IV
 * 允许k次交易, 买卖最大利润是多少
 * 典型DP, 现在还没弄懂
 */
public class BestTimeToBuyAndSellStockIV_L188_025 {


    class Solution {
        public int maxProfit(int k, int[] prices) {
            int n = prices.length;

            if (k >= n / 2) {
                // 这种情况下该问题退化为普通的股票交易问题
                int maxProfit = 0;
                for (int i = 1; i < prices.length; i++) {
                    if (prices[i] > prices[i - 1]) {
                        maxProfit += (prices[i] - prices[i - 1]);
                    }
                }
                return maxProfit;
            }

            int[][] maxProfit = new int[k + 1][n];
            // localMax是上次(买入后)最大值, 加上这次的价格,合起来是这次的利润, 这个利润和这次不买的利润相比, 其最大值就是dp要记录的
            int localMax = Integer.MIN_VALUE;
            // i是外层循环, 代表买多少次
            for (int i = 1; i <= k; i++) {
                // j代表每次考虑价格, 算出利润最大值
                for (int j = 1; j < n; j++) {
                    // i-2次没有买, i-1次买了prices[j-1]的价格, max profit[i-1][j-1]+price[j-1]和以前的localMax相比
                    localMax = Math.max(localMax, maxProfit[i - 1][j - 1] - prices[j - 1]);
                    // i次卖price[j-1](现在不能卖了)和右边的卖了现在的相比,localMax也是滚动更新的
                    maxProfit[i][j] = Math.max(maxProfit[i][j - 1],  localMax + prices[j]);
                }
                localMax = Integer.MIN_VALUE;
            }
            return maxProfit[k][n - 1];
        }
    }
}
