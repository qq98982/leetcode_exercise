package com.home.henry.array_01;

/**
 * 121. Best Time to Buy and Sell Stock
 * 两种写法, 第一种要容易理解点
 */
public class BestTimeToBuyAndSellStock_L121_022 {
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
