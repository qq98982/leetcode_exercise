package com.home.henry.dp_06;

/**
 * 416. Partition Equal Subset Sum
 *
 * Given an integer array nums, return true if you can partition the array into two subsets such that the sum of the elements in both subsets is equal or false otherwise.
 *
 * Input: nums = [1,5,11,5] Output: true
 * Explanation: The array can be partitioned as [1, 5, 5] and [11].
 *
 * Input: nums = [1,2,3,5] Output: false
 * Explanation: The array cannot be partitioned into equal sum subsets.
 */
public class L416_PartitionEqualSubsetSum_022 {
    /**
     * 01背包 物品是nums[i]，重量是nums[i]，价值也是nums[i] 背包体积是sum/2
     */
    public boolean canPartition(int[] nums) {
        if (nums == null || nums.length == 0) {return false;}
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % 2 == 1) {return false;}
        int target = sum / 2;
        int[] dp = new int[target + 1];
        dp[0] = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = target; j >= nums[i]; j--) {
                // 物品 i 的重量是 nums[i]，其价值也是 nums[i]
                if (j >= nums[i]) {
                    dp[j] = Math.max(dp[j], dp[j - nums[i]] + nums[i]);
                }
            }
        }
        return dp[target] == target;
    }
}
