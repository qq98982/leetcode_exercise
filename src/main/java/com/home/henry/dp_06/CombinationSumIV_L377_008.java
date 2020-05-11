package com.home.henry.dp_06;

/**
 * 377. Combination Sum IV
 *
 * Given an integer array with all positive numbers and no duplicates, find the number of possible combinations
 * that add up to a positive integer target.
 *
 * nums = [1, 2, 3]
 * target = 4
 *
 * The possible combination ways are:
 * (1, 1, 1, 1)
 * (1, 1, 2)
 * (1, 2, 1)
 * (1, 3)
 * (2, 1, 1)
 * (2, 2)
 * (3, 1)
 *
 * Note that different sequences are counted as different combinations.
 *
 * Therefore the output is 7.
 *
 * Follow up:
 * What if negative numbers are allowed in the given array?
 * How does it change the problem?
 * What limitation we need to add to the question to allow negative numbers?
 */
public class CombinationSumIV_L377_008 {

    // 解题思想有点像之前爬梯子的那道题 Climbing Stairs，这里需要一个一维数组 dp，其中 dp[i] 表示目标数为i的解的个数，
    // 然后从1遍历到 target，对于每一个数i，遍历 nums 数组，如果 i>=x, dp[i] += dp[i - x]。这个也很好理解，
    // 比如说对于 [1,2,3] 4，这个例子，当计算 dp[3] 的时候，3可以拆分为 1+x，而x即为 dp[2]，3也可以拆分为 2+x，
    // 此时x为 dp[1]，3同样可以拆为 3+x，此时x为 dp[0]，把所有的情况加起来就是组成3的所有情况了
    static class Solution {
        public static int combinationSum4(int[] nums, int target) {
            int[] dp = new int[target + 1];
            dp[0] = 1;
            for (int t = 1; t <= target; t++) {
                for (int num : nums) {
                    if (t >= num) {
                        dp[t] += dp[t - num];
                    }
                }
            }
            return dp[target];
        }
    }

    public static void main(String[] args) {
        System.out.println("7 -> " + Solution.combinationSum4(new int[] { 1, 2, 3 }, 4));
        System.out.println("39882198 -> " + Solution.combinationSum4(new int[] { 1, 2, 4 }, 32));
    }
}
