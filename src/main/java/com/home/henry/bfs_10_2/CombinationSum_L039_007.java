package com.home.henry.bfs_10_2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 39. Combination Sum
 */
public class CombinationSum_L039_007 {
    static class Solution {
        public List<List<Integer>> combinationSum(int[] candidates, int target) {
            List<List<Integer>> res = new ArrayList<>();
            if (candidates == null) {return res;}
            Arrays.sort(candidates);
            helper(candidates, res, new ArrayList<>(), target, 0);
            return res;
        }

        private void helper(int[] candidates, List<List<Integer>> res, List<Integer> comb, int remainTarget,
                            int startIndex) {
            // exit
            if (remainTarget < 0) {
                return;
            }
            if (remainTarget == 0) {
                res.add(new ArrayList<>(comb));
                return;
            }
            for (int i = startIndex; i < candidates.length; i++) {
                if (i != 0 && candidates[i] == candidates[i - 1]) {
                    continue;
                }
                comb.add(candidates[i]);
                helper(candidates, res, comb, remainTarget - candidates[i], i);
                comb.remove(comb.size() - 1);
            }
        }
    }
}
