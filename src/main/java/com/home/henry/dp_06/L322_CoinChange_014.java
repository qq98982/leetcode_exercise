package com.home.henry.dp_06;

/**
 * 322. Coin Change
 * You are given coins of different denominations and a total amount of money amount. Write a function to
 * compute the fewest number of coins that you need to make up that amount. If that amount of money cannot
 * be made up by any combination of the coins, return -1.
 * Example 1: Input: coins = [1, 2, 5], amount = 11 Output: 3
 * Explanation: 11 = 5 + 5 + 1 Example 2: Input: coins = [2], amount = 3 Output: -1
 */
public class L322_CoinChange_014 {

    public int coinChange(int[] coins, int amount) {
        int[] f = new int[amount + 1];
        // 边界条件
        f[0] = 0;
        int n = coins.length;
        int amountNum ;
        for (amountNum = 1; amountNum <= amount; amountNum++) {
            f[amountNum] = Integer.MAX_VALUE;
            // 去算每个硬币
            for (int singleCoin = 0; singleCoin < n; singleCoin++) {
                // 如果可以拼出来(!= Integer.MAX_VALUE),前面的条件可以看做是不越界
                if (amountNum >= coins[singleCoin] && f[amountNum - coins[singleCoin]] != Integer.MAX_VALUE) {
                    f[amountNum] = Math.min(f[amountNum - coins[singleCoin]] + 1, f[amountNum]);
                }
            }
        }
        if (f[amount] == Integer.MAX_VALUE) {
            return -1;
        }
        return f[amount];
    }

}
