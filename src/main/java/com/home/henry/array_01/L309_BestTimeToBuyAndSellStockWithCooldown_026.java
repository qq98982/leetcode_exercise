package com.home.henry.array_01;

/**
 * 309. Best Time to Buy and Sell Stock with Cooldown
 *
 * Say you have an array for which the ith element is the price of a given stock on day i.
 *
 * Design an algorithm to find the maximum profit. You may complete as many transactions as you like (ie, buy one and
 * sell one share of the stock multiple times) with the following restrictions:
 *
 * You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
 * After you sell your stock, you cannot buy stock on next day. (ie, cooldown 1 day)
 *
 * Example: Input: [1,2,3,0,2] Output: 3
 * Explanation: transactions = [buy, sell, cooldown, buy, sell]
 *
 * 交易之后需要有一天的冷却时间, 后一个方法有详细解释
 */
public class L309_BestTimeToBuyAndSellStockWithCooldown_026 {

    class Solution {
        public int maxProfit(int[] prices) {
            if (prices == null || prices.length == 0) {return 0;}
            int N = prices.length;
            int[] buy = new int[N];
            int[] s1 = new int[N];
            int[] sell = new int[N];
            int[] s2 = new int[N];
            s1[0] = buy[0] = -prices[0];
            sell[0] = s2[0] = 0;
            for (int i = 1; i < N; i++) {
                buy[i] = s2[i - 1] - prices[i];
                s1[i] = Math.max(buy[i - 1], s1[i - 1]);
                sell[i] = Math.max(buy[i - 1], s1[i - 1]) + prices[i];
                s2[i] = Math.max(s2[i - 1], sell[i - 1]);
            }
            return Math.max(sell[N - 1], s2[N - 1]);
        }
    }

    /**
     * On any i-th day, we can buy, sell or cooldown
     *
     * buy[i]: The maximum profit can be made if the first i days end with buy or wait. E.g "buy, sell, buy" or "buy, cooldown, cooldown"
     * sell[i]: The maximum profit can be made if the first i days end with sell or wait. E.g "buy, sell, buy, sell" or "buy, sell, cooldown, cooldown"
     * price: prices[i - 1], which is the stock price of the i-th day
     *
     * To calculate sell[i]:
     * If we sell on the i-th day, the maximum profit is buy[i - 1] + price, because we have to buy before we can sell.
     * If we cooldown on the i-th day, the maximum profit is same as sell[i - 1] since we did not do anything on the i-th day.
     * So sell[i] is the larger one of (buy[i - 1] + price, sell[i - 1])
     *
     * To calculate buy[i]:
     * If we buy on the i-th day, the maximum profit is sell[i - 2] - price, because on the (i-1)th day we can only cooldown.
     * If we cooldown on the i-th day, the maximum profit is same as buy[i - 1] since we did not do anything on the i-th day.
     * So sell[i] is the larger one of (sell[i - 2] - price, buy[i - 1])
     */
    class Solution2 {

        public int maxProfit(int[] prices) {
            if (prices == null || prices.length == 0) {return 0;}
            int len = prices.length;
            int[] buy = new int[len + 1];
            int[] sell = new int[len + 1];
            buy[1] = -prices[0];
            for (int i = 2; i <= len; i++) {
                int price = prices[i - 1];
                buy[i] = Math.max(buy[i - 1], sell[i - 2] - price);
                sell[i] = Math.max(sell[i - 1], buy[i - 1] + price);
            }
            return sell[len];
        }
    }

}
