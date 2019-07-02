package com.home.henry.array_01;

import java.util.ArrayList;
import java.util.List;

/**
 * 448. Find All Numbers Disappeared in an Array
 * Given an array of integers where 1 ≤ a[i] ≤ n (n = size of array), some elements appear twice and
 * others appear once.
 *
 * Find all the elements of [1, n] inclusive that do not appear in this array.
 * Input: [4,3,2,7,8,2,3,1] Output: [5,6]
 * 寻找没有出现的数字, 下面这个方法很巧妙, 用了Math.abs是因为有可能有些数字会出现负数, 这样就会有错误
 */
public class FindAllNumbersDisappearedInAnArray_L448_045 {
    static class Solution {
        public List<Integer> findDisappearedNumbers(int[] nums) {
            List<Integer> res = new ArrayList<>();
            if (nums == null || nums.length == 0) {return res;}
            for (int i = 0; i < nums.length; i++) {
                int val = Math.abs(nums[i]) - 1;
                if (nums[val] > 0) {
                    nums[val] = -nums[val];
                }
            }
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] > 0) {
                    res.add(i + 1);
                }
            }
            return res;
        }
    }
}
