package com.home.henry.array_01;

/**
 * 714. Best Time to Buy and Sell Stock with Transaction Fee
 * 需要交易费用的股票交易, 后一种方法使用的是和CD的思路相同, 容易理解
 */
public class L714_BestTimeToBuyAndSellStockWithTransactionFee_027 {
    class Solution {
        public int maxProfit(int[] prices, int fee) {
            int N = prices.length;
            int[] buy = new int[N];
            int[] b1 = new int[N];
            int[] sell = new int[N];
            int[] s1 = new int[N];
            b1[0] = buy[0] = -prices[0];
            sell[0] = s1[0] = 0;
            for (int i = 1; i < N; i++) {
                buy[i] = Math.max(sell[i - 1], s1[i - 1]) - prices[i];
                b1[i] = Math.max(buy[i - 1], b1[i - 1]);
                sell[i] = Math.max(buy[i - 1], b1[i - 1]) - fee + prices[i];
                s1[i] = Math.max(s1[i - 1], sell[i - 1]);
            }
            return Math.max(sell[N - 1], s1[N - 1]);
        }
    }

    private static class Solution2 {
        private static int maxProfit(int[] prices, int fee) {
            if (prices == null || prices.length == 0) {
                return 0;
            }
            int len = prices.length;
            int[] buy = new int[len + 1];
            int[] sell = new int[len + 1];
            buy[1] = -prices[0];
            for (int i = 1; i <= len; i++) {
                int price = prices[i - 1];
                buy[i] = Math.max(buy[i - 1], sell[i - 1] - price);
                sell[i] = Math.max(sell[i - 1], buy[i - 1] + price - fee);
            }
            return sell[len];
        }
    }

    public static void main(String[] args) {
        System.out.println(Solution2.maxProfit(new int[] { 1, 3, 2, 8, 4, 9 }, 2));
        System.out.println(Solution2.maxProfit(new int[] { 1, 4 }, 1));
        System.out.println(Solution2.maxProfit(new int[] { 1, 3 }, 2));
        System.out.println(Solution2.maxProfit(new int[] { 1, 1 }, 2));
        System.out.println(Solution2.maxProfit(new int[] { 1, 2 }, 2));
    }
}
