package com.home.henry.back_tracking_05;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 40. Combination Sum II
 *
 * Given a collection of candidate numbers (candidates) and a target number (target), find all unique
 * combinations in candidates where the candidate numbers sums to target.
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
public class L040_CombinationSumII_005 {

    // 为了解决重复的情况，我们可以先把数组先排序, 其他和39一样
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
                    //跳过重复的数字
                    if (i != index && nums[i] == nums[i - 1]) {continue;}
                    list.add(nums[i]);
                    //i -> i + 1 ，因为每个数字只能用一次，所以下次遍历的时候不从自己开始
                    helper(res, list, nums, target - nums[i], i + 1);
                    list.remove(list.size() - 1);
                }
            }
        }
    }
}
