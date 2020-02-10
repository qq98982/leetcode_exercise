package com.home.henry.math_03;

import java.util.Arrays;

/**
 * 16. 3Sum Closest
 * Given an array nums of n integers and an integer target, find three integers in nums such that the sum is
 * closest to target. Return the sum of the three integers. You may assume that each input would have exactly one solution.
 *
 * Given array nums = 16. 3Sum Closest[-1, 2, 1, -4], and target = 1.
 * The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
 */
public class ThreeSumClosest_L016_016 {

    static class Solution {
        public int threeSumClosest(int[] nums, int target) {
            Arrays.sort(nums);
            int closet = Integer.MAX_VALUE;
            for (int i = 0; i < nums.length - 2; i++) {
                int low = i + 1, high = nums.length - 1;
                while (low < high) {
                    int diff = nums[i] + nums[low] + nums[high] - target;
                    if (diff == 0) {return target;}
                    if (Math.abs(diff) < Math.abs(closet)) {
                        closet = diff;
                    }
                    if (diff > 0) {
                        high--;
                    } else {
                        low++;
                    }
                }
            }
            return closet + target;
        }
    }
}
