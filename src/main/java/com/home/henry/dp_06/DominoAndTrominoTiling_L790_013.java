package com.home.henry.dp_06;

/**
 *790. Domino and Tromino Tiling
 We have two types of tiles: a 2x1 domino shape, and an "L" tromino shape. These shapes may be rotated.
 XX  <- domino XX  <- "L" tromino
 X
 Given N, how many ways are there to tile a 2 x N board? Return your answer modulo 10^9 + 7.
 (In a tiling, every square must be covered by a tile. Two tilings are different if and only if there are two
 4-directionally adjacent cells on the board such that exactly one of the tilings has both squares occupied by a tile.)
 Example:
 Input: 3 Output: 5 Explanation:
 The five different ways are listed below, different letters indicates different tiles:
 XYZ XXZ XYY XXY XYY
 XYZ YYZ XZZ XYY XXY
 */
public class DominoAndTrominoTiling_L790_013 {

    static class Solution {
        /**
         * 简化的类似问题, 用一种直条型覆盖
         */
        public int numTilingsSimple(int N) {
            int first = 1, second = 1, sum = 0;
            for (int i = 1; i < N * 2; i++) {
                sum = (first + second);
                first = second;
                second = sum;
            }
            return sum;
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.numTilingsSimple(2));
    }

    /**
     * dp[i][0] = dp[i-1][0] + dp[i-2][0] + dp[i-1][1] + dp[i-1][2]
     * dp[i][1] = dp[i-2][0] + dp[i-1][2]
     * dp[i][2] = dp[i-2][0] + dp[i-1][1]
     *
     * final because dp[i][1] = dp[i][2]
     * dp[i][0] = dp[i-1][0] + dp[i-2][0] + 2 * dp[i-1][1]
     * dp[i][1] = dp[i-2][0] + dp[i-1][1]
     */
    public int numTilings(int N) {
        int kMod = 1000000007;
        long[][] dp = new long[N + 1][3];
        dp[0][0] = 1;
        dp[1][0] = 1;
        for (int i = 2; i <= N; i++) {
            dp[i][0] = (dp[i - 1][0] + dp[i - 2][0] + 2 * dp[i - 1][1]) % kMod;
            dp[i][1] = (dp[i - 2][0] + dp[i - 1][1]) % kMod;
        }
        return (int) (dp[N][0] % kMod);
    }

    /**
     * when N==0, we need return 0, but in dp , we need make dp[0]=1 for easy to construct formula
     * dp[n]=dp[n-1]+dp[n-2]+ 2*(dp[n-3]+...+d[0])
     * =dp[n-1]+dp[n-2]+dp[n-3]+dp[n-3]+2*(dp[n-4]+...+d[0])
     * =dp[n-1]+dp[n-3]+(dp[n-2]+dp[n-3]+2*(dp[n-4]+...+d[0]))
     * =dp[n-1]+dp[n-3]+dp[n-1]
     * =2*dp[n-1]+dp[n-3]
     */
    private static final int MOD = 1000000007;

    public int numTilingsAnotherVersion(int N) {
        if (N == 1) { return 1; }
        if (N == 2) { return 2; }
        long[] dp = new long[N + 1];
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= N; i++) {
            dp[i] = (dp[i - 1] * 2 + dp[i - 3]) % MOD;
        }
        return (int) dp[N];
    }
}