package com.home.henry.array_01;

/**
 * 334. Increasing Triplet Subsequence
 * 方法很巧妙, 使用了滚动更新min1和min2的方法
 */
public class IncreasingTripletSubsequence_L334_030 {
    class Solution {
        public boolean increasingTriplet(int[] nums) {
            if (nums.length < 3) {return false;}
            int min1 = Integer.MAX_VALUE;
            int min2 = Integer.MAX_VALUE;
            for (int i = 0; i < nums.length; i++) {
                int curr = nums[i];
                if (curr > min2) {
                    return true;
                } else if (curr < min1) {
                    min1 = curr;
                } else if (curr > min1 && curr < min2) {
                    min2 = curr;
                }
            }
            return false;
        }
    }
}
