package com.home.henry.back_tracking_09;

import java.util.ArrayList;
import java.util.List;

/**
 * 46. Permutations
 Given a collection of distinct integers, return all possible permutations.
 Example:
 Input: [1,2,3]
 Output: [ [1,2,3], [1,3,2], [2,1,3], [2,3,1], [3,1,2], [3,2,1] ]
 */
public class Permutations_L046_007 {

    static class Solution {
        public List<List<Integer>> permute(int[] nums) {
            List<List<Integer>> res = new ArrayList<>();
            helper(res, new ArrayList<>(), nums);
            return res;
        }

        private void helper(List<List<Integer>> res, List<Integer> list, int[] nums) {
            if (list.size() == nums.length) {
                res.add(new ArrayList<>(list));
            } else {
                for (int i = 0; i < nums.length; i++) {
                    // element already exists, skip
                    if (list.contains(nums[i])) {continue;}
                    list.add(nums[i]);
                    helper(res, list, nums);
                    list.remove(list.size() - 1);
                }
            }

        }
    }
}
