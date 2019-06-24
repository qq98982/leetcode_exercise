package com.home.henry.dp_06;

/**
 * 322. Coin Change
 * You are given coins of different denominations and a total amount of money amount. Write a function to
 * compute the fewest number of coins that you need to make up that amount. If that amount of money cannot
 * be made up by any combination of the coins, return -1.
 * Example 1: Input: coins = [1, 2, 5], amount = 11 Output: 3
 * Explanation: 11 = 5 + 5 + 1 Example 2: Input: coins = [2], amount = 3 Output: -1
 */
public class CoinChange_322_014 {

    public int coinChange(int[] coins, int amount) {
        int[] f = new int[amount + 1];
        f[0] = 0;
        int n = coins.length;
        int i, j;
        for (i = 1; i <= amount; i++) {
            f[i] = Integer.MAX_VALUE;
            for (j = 0; j < n; j++) {
                if (i >= coins[j] && f[i - coins[j]] != Integer.MAX_VALUE) {
                    f[i] = Math.min(f[i - coins[j]] + 1, f[i]);
                }
            }
        }
        if (f[amount] == Integer.MAX_VALUE) {
            return -1;
        }
        return f[amount];
    }

}
