package com.home.henry.back_tracking_05;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 90. Subsets II
 *
 * Given a collection of integers that might contain duplicates, nums, return all possible subsets (the power set).
 * Note: The solution set must not contain duplicate subsets.
 * Example:
 * Input: [1,2,2]
 * Output: [ [2], [1], [1,2,2], [2,2], [1,2], [] ]
 * Point: if (i > index && nums[i] == nums[i - 1]) {continue;}
 * 比如[1,2,2] 已经遍历完了[1, 2], 现在来了个新的2, 在[1, 2]中回退的时候减去2, 然后又加上了新来的2, 这样就会重复了
 */
public class SubsetsII_L090_002 {
    static class Solution {
        public List<List<Integer>> subsetsWithDup(int[] nums) {
            List<List<Integer>> res = new ArrayList<>();
            Arrays.sort(nums);
            helper(res, new ArrayList<>(), nums, 0);
            return res;
        }

        private void helper(List<List<Integer>> res, ArrayList<Integer> list, int[] nums, int index) {
            res.add(new ArrayList<>(list));
            for (int i = index; i < nums.length; i++) {
                if (i > index && nums[i] == nums[i - 1]) {continue;}
                list.add(nums[i]);
                helper(res, list, nums, i + 1);
                list.remove(list.size() - 1);
            }
        }
    }

    /**
     * 这道子集合之二是之前那道 Subsets 的延伸，这次输入数组允许有重复项，其他条件都不变，只需要在之前那道题解法的基础上稍加改动
     * 便可以做出来，我们先来看非递归解法，拿题目中的例子 [1 2 2] 来分析，根据之前 Subsets 里的分析可知，当处理到第一个2时，
     * 此时的子集合为 [], [1], [2], [1, 2]，而这时再处理第二个2时，如果在 [] 和 [1] 后直接加2会产生重复，所以只能在上一个
     * 循环生成的后两个子集合后面加2，发现了这一点，题目就可以做了，我们用 last 来记录上一个处理的数字，然后判定当前的数字和上面
     * 的是否相同，若不同，则循环还是从0到当前子集的个数，若相同，则新子集个数减去之前循环时子集的个数当做起点来循环
     * 这样就不会产生重复了
     */
    static class SolutionIter {
        public List<List<Integer>> subsetsWithDup(int[] nums) {
            List<List<Integer>> res = new ArrayList<>();
            res.add(new ArrayList<Integer>());
            Arrays.sort(nums);
            int last = nums[0];
            int size = 1;
            for (int i = 0; i < nums.length; i++) {
                if (last != nums[i]) {
                    size = res.size();
                    last = nums[i];
                }
                int newSize = res.size();
                for (int j = newSize - size; j < newSize; j++) {
                    List<Integer> subset = new ArrayList<>(res.get(j));
                    subset.add(nums[i]);
                    res.add(subset);
                }
            }
            return res;
        }
    }
}
