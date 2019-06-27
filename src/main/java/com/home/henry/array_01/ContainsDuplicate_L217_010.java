package com.home.henry.array_01;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 217. Contains Duplicate
 * Given an array of integers, find if the array contains any duplicates.
 * Your function should return true if any value appears at least twice in the array, and it should
 * return false if every element is distinct.
 * Input: [1,2,3,1] Output: true
 * Input: [1,2,3,4] Output: false
 * Input: [1,1,1,3,3,4,3,2,4,2] Output: true
 */
public class ContainsDuplicate_L217_010 {

    static class Solution {
        public boolean containsDuplicate(int[] nums) {
            Set<Integer> set = new HashSet<>();
            for (int i = 0; i < nums.length; i++) {
                if (!set.add(nums[i])) {return true;}
            }
            return false;
        }
    }

    static class SolutionSort {
        public boolean containsDuplicate(int[] nums) {
            Arrays.sort(nums);
            for (int i = 1; i < nums.length; i++) {
                if (nums[i] == nums[i - 1]) {
                    return true;
                }
            }
            return false;
        }
    }

}
