package com.home.henry.array_01;

/**
 * 714. Best Time to Buy and Sell Stock with Transaction Fee
 * 需要交易费用的股票交易, 目前还没有弄懂
 */
public class BestTimeToBuyAndSellStockWithTransactionFee_L714_027 {
    class Solution {
        public int maxProfit(int[] prices, int fee) {
            int N = prices.length;
            int[] buy = new int[N];
            int[] s1 = new int[N];
            int[] sell = new int[N];
            int[] s2 = new int[N];
            s1[0] = buy[0] = -prices[0];
            sell[0] = s2[0] = 0;
            for (int i = 1; i < N; i++) {
                buy[i] = Math.max(sell[i - 1], s2[i - 1]) - prices[i];
                s1[i] = Math.max(buy[i - 1], s1[i - 1]);
                sell[i] = Math.max(buy[i - 1], s1[i - 1]) - fee + prices[i];
                s2[i] = Math.max(s2[i - 1], sell[i - 1]);
            }
            return Math.max(sell[N - 1], s2[N - 1]);
        }
    }
}
