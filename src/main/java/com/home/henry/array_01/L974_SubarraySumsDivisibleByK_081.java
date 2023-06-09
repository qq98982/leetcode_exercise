package com.home.henry.array_01;

import java.util.HashMap;
import java.util.Map;

/**
 * 974. Subarray Sums Divisible by K
 *
 * Given an integer array nums and an integer k, return the number of non-empty subarrays that have a sum divisible by k.
 *
 * A subarray is a contiguous part of an array.
 *
 * Input: nums = [4,5,0,-2,-3,1], k = 5 Output: 7
 * Explanation: There are 7 subarrays with a sum divisible by k = 5:
 * [4, 5, 0, -2, -3, 1], [5], [5, 0], [5, 0, -2, -3], [0], [0, -2, -3], [-2, -3]
 *
 * Input: nums = [5], k = 9 Output: 0
 */
public class L974_SubarraySumsDivisibleByK_081 {
    public int subarraysDivByK(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int prefixSum = 0;
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            prefixSum = (prefixSum + nums[i]) % k;
            if (prefixSum < 0) {
                prefixSum += k;
            }
            if (map.containsKey(prefixSum)) {
                ans += map.get(prefixSum);
                map.put(prefixSum, map.get(prefixSum) + 1);
            } else {
                map.put(prefixSum, 1);
            }
        }
        return ans;
    }
}
