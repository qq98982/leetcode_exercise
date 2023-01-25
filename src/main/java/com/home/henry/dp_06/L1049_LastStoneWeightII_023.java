package com.home.henry.dp_06;

/**
 * 1049. Last Stone Weight II
 *
 * You are given an array of integers stones where stones[i] is the weight of the ith stone.
 *
 * We are playing a game with the stones. On each turn, we choose any two stones and smash them together.
 * Suppose the stones have weights x and y with x <= y. The result of this smash is:
 *
 * If x == y, both stones are destroyed, and
 * If x != y, the stone of weight x is destroyed, and the stone of weight y has new weight y - x.
 * At the end of the game, there is at most one stone left.
 *
 * Return the smallest possible weight of the left stone. If there are no stones left, return 0.
 *
 * Input: stones = [2,7,4,1,8,1] Output: 1
 * Explanation:
 * We can combine 2 and 4 to get 2, so the array converts to [2,7,1,8,1] then,
 * we can combine 7 and 8 to get 1, so the array converts to [2,1,1,1] then,
 * we can combine 2 and 1 to get 1, so the array converts to [1,1,1] then,
 * we can combine 1 and 1 to get 0, so the array converts to [1], then that's the optimal value.
 *
 * Input: stones = [31,26,33,21,40] Output: 5
 */
public class L1049_LastStoneWeightII_023 {

    /**
     * 尽量让石头分成重量相同的两堆，相撞之后剩下的石头最小，这样就化解成01背包问题
     * 时间复杂度：O(m × n) , m是石头总重量（准确的说是总重量的一半），n为石头块数 空间复杂度：O(m)
     */
    public int lastStoneWeightII(int[] stones) {
        int sum = 0;
        for (int s : stones) {
            sum += s;
        }
        /*
         一堆石头的总重量是dp[target]，另一堆就是sum - dp[target]
         target = sum / 2 因为是向下取整，所以sum - dp[target] 一定是大于等于dp[target]
         那么相撞之后剩下的最小石头重量就是 (sum - dp[target]) - dp[target]
         */
        int target = sum / 2;
        int[] dp = new int[target + 1];
        for (int i = 0; i < stones.length; i++) {
            for (int j = target; j >= stones[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j - stones[i]] + stones[i]);
            }
        }
        return sum - 2 * dp[target];
    }
}
