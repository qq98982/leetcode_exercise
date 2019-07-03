package com.home.henry.array_01;

/**
 * 209. Minimum Size Subarray Sum
 * 这个题目是找出一个连续的数组, 和加起来 >=s
 * 扫描线做法O(n)
 *
 * 每次循环, 加上当前的值, 当这个相加和已经符合要求
 * 在while循环中判断连续是不是最小的, 然后再减去最左边的值, 最左边的index向右+1
 * while循环完成, 当前最小的就知道了
 * 然后继续下一个继续找
 */
public class MinimumSizeSubarraySum_L209_051 {
    static class Solution {
        public int minSubArrayLen(int s, int[] nums) {
            int sum = 0, left = 0, res = Integer.MAX_VALUE;
            for (int i = 0; i < nums.length; i++) {
                sum += nums[i];
                while (left <= i && sum >= s) {
                    res = Math.min(res, i - left + 1);
                    sum -= nums[left];
                    left++;
                }
            }
            return res == Integer.MAX_VALUE ? 0 : res;
        }
    }

}
