package com.home.henry.array_01;

/**
 * 122. Best Time to Buy and Sell Stock II
 * 贪记的做法, 将每步为正的profit加起来就可以
 * time O(n) space O(1)
 */
public class BestTimeToBuyAndSellStockII_L122_023 {

    class Solution {
        public int maxProfit(int[] prices) {
            if (prices == null || prices.length == 0) {return 0;}
            int profit = 0;
            for (int i = 1; i < prices.length; i++) {
                if (prices[i] > prices[i - 1]) {
                    profit += prices[i] - prices[i - 1];
                }
            }
            return profit;
        }
    }

}
