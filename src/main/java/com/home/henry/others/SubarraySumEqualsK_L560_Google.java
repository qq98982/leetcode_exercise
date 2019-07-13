package com.home.henry.others;

import java.util.HashMap;
import java.util.Map;

/**
 * Google 2019 Fall Intern Phone Screen
 * Given an array of integers and an integer k, you need to find the total number of continuous subarrays whose sum equals to k.
 * Input:nums = [1,1,1], k = 2 Output: 2
 * 思路:
 * 第一个想法, Sliding window是错误的, 浪费很多时间, 这个是找多少种方式, 并且有可能有负数
 * 第二个想法用two pointer可以做, O(n^2)
 * 比较好的办法是HashMap + preSum 非常巧妙
 * time O(n) space O(n)
 * 比较难以理解, 看下面这个文章有帮助
 * https://deonash.wordpress.com/category/leetcode/
 */
public class SubarraySumEqualsK_L560_Google {

    static class Solution {
        public int subarraySum(int[] nums, int k) {
            if (nums == null || nums.length == 0) {return 0;}

            int sum = 0, result = 0;
            Map<Integer, Integer> map = new HashMap<>(nums.length);
            // sum - k = 0 就是sum == k 也要计算进去一次
            map.put(0, 1);
            for (int i = 0; i < nums.length; i++) {
                sum += nums[i];
                if (map.containsKey(sum - k)) {
                    result += map.get(sum - k);
                }
                map.put(sum, map.getOrDefault(sum, 0) + 1);
                System.out.println(map);
            }
            return result;
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.subarraySum(new int[] { 1, 1, 1 }, 2)); // 2
        System.out.println(s.subarraySum(new int[] { 0, 1, 2 }, 3)); // 2
        System.out.println(s.subarraySum(new int[] { 2, 0, 1, 1, 2 }, 2)); // 5
        System.out.println(s.subarraySum(new int[] { 2, 0, 1, 1, 2 }, 3)); // 2
        System.out.println(s.subarraySum(new int[] { 2, 0, 1, 1, 2 }, 4)); // 3
        System.out.println(s.subarraySum(new int[] { 2, 0, 1, 1, 2, 0 }, 2)); // 6
        System.out.println(s.subarraySum(new int[] { 2, 1, 1, 1, 1, 3 }, 6)); // 3
        System.out.println(s.subarraySum(new int[] { 3, -3, 5, 1, 4,2 }, 6)); // 3
    }
}
