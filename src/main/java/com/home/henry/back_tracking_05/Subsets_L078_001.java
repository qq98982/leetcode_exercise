package com.home.henry.back_tracking_05;

import java.util.ArrayList;
import java.util.List;

/**
 * 78. Subsets
 *
 * Given a set of distinct integers, nums, return all possible subsets (the power set).
 * Note: The solution set must not contain duplicate subsets.
 * Example:
 * Input: nums = [1,2,3]
 * Output: [ [3], [1], [2], [1,2,3], [1,3], [2,3], [1,2], [] ]
 */
public class Subsets_L078_001 {

    // 每一个元素在子集中有两种状态：要么存在、要么不存在。这样构造子集的过程中每个元素就有两种选择方法：选择、不选择，
    // 因此可以构造一颗二叉树，例如对于例子中给的集合[1,2,3]，最后得到的叶子节点就是子集
    static class Solution {
        public List<List<Integer>> subsets(int[] nums) {
            List<List<Integer>> res = new ArrayList<>();
            helper(res, new ArrayList<>(), nums, 0);
            return res;
        }

        private void helper(List<List<Integer>> res, ArrayList<Integer> list, int[] nums, int index) {
            // res要加入这个list
            res.add(new ArrayList(list));
            for (int i = index; i < nums.length; i++) {
                list.add(nums[i]);
                // i + 1, not index + 1 !!!
                helper(res, list, nums, i + 1);
                list.remove(list.size() - 1);
            }
        }
    }

    /**
     * While iterating through all numbers, for each new number, we can either pick it or not pick it
     * 1, if pick, just add current number to every existing subset.
     * 2, if not pick, just leave all existing subsets as they are.
     * We just combine both into our result.
     *
     * For example, {1,2,3} intially we have an emtpy set as result [ [ ] ]
     * Considering 1, if not use it, still [ ], if use 1, add it to [ ], so we have [1] now
     * Combine them, now we have [ [ ], [1] ] as all possible subset
     *
     * Next considering 2, if not use it, we still have [ [ ], [1] ], if use 2, just add 2 to each previous subset, we have [2], [1,2]
     * Combine them, now we have [ [ ], [1], [2], [1,2] ]
     *
     * Next considering 3, if not use it, we still have [ [ ], [1], [2], [1,2] ], if use 3, just add 3 to each previous subset, we have [ [3], [1,3], [2,3], [1,2,3] ]
     * Combine them, now we have [ [ ], [1], [2], [1,2], [3], [1,3], [2,3], [1,2,3] ]
     */
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<>());
        for (int n : nums) {
            int size = res.size();
            for (int i = 0; i < size; i++) {
                List<Integer> subset = new ArrayList<>(res.get(i));
                subset.add(n);
                res.add(subset);
            }
        }
        return res;
    }
}
