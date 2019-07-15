package com.home.henry.back_tracking_05;

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
            helper(res, new ArrayList<>(), nums, new boolean[nums.length]);
            return res;
        }

        private void helper(List<List<Integer>> res, List<Integer> list, int[] nums, boolean[] used) {
            if (list.size() == nums.length) {
                res.add(new ArrayList<>(list));
                return;
            }
            for (int i = 0; i < nums.length; i++) {
                if (used[i] || i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) {continue;}
                used[i] = true;
                list.add(nums[i]);
                helper(res, list, nums, used);
                used[i] = false;
                list.remove(list.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.permuteUnique(new int[] { 1, 2, 1,2,1 }));
    }
}
