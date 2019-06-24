package com.home.henry.back_tracking_05;

import java.util.ArrayList;
import java.util.List;

/**
 * 77. Combinations
 * Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.
 * Example:
 * Input: n = 4, k = 2
 * Output: [ [2,4], [3,4], [2,3], [1,2], [1,3], [1,4], ]
 * Notice it from 1 to n
 */
public class Combinations_L077_003 {

    static class Solution {
        public List<List<Integer>> combine(int n, int k) {
            List<List<Integer>> res = new ArrayList<>();
            helper(res, new ArrayList<>(), n, k, 1);
            return res;
        }

        private void helper(List<List<Integer>> res, ArrayList<Integer> list, int n, int k, int start) {
            if (k == 0) {
                res.add(new ArrayList<>(list));
                return;
            }
            for (int i = start; i <= n; i++) {
                list.add(i);
                helper(res, list, n, k - 1, i + 1);
                list.remove(list.size() - 1);
            }
        }
    }
}
