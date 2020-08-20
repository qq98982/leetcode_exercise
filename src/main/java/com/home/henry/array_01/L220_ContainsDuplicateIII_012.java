package com.home.henry.array_01;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

/**
 * 220. Contains Duplicate III
 *
 * Given an array of integers, find out whether there are two distinct indices i and j in the array such
 * that the absolute difference between nums[i] and nums[j] is at most t and the absolute difference between
 * i and j is at most k.
 *
 * Input: nums = [1,2,3,1], k = 3, t = 0
 * Output: true
 *
 * Input: nums = [1,0,1,1], k = 1, t = 2
 * Output: true
 *
 * Input: nums = [1,5,9,1,5,9], k = 2, t = 3
 * Output: false
 *
 * This problem requires to maintain a window of size k of the previous values that can be queried for value
 * ranges. The best data structure to do that is Binary Search Tree. As a result maintaining the tree of size
 * k will result in time complexity O(N lg K)
 *
 * Leetcode solution中的bucket方法(在第三个方法中)：https://leetcode.com/problems/contains-duplicate-iii/solution/
 */
public class L220_ContainsDuplicateIII_012 {
    static class Solution {
        public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
            if (nums.length < 2 || k == 0) {
                return false;
            }
            TreeSet<Long> set = new TreeSet<>();

            int i = 0;
            while (i < nums.length) {
                Long floor = set.floor((long) nums[i]);
                Long ceiling = set.ceiling((long) nums[i]);
                if ((floor != null && nums[i] - floor <= t) ||
                    (ceiling != null && ceiling - nums[i] <= t)) {
                    return true;
                }
                set.add((long) nums[i++]);
                if (i > k) {
                    set.remove((long) nums[i - k - 1]);
                }
            }
            return false;
        }
    }

    static class SolutionBucket {
        // nums[i] and nums[j] is at most t
        // difference between i and j is at most k
        public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
            if (t < 0) { return false; }
            Map<Long, Long> d = new HashMap<>();
            // w is greater than t
            long w = (long) t + 1;
            for (int i = 0; i < nums.length; ++i) {
                long m = getId(nums[i], w);
                if (d.containsKey(m)) { return true; }
                if (d.containsKey(m - 1) && Math.abs(nums[i] - d.get(m - 1)) < w) { return true; }
                if (d.containsKey(m + 1) && Math.abs(nums[i] - d.get(m + 1)) < w) { return true; }
                d.put(m, (long) nums[i]);
                if (i >= k) { d.remove(getId(nums[i - k], w)); }
            }
            return false;
        }

        private static long getId(long i, long w) {
            return i < 0 ? (i + 1) / w - 1 : i / w;
        }
    }

}
