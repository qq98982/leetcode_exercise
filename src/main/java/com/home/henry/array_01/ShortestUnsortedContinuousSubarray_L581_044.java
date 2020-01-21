package com.home.henry.array_01;

/**
 * 581. Shortest Unsorted Continuous Subarray
 *
 * Given an integer array, you need to find one continuous subarray that if you only sort
 * this subarray in ascending order, then the whole array will be sorted in ascending order, too.
 *
 * You need to find the shortest such subarray and output its length.
 *
 * Input: [2, 6, 4, 8, 10, 9, 15] Output: 5
 * Explanation: You need to sort [6, 4, 8, 10, 9] in ascending order to make the whole array
 * sorted in ascending order.
 *
 * 思路:
 *
 * the variables first and end to keep track of minimum subarray A[first...end] which must be sorted for the
 * entire array A to be sorted. If end < first < 0 at the end of the for loop, then the array is already fully sorted.
 *
 * 这个处理思路需要学习, 否则会出很多边界错误, 比如[1,2], [1,2,3,3,3], [1,2,3,4], [1,1]等
 */
public class ShortestUnsortedContinuousSubarray_L581_044 {
    static class Solution {
        public int findUnsortedSubarray(int[] nums) {
            if (nums == null || nums.length <= 1) {return 0;}
            int first = -1, end = -2, n = nums.length, max = nums[0], min = nums[n - 1];
            for (int i = 1; i < n; i++) {
                max = Math.max(max, nums[i]);
                if (nums[i] < max) {end = i;}
                min = Math.min(min, nums[n - i - 1]);
                if (nums[n - i - 1] > min) {
                    first = n - i - 1;
                }
            }
            return end - first + 1;
        }
    }
}
