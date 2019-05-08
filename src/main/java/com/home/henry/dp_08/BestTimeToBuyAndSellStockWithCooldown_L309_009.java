package com.home.henry.dp_08;

/**
 * 309. Best Time to Buy and Sell Stock with Cooldown
 */
public class BestTimeToBuyAndSellStockWithCooldown_L309_009 {

    /**
     * hold[i] = max(hold[i-1], rest[i-1] - price[i])
     * sold[i] = hold[i-1] + prices[i]
     * rest[i] = max(rest[i-1], sold[i-1])
     * init rest[0] = sold[0] = 0, hold[0] = -limit
     * ans: max(rest[i], sold[i])
     */
    static class Solution {
        public int maxProfit(int[] prices) {
            int sold = 0;
            int rest = 0;
            int hold = Integer.MIN_VALUE;
            for (int price : prices) {
                int prevSold = sold;
                sold = hold + price;
                hold = Math.max(hold, rest - price);
                rest = Math.max(rest, prevSold);
            }
            return Math.max(hold, sold);
        }

        public int maxProfitBetter(int[] prices) {
            int sell = 0, prev_sell = 0, buy = Integer.MIN_VALUE, prev_buy;
            for (int price : prices) {
                prev_buy = buy;
                buy = Math.max(prev_sell - price, prev_buy);
                prev_sell = sell;
                sell = Math.max(prev_buy + price, prev_sell);
            }
            return sell;
        }
    }
}
