package com.home.henry.math_03;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 15. 3Sum
 *
 * time: O(n^2) space: O(n)
 * Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]]
 * such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.
 * Notice that the solution set must not contain duplicate triplets.
 *
 * Input: nums = [-1,0,1,2,-1,-4] Output: [[-1,-1,2],[-1,0,1]]
 * Input: nums = [0,1,1] Output: []
 * Input: nums = [0,0,0] Output: [[0,0,0]]
 * 双指针, 要记注
 */
public class L015_ThreeSum_017 {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0) {return res;}
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {continue;}
            int low = i + 1, high = nums.length - 1;
            while (low < high) {
                if (nums[i] + nums[low] + nums[high] == 0) {
                    res.add(Stream.of(nums[low], nums[high], nums[i]).sorted().collect(Collectors.toList()));
                    while (low < high && nums[low] == nums[low + 1]) {low++;}
                    while (low < high && nums[high] == nums[high - 1]) {high--;}
                    low++;
                    high--;
                } else if (nums[i] + nums[low] + nums[high] < 0) {
                    low++;
                } else {
                    high--;
                }
            }
        }
        return res;
    }

    public List<List<Integer>> threeSumSet(int[] nums) {
        Set<List<Integer>> res = new HashSet<>();
        if (nums.length == 0) {return new ArrayList<>(res);}
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int j = i + 1;
            int k = nums.length - 1;
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if (sum == 0) {
                    res.add(Arrays.asList(nums[i], nums[j++], nums[k--]));
                } else if (sum > 0) {
                    k--;
                } else if (sum < 0) {
                    j++;
                }
            }

        }
        return new ArrayList<>(res);
    }
}
