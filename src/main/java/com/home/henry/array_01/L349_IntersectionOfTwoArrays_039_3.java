package com.home.henry.array_01;

import java.util.HashSet;
import java.util.Set;

/**
 * 349. Intersection of Two Arrays
 *
 * Given two arrays, write a function to compute their intersection.
 * Input: nums1 = [1,2,2,1], nums2 = [2,2] Output: [2]
 * Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4] Output: [9,4]
 *
 * Each element in the result must be unique.
 * The result can be in any order.
 */
public class L349_IntersectionOfTwoArrays_039_3 {

    class Solution {
        // save to set
        // check another array if it is in set, if, save to res, delete it in old set
        // change another set to array
        public int[] intersection(int[] nums1, int[] nums2) {
            if (nums1 == null || nums2 == null || nums1.length == 0 || nums2.length == 0) {
                return new int[]{};
            }
            Set<Integer> set = new HashSet<>();
            for (int n : nums1) {
                set.add(n);
            }
            Set<Integer> res = new HashSet<>();
            for (int n : nums2) {
                if (set.contains(n)) {
                    res.add(n);
                    set.remove(n);
                }
            }
            return res.stream().mapToInt(i -> i).toArray();
        }
    }
}
