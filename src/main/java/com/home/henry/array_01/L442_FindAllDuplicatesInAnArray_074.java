package com.home.henry.array_01;

import java.util.ArrayList;
import java.util.List;

/**
 * 442. Find All Duplicates in an Array
 *
 * Given an array of integers, 1 ≤ a[i] ≤ n (n = size of array), some elements appear twice
 * and others appear once.
 *
 * Find all the elements that appear twice in this array.
 *
 * Could you do it without extra space and in O(n) runtime?
 *
 * Input: [4,3,2,7,8,2,3,1] Output: [2,3]
 *
 * 思路比较好, 进行+-转换后判断
 */
public class L442_FindAllDuplicatesInAnArray_074 {

    static class Solution {
        public static List<Integer> findDuplicates(int[] nums) {
            List<Integer> res = new ArrayList<>();
            for (int num : nums) {
                int n = Math.abs(num);
                int index = n - 1;
                if (nums[index] < 0) {
                    res.add(n);
                }
                nums[index] = -nums[index];
            }
            return res;
        }
    }

    public static void main(String[] args) {
        System.out.println("[2, 3] -> " + Solution.findDuplicates(new int[] { 4, 3, 2, 7, 8, 2, 3, 1 }));
    }
}
