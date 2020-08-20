package com.home.henry.math_03;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 18. 4Sum
 *
 * Given an array nums of n integers and an integer target, are there elements a, b, c, and d in nums such that a + b + c + d = target? Find all unique quadruplets in the array which gives the sum of target.
 *
 * Note: The solution set must not contain duplicate quadruplets.
 *
 * Given array nums = [1, 0, -1, 0, -2, 2], and target = 0.
 *
 * A solution set is:
 * [
 *   [-1,  0, 0, 1],
 *   [-2, -1, 1, 2],
 *   [-2,  0, 0, 2]
 * ]
 */
public class L018_FourSum_018 {
    static class Solution {
        public List<List<Integer>> fourSum(int[] nums, int target) {
            List<List<Integer>> res = new ArrayList<>();
            if (nums == null || nums.length < 4) { return res; }
            // sort arrays
            Arrays.sort(nums);
            // if most big ones added less than target or most 4 small added is great than target, ignore
            if (nums[0] + nums[1] + nums[2] + nums[3] > target ||
                nums[nums.length - 1] + nums[nums.length - 2] + nums[nums.length - 3] + nums[nums.length - 4]
                < target) { return res; }
            int len_3 = nums.length - 3;
            int len_2 = nums.length - 2;
            int len_1 = nums.length - 1;
            // last_i is the last number of out loop and less than current loop's first one
            int last_i = nums[0] - 1;
            // first out loop is from 0 -> nums.length - 3
            for (int i = 0; i < len_3; i++) {
                // if new loop value is same as last i's value, ignore
                if (nums[i] == last_i) { continue; }
                last_i = nums[i];
                int last_j = last_i - 1;
                // last_j is less than last_i
                for (int j = i + 1; j < len_2; j++) {
                    // last_j is the same situation to last_i
                    if (nums[j] == last_j) { continue; }
                    last_j = nums[j];
                    // inner target is value that try to reach
                    int innerTarget = target - last_i - last_j;
                    // if first small two numbers and last big numbers out scope, ignore
                    if (nums[j + 1] + nums[j + 2] > innerTarget
                        || nums[nums.length - 1] + nums[nums.length - 2] < innerTarget) { continue; }
                    // inner loop from j + 1 -> nums.length - 1
                    int left = j + 1, right = len_1;
                    // inner loop is a while loop
                    while (left < right) {
                        int innerSum = nums[left] + nums[right];
                        if (innerSum == innerTarget) {
                            // reached and add to return list
                            res.add(Arrays.asList(last_i, last_j, nums[left], nums[right]));
                            left++;
                            right--;
                            // after index change, check if it is duplicate with old one
                            while (nums[left] == nums[left - 1] && left < right) { left++; }
                            while (nums[right] == nums[right + 1] && left < right) { right--; }
                        } else if (innerSum < innerTarget) {
                            // if inner sum less than target, point go to right
                            left++;
                        } else {
                            right--;
                        }
                    }
                }
            }

            return res;
        }
    }
}
