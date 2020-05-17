package com.home.henry.dfs_10_1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 40. Combination Sum II
 */
public class CombinationSumII_L040_008 {

    static class Solution {
        public List<List<Integer>> combinationSum2(int[] candidates, int target) {
            List<List<Integer>> res = new ArrayList<>();
            if (candidates == null || candidates.length == 0) {return res;}
            Arrays.sort(candidates);
            List<Integer> comb = new ArrayList<>();
            helper(res, candidates, comb, target, 0);
            return res;
        }

        private void helper(List<List<Integer>> res, int[] candidates, List<Integer> comb, int target,
                            int startIndex) {
            if (target < 0) {
                return;
            }
            if (target == 0) {
                res.add(new ArrayList<>(comb));
                return;
            }
            for (int i = startIndex; i < candidates.length; i++) {
                // 如果不是从startIndex开始的, 如果是从后面开始的重复的数字, 就跳过
                // 这个地方是这个题目的重点关注
                if (i != startIndex && candidates[i] == candidates[i - 1]) {
                    continue;
                }
                comb.add(candidates[i]);
                helper(res, candidates, comb, target - candidates[i], startIndex + 1);
                comb.remove(comb.size() - 1);
            }
        }

    }
}
