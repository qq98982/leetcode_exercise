package com.home.henry.array_01;

/**
 * 209. Minimum Size Subarray Sum
 *
 * Given an array of n positive integers and a positive integer s, find the minimal length of a contiguous
 * subarray of which the sum ≥ s. If there isn't one, return 0 instead.
 *
 * Input: s = 7, nums = [2,3,1,2,4,3] Output: 2
 * Explanation: the subarray [4,3] has the minimal length under the problem constraint.
 *
 * Follow up:
 * If you have figured out the O(n) solution, try coding another solution of which the time complexity is O(n log n).
 *
 * 这个题目是找出一个连续的数组, 和加起来 >=s, 这个数组的数目最小的个数是多少
 *
 * 扫描线做法O(n)
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
                    sum -= nums[left++];
                    if (res == 1) {return 1;}
                }
            }
            return res == Integer.MAX_VALUE ? 0 : res;
        }
    }

    /**
     * 二分法, 生成一个nums.length+1长度的数组, 做为相加使用
     * 利用了相加和为递增的特点, 进行二分查找
     * time: O(nlogn) space: O(n)
     */
    static class SolutionBS {
        public int minSubArrayLen(int s, int[] nums) {
            if (nums == null || nums.length == 0) {return 0;}
            int[] sums = new int[nums.length + 1];
            for (int i = 1; i < sums.length; i++) {
                sums[i] = sums[i - 1] + nums[i - 1];
            }
            int minLen = Integer.MAX_VALUE;
            for (int i = 0; i < sums.length; i++) {
                int end = binarySearch(i + 1, sums.length - 1, sums[i] + s, sums);
                if (end == sums.length) {break;}
                minLen = Math.min(minLen, end - i);
            }
            return minLen == Integer.MAX_VALUE ? 0 : minLen;
        }

        private int binarySearch(int start, int end, int target, int[] sums) {
            while (start <= end) {
                int mid = (end - start) / 2 + start;
                if (sums[mid] >= target) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }
            return start;
        }
    }
}
