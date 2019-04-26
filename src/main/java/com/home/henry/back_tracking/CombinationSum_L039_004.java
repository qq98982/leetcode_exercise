package com.home.henry.back_tracking;

import java.util.ArrayList;
import java.util.List;

/**
 * 39. Combination Sum
 * Given a set of candidate numbers (candidates) (without duplicates) and a target number (target), find all unique combinations in candidates where the candidate numbers sums to target.
 * The same repeated number may be chosen from candidates unlimited number of times.
 * Note: All numbers (including target) will be positive integers.
 * Example 1:
 * Input: candidates = [2,3,6,7], target = 7,
 * A solution set is: [ [7], [2,2,3] ]
 * Example 2:
 * Input: candidates = [2,3,5], target = 8, A solution set is:
 * [ [2,2,2,2], [2,3,3], [3,5] ]
 *
 * NOTE: not i + 1 because we can reuse same elements !!!
 */
public class CombinationSum_L039_004 {

    static class Solution {
        public List<List<Integer>> combinationSum(int[] candidates, int target) {
            List<List<Integer>> res = new ArrayList<>();
            helper(res, new ArrayList<>(), candidates, target, 0);
            return res;
        }

        private void helper(List<List<Integer>> res, ArrayList<Integer> list, int[] candidates, int target,
                            int index) {
            if (target < 0) {
                return;
            } else if (target == 0){
                res.add(new ArrayList<>(list));
            } else {
                for (int i = index; i < candidates.length; i++ ) {
                    list.add(candidates[i]);
                    helper(res, list, candidates, target - candidates[i], i);
                    list.remove(list.size() - 1);
                }
            }
        }
    }
}
