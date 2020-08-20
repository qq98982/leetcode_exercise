package com.home.henry.back_tracking_05;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 47. Permutations II
 * Given a collection of numbers that might contain duplicates, return all possible unique permutations.
 * Example: Input: [1,1,2] Output: [ [1,1,2], [1,2,1], [2,1,1] ]
 */
public class L047_PermutationsII_008 {

    static class Solution {
        public List<List<Integer>> permuteUnique(int[] nums) {
            List<List<Integer>> res = new ArrayList<>();
            Arrays.sort(nums);
            helper(res, new ArrayList<>(), nums, new boolean[nums.length]);
            return res;
        }

        private void helper(List<List<Integer>> res, List<Integer> list, int[] nums, boolean[] visited) {
            if (list.size() == nums.length) {
                res.add(new ArrayList<>(list));
                return;
            }
            for (int i = 0; i < nums.length; i++) {
                // 防止重复, 从第一遍的视角
                if (visited[i]) {continue;}
                // 过滤重复添加, 比如{1,1,2}第一个1走了一遍,第二个1就不用再走一遍了,所以过滤掉
                if (i > 0 && nums[i] == nums[i - 1] && !visited[i - 1]) {continue;}
                visited[i] = true;
                list.add(nums[i]);
                helper(res, list, nums, visited);
                visited[i] = false;
                list.remove(list.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.permuteUnique(new int[] { 1, 2, 1, 2, 1 }));
    }
}
