package com.home.henry.back_tracking_05;

import java.util.ArrayList;
import java.util.List;

/**
 * 216. Combination Sum III
 *
 * Find all possible combinations of k numbers that add up to a number n, given that only numbers from 1 to 9 can be used and each combination should be a unique set of numbers.
 *
 * Note:
 *
 * All numbers will be positive integers.
 * The solution set must not contain duplicate combinations.
 * Example 1:
 *
 * Input: k = 3, n = 7
 * Output: [[1,2,4]]
 * Example 2:
 *
 * Input: k = 3, n = 9
 * Output: [[1,2,6], [1,3,5], [2,3,4]]
 */
public class CombinationSumIII_L216_006 {

    static class Solution {
        public List<List<Integer>> combinationSum3(int k, int n) {
            List<List<Integer>> res = new ArrayList<>();
            helper(res, new ArrayList<>(), k, n, 1);
            return res;
        }

        private void helper(List<List<Integer>> res, List<Integer> list, int k, int n, int start) {
            if (k < 0 || n < 0) {return;}
            if (k == 0 && n == 0) {
                res.add(new ArrayList<>(list));
            } else {
                for (int i = start; i <= 9; i++) {
                    list.add(i);
                    helper(res, list, k - 1, n - i, i + 1);
                    list.remove(list.size() - 1);
                }
            }
        }
    }
}
