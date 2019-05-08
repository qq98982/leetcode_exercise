package com.home.henry.back_tracking_09;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 47. Permutations II
 * Given a collection of numbers that might contain duplicates, return all possible unique permutations.
 * Example: Input: [1,1,2] Output: [ [1,1,2], [1,2,1], [2,1,1] ]
 */
public class PermutationsII_L047_008 {
    static class Solution {
        public List<List<Integer>> permuteUnique(int[] nums) {
            List<List<Integer>> res = new ArrayList<>();
            Arrays.sort(nums);
            helper(res, new ArrayList<>(), nums);
            return res;
        }

        private void helper(List<List<Integer>> res, ArrayList<Integer> list, int[] nums) {
            if (list.size() == nums.length) {
                res.add(new ArrayList<Integer>(list));
            }
            for (int i = 0; i < nums.length; i++) {
                if (i > 0 && nums[i] == nums[i - 1]) {continue;}
                list.add(nums[i]);
                helper(res, list, nums);
                list.remove(list.size() - 1);
            }
        }
    }
}
