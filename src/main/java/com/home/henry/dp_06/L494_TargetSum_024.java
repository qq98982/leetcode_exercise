package com.home.henry.dp_06;

/**
 * 494. Target Sum
 *
 * You are given an integer array nums and an integer target.
 *
 * You want to build an expression out of nums by adding one of the symbols '+' and '-' before each integer in nums and then concatenate all the integers.
 *
 * For example, if nums = [2, 1], you can add a '+' before 2 and a '-' before 1 and concatenate them to build the expression "+2-1".
 * Return the number of different expressions that you can build, which evaluates to target.
 *
 * Input: nums = [1,1,1,1,1], target = 3 Output: 5
 *
 * Input: nums = [1], target = 1 Output: 1
 */
public class L494_TargetSum_024 {

    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        // 表达式结果为target 那么就一定有 left组合-right组合=target
        // left+right=sum left-target=right left=sum-right=sum-left+target 2left=sum+target
        // left=(sum+target)/2
        if ((sum - target) % 2 == 1) {return 0;}
        // 如果target过大 sum将无法满足
        if (Math.abs(target) > sum) {return 0;}
        // 问题转化为，装满容量为x的背包，有几种方法
        int size = (sum + target) / 2;
        if (size < 0) {
            size = -size;
        }
        int[] dp = new int[size + 1];
        dp[0] = 1;
        for (int i = 0; i < nums.length; i++) {
            for (int j = size; j >= nums[i]; j--) {
                dp[j] += dp[j - nums[i]];
            }
        }
        return dp[size];
    }
}
