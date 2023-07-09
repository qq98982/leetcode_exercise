package com.home.henry.back_tracking_05;

import java.util.Arrays;

/**
 * 698. Partition to K Equal Sum Subsets
 *
 * Given an integer array nums and an integer k, return true if it is possible to divide this array into k non-empty subsets whose sums are all equal.
 *
 * Input: nums = [4,3,2,3,5,2,1], k = 4 Output: true
 * Explanation: It is possible to divide it into 4 subsets (5), (1, 4), (2,3), (2,3) with equal sums.
 *
 * Input: nums = [1,2,3,4], k = 3 Output: false
 */
public class L698_PartitionToKEqualSumSubsets_013 {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % k != 0 || nums.length < k) {return false;}
        // 排序后从最后一个值取
        Arrays.sort(nums);
        return canPartition(nums, sum / k, nums.length - 1, new int[k]);
    }

    boolean canPartition(int[] nums, int target, int i, int[] bucket) {
        // 已经找到所有的
        if (i == -1) {return true;}

        for (int k = 0; k < bucket.length; k++) {
            // 能否取这个值
            if (bucket[k] + nums[i] <= target) {
                // 如果取了这个值
                bucket[k] += nums[i];
                if (canPartition(nums, target, i - 1, bucket)) {
                    return true;
                }
                // 如果不能取上面这个值，需要还原回来
                bucket[k] -= nums[i];
            }
            // 取到任何值
            if (bucket[k] == 0) {
                break;
            }
        }
        // 1. bucket已经满了，但是i没有完，有数字剩余 2. 有bucket为空
        return false;
    }
}
