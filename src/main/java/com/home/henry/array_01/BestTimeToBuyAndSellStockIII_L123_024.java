package com.home.henry.array_01;

/**
 * 123. Best Time to Buy and Sell Stock III
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
