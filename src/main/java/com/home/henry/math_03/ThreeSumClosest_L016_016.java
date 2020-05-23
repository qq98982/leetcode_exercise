package com.home.henry.math_03;

import java.util.Arrays;

/**
 * 16. 3Sum Closest
 *
 * Given an array nums of n integers and an integer target, find three integers in nums such that the sum is
 * closest to target. Return the sum of the three integers. You may assume that each input would have exactly
 * one solution.
 *
 * Given array nums = 16. 3Sum Closest[-1, 2, 1, -4], and target = 1.
 * The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
 *
 * 这道题让我们求最接近给定值的三数之和，是在之前那道 3Sum 的基础上又增加了些许难度，那么这道题让返回这个最接近于给定值的值，
 * 即要保证当前三数和跟给定值之间的差的绝对值最小，所以需要定义一个变量 diff 用来记录差的绝对值，然后还是要先将数组排个序，
 * 然后开始遍历数组，思路跟那道三数之和很相似，都是先确定一个数，然后用两个指针 left 和 right 来滑动寻找另外两个数，
 * 每确定两个数，求出此三数之和，然后算和给定值的差的绝对值存在 newDiff 中，然后和 diff 比较并更新 diff 和结果 closest 即可.
 *
 * 我们还可以稍稍进行一下优化，每次判断一下，当 nums[i]*3 > target 的时候，就可以直接比较 closest 和
 * nums[i] + nums[i+1] + nums[i+2] 的值，返回较小的那个，因为数组已经排过序了，后面的数字只会越来越大，就不必再往后比较了
 */
public class ThreeSumClosest_L016_016 {

    static class Solution {
        public int threeSumClosest(int[] nums, int target) {
            Arrays.sort(nums);
            int closet = Integer.MAX_VALUE;
            for (int i = 0; i < nums.length - 2; i++) {
                int low = i + 1, high = nums.length - 1;
                while (low < high) {
                    int diff = nums[i] + nums[low] + nums[high] - target;
                    if (diff == 0) {return target;}
                    if (Math.abs(diff) < Math.abs(closet)) {
                        closet = diff;
                    }
                    if (diff > 0) {
                        high--;
                    } else {
                        low++;
                    }
                }
            }
            return closet + target;
        }
    }
}
