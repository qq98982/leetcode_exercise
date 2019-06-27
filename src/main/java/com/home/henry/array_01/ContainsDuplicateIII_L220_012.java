package com.home.henry.array_01;

import java.util.TreeSet;

/**
 * 220. Contains Duplicate III
 * Leetcode solution中的bucket方法(在第三个方法中)：https://leetcode.com/problems/contains-duplicate-iii/solution/
 */
public class ContainsDuplicateIII_L220_012 {
    static class Solution {
        public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
            if (k < 1 || t < 0) {return false;}
            TreeSet<Long> set = new TreeSet<>();
            for (int i = 0; i < nums.length; i++) {
                Long floor = set.floor((long)(nums[i] + t));
                Long ceil = set.ceiling((long)(nums[i] - t));
                if (floor != null &&  floor >= (long)(nums[i])) {return true;}
                if (ceil != null && ceil <= (long)(nums[i])) {return true;}
                set.add((long)nums[i]);
                if (i >= k) {
                    set.remove((long)(nums[i - k]));
                }
            }
            return false;
        }
    }

}
