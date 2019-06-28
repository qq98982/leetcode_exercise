package com.home.henry.array_01;

/**
 * 309. Best Time to Buy and Sell Stock with Cooldown
 * 交易之后需要有一天的冷却时间, 这个问题还没有弄懂
 */
public class BestTimeToBuyAndSellStockWithCooldown_L309_026 {

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

}
