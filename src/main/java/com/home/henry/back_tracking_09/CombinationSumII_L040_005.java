package com.home.henry.back_tracking_09;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 40. Combination Sum II
 * Given a collection of candidate numbers (candidates) and a target number (target), find all unique combinations in candidates where the candidate numbers sums to target.
 * Each number in candidates may only be used once in the combination.
 * Note:
 * All numbers (including target) will be positive integers.
 * The solution set must not contain duplicate combinations.
 * Example 1:
 * Input: candidates = [10,1,2,7,6,1,5], target = 8,
 * A solution set is: [ [1, 7], [1, 2, 5], [2, 6], [1, 1, 6] ]
 * Example 2:
 * Input: candidates = [2,5,2,1,2], target = 5,
 * A solution set is: [ [1,2,2], [5] ]
 */
public class CombinationSumII_L040_005 {

    static class Solution {
        public List<List<Integer>> combinationSum2(int[] candidates, int target) {
            List<List<Integer>> res = new ArrayList<>();
            Arrays.sort(candidates);
            helper(res, new ArrayList<>(), candidates, target, 0);
            return res;
        }

        private void helper(List<List<Integer>> res, ArrayList<Integer> list, int[] nums, int target,
                            int index) {
            if (target < 0) {return;}
            if (target == 0) {
                res.add(new ArrayList<>(list));
            } else {
                for (int i = index; i < nums.length; i++) {
                    if (i != index && nums[i] == nums[i - 1]) {continue;}
                    list.add(nums[i]);
                    helper(res, list, nums, target - nums[i], i + 1);
                    list.remove(list.size() - 1);
                }
            }
        }
    }
}
