package com.home.henry.back_tracking_09;

import java.util.ArrayList;
import java.util.List;

/**
 * 216. Combination Sum III
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
                res.add(new ArrayList(list));
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
