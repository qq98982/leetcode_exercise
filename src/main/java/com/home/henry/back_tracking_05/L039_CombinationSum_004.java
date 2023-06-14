package com.home.henry.back_tracking_05;

import java.util.ArrayList;
import java.util.List;

/**
 * 39. Combination Sum
 *
 * Given a set of candidate numbers (candidates) (without duplicates) and a target number (target), find all unique combinations in candidates where the candidate numbers sums to target.
 * The same repeated number may be chosen from candidates unlimited number of times.
 * Note: All numbers (including target) will be positive integers.
 * Input: candidates = [2,3,6,7], target = 7,
 * A solution set is: [ [7], [2,2,3] ]
 * Input: candidates = [2,3,5], target = 8, A solution set is:
 * [ [2,2,2,2], [2,3,3], [3,5] ]
 *
 * NOTE: not i + 1 because we can reuse same elements !!!
 *
 * 就是先向前列举所有情况，得到一个解或者走不通的时候就回溯。和37题有异曲同工之处，也算是回溯法很典型的应用
 * dp解法可以参考 https://leetcode.wang/leetCode-39-Combination-Sum.html#%E9%A2%98%E7%9B%AE%E6%8F%8F%E8%BF%B0%EF%BC%88%E4%B8%AD%E7%AD%89%E9%9A%BE%E5%BA%A6%EF%BC%89
 */
public class L039_CombinationSum_004 {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        helper(res, new ArrayList<>(), candidates, target, 0);
        return res;
    }

    private void helper(List<List<Integer>> res, List<Integer> list, int[] candi, int remain, int start) {
        if (remain < 0) {
            return;
        } else if (remain == 0) {
            res.add(new ArrayList<Integer>(list));
            return;
        }
        for (int i = start; i < candi.length; i++) {
            list.add(candi[i]);
            helper(res, list, candi, remain - candi[i], i);
            //找到了一个解或者 remain < 0 了，将当前数字移除，然后继续尝试
            list.remove(list.size() - 1);
        }
    }
}
