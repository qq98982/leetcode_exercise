package com.home.henry.others.alg1.week1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 15. 3Sum
 * time: O(n^2) space: O(n)
 * Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0?
 * Find all unique triplets in the array which gives the sum of zero.
 * The solution set must not contain duplicate triplets.
 *
 * Given array nums = [-1, 0, 1, 2, -1, -4], Answer -> [ [-1, 0, 1], [-1, -1, 2] ]
 * 第一个用的是双指针, 要记注
 * 第二个方法用的是set, 也是双指针, 可以参考
 */
public class ThreeSum_L015 {
    static class Solutoin {
        public List<List<Integer>> threeSum(int[] nums) {
            List<List<Integer>> res = new ArrayList<>();
            if (nums == null || nums.length == 0) { return res;}
            Arrays.sort(nums);
            for (int i = 0; i < nums.length - 2; i++) {
                if (i > 0 && nums[i] == nums[i - 1]) {continue;}
                int low = i + 1, high = nums.length - 1, sum = 0 - nums[i];
                while (low < high) {
                    if (nums[low] + nums[high] == sum) {
                        res.add(Arrays.asList(nums[low], nums[high], nums[i]));
                        while (low < high && nums[low] == nums[low + 1]) { low++;}
                        while (low < high && nums[high] == nums[high - 1]) {high--;}
                        low++;
                        high--;
                    } else if (nums[low] + nums[high] < sum) {
                        low++;
                    } else {
                        high--;
                    }
                }
            }
            return res;
        }
    }

    static class SolutoinSet {
        public List<List<Integer>> threeSum(int[] nums) {
            Set<List<Integer>> res = new HashSet<>();
            if (nums == null || nums.length == 0) { return new ArrayList<>(res);}
            Arrays.sort(nums);
            for (int i = 0; i < nums.length - 2; i++) {
                if (i > 0 && nums[i] == nums[i - 1]) {continue;}
                int low = i + 1, high = nums.length - 1;
                while (low < high) {
                    int sum = nums[i] + nums[low] + nums[high];
                    if (sum == 0) {
                        res.add(Arrays.asList(nums[i], nums[low], nums[high]));
                    } else if (sum > 0) {
                        high--;
                    } else {
                        low++;
                    }
                }
            }
            return new ArrayList<>(res);
        }
    }
}
