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
}
