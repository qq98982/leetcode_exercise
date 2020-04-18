package com.home.henry.array_01;

import java.util.HashMap;
import java.util.Map;

/**
 * 325. Maximum Size Subarray Sum Equals k
 *
 * Given an array nums and a target value k, find the maximum length of a subarray that sums to k.
 * If there isn't one, return 0 instead.
 * The sum of the entire nums array is guaranteed to fit within the 32-bit signed integer range.
 * Given nums = [1, -1, 5, -2, 3], k = 3,
 * return 4. (because the subarray [1, -1, 5, -2] sums to 3 and is the longest)
 */
public class MaximumSizeSubarraySumEqualsK_L325_048_4 {
    static class Solution {
        public int maxSubArrayEqualsK(int[] nums, int k) {
            if (nums == null || nums.length == 0) {return 0;}
            int sum = 0;
            int res = Integer.MIN_VALUE;
            Map<Integer, Integer> map = new HashMap<>();
            map.put(0, -1);
            for (int i = 0; i < nums.length; i++) {
                sum += nums[i];
                if (map.containsKey(sum - k)) {
                    res = Math.max(res, i - map.get(sum - k));
                }
                map.putIfAbsent(sum, i);
            }
            return res == Integer.MIN_VALUE ? 0 : res;
        }
    }
}
