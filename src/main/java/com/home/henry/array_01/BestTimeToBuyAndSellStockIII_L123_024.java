package com.home.henry.array_01;

/**
 * 123. Best Time to Buy and Sell Stock III
 *
 * Say you have an array for which the ith element is the price of a given stock on day i.
 * Design an algorithm to find the maximum profit. You may complete at most two transactions.
 *
 * Note: You may not engage in multiple transactions at the same time (i.e., you must sell the stock before you buy again).
 *
 * Input: [3,3,5,0,0,3,1,4] Output: 6
 * Explanation: Buy on day 4 (price = 0) and sell on day 6 (price = 3), profit = 3-0 = 3.
 *              Then buy on day 7 (price = 1) and sell on day 8 (price = 4), profit = 4-1 = 3.
 *
 * Input: [1,2,3,4,5] Output: 4
 * Explanation: Buy on day 1 (price = 1) and sell on day 5 (price = 5), profit = 5-1 = 4.
 *              Note that you cannot buy on day 1, buy on day 2 and sell them later, as you are
 *              engaging multiple transactions at the same time. You must sell before buying again.
 *
 * DP O(n) 的解法, 不太容易懂
 * 其他地方的写法不推荐, 这个写法命名更容易理解点
 */
public class BestTimeToBuyAndSellStockIII_L123_024 {

    static class Solution {
        public int maxProfit(int[] prices) {
            int buyOne = Integer.MAX_VALUE;
            int sellOne = 0;
            int buyTwo = Integer.MAX_VALUE;
            int sellTwo = 0;
            for (int p : prices) {
                buyOne = Math.min(buyOne, p);
                sellOne = Math.max(sellOne, p - buyOne);
                buyTwo = Math.min(buyTwo, p - sellOne);
                sellTwo = Math.max(sellTwo, p - buyTwo);
            }
            return sellTwo;
        }
    }
}
