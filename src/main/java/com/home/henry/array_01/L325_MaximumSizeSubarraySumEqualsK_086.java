package com.home.henry.array_01;

import java.util.HashMap;
import java.util.Map;

/**
 * 325. Maximum Size Subarray Sum Equals k
 * <p>
 * Given an integer array nums and an integer k, return the maximum length of a
 * subarray that sums to k. If there is not one, return 0 instead.
 * <p>
 * Input: nums = [1,-1,5,-2,3], k = 3 Output: 4
 * Explanation: The subarray [1, -1, 5, -2] sums to 3 and is the longest.
 * <p>
 * Input: nums = [-2,-1,2,1], k = 1 Output: 2
 * Explanation: The subarray [-1, 2] sums to 1 and is the longest.
 */
public class L325_MaximumSizeSubarraySumEqualsK_086 {
    public int maxSubArrayLen(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int sum = 0;
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (map.containsKey(sum - k)) {
                res = Math.max(res, i - map.get(sum - k));
            }
            map.putIfAbsent(sum, i);
        }
        return res;
    }
}
