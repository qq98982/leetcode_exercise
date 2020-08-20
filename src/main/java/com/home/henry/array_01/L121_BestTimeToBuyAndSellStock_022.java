package com.home.henry.array_01;

/**
 * 121. Best Time to Buy and Sell Stock
 *
 * Say you have an array for which the ith element is the price of a given stock on day i.
 * If you were only permitted to complete at most one transaction (i.e., buy one and sell one share of the stock), design an algorithm to find the maximum profit.
 * Note that you cannot sell a stock before you buy one.
 *
 * Input: [7,1,5,3,6,4] Output: 5
 * Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
 *              Not 7-1 = 6, as selling price needs to be larger than buying price.
 *
 * Input: [7,6,4,3,1] Output: 0
 * Explanation: In this case, no transaction is done, i.e. max profit = 0.
 * 两种写法, 第一种要容易理解点
 */
public class L121_BestTimeToBuyAndSellStock_022 {
    class Solution {
        public int maxProfit(int[] prices) {
            if(prices == null || prices.length < 2) {
                return 0;
            }
            int max = 0;
            int currMax = 0;
            for (int i = 1; i < prices.length; i++) {
                currMax = Math.max(0, prices[i] - prices[i - 1] + currMax);
                max = Math.max(currMax, max);
            }
            return max;
        }
    }

    class SolutionSec {
        public int maxProfit(int[] prices) {
            int minPrice = Integer.MAX_VALUE;
            int maxProfit = 0;
            for (int i = 0; i < prices.length; i++) {
                if (prices[i] < minPrice) {
                    minPrice = prices[i];
                }
                if ((prices[i] - minPrice) > maxProfit) {
                    maxProfit = prices[i] - minPrice;
                }
            }
            return maxProfit;
        }
    }
}
