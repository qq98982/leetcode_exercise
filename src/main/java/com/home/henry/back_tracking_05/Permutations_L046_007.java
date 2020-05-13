package com.home.henry.back_tracking_05;

import java.util.ArrayList;
import java.util.List;

/**
 * 46. Permutations
 *
 *  Given a collection of distinct integers, return all possible permutations.
 *  Example:
 *  Input: [1,2,3]
 *  Output: [ [1,2,3], [1,3,2], [2,1,3], [2,3,1], [3,1,2], [3,2,1] ]
 */
public class Permutations_L046_007 {

    /**
     * time: O(n! * n) space: O(n)
     */
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
                    // element already exists, skip, else if will be [1,1,1] and so on
                    if (list.contains(nums[i])) {continue;}
                    list.add(nums[i]);
                    helper(res, list, nums);
                    list.remove(list.size() - 1);
                }
            }
        }
    }

    /**
     * 第二种方法使用了交换法, 不用检测这个数字是否已经被添加过了, 所以少了O(n)的复杂度
     * time: O(n!) space: O(n)
     */
    static class SolutionSec {
        public List<List<Integer>> permute(int[] nums) {
            List<List<Integer>> res = new ArrayList<>();
            helper(res, 0, nums);
            return res;
        }

        private void helper(List<List<Integer>> res, int index, int[] nums) {
            if (index == nums.length) {
                List<Integer> list = new ArrayList<>();
                for (int num : nums) {
                    list.add(num);
                }
                res.add(new ArrayList<>(list));
                return;
            }
            for (int i = index; i < nums.length; i++) {
                swap(nums, index, i);
                helper(res, index + 1, nums);
                swap(nums, index, i);
            }
        }

        private void swap(int[] nums, int l, int r) {
            int temp = nums[l];
            nums[l] = nums[r];
            nums[r] = temp;
        }
    }

    public static void main(String[] args) {
        SolutionSec s = new SolutionSec();
        System.out.println(s.permute(new int[] { 1, 2, 3, 4 }));
    }
}
