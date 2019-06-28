package com.home.henry.array_01;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 169. Majority Element
 * Given an array of size n, find the majority element. The majority element is the element that appears more than ⌊ n/2 ⌋ times.
 * You may assume that the array is non-empty and the majority element always exist in the array.
 * Input: [3,2,3] Output: 3
 * Input: [2,2,1,1,1,2,2] Output: 2
 * 第一种是用Map的方法O(n), O(n), 第二种是sort完成后返回中间O(logN), O(1), 第三种最好, time O(n), space O(1)
 */
public class MajorityElement_L169_021 {
    class SolutionMap {
        public int majorityElement(int[] nums) {
            // map O(n)
            Map<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < nums.length; i++) {
                map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
                if (map.get(nums[i]) > nums.length / 2) {return nums[i];}
            }
            return nums[0];
        }
    }

    class SolutionSort {
        public int majorityElement(int[] nums) {
            Arrays.sort(nums);
            return nums[nums.length / 2];
        }
    }

    class SolutionCount {
        public int majorityElement(int[] nums) {
            int count = 0, candidate = 0;
            for (int i = 0; i < nums.length; i++) {
                if (count == 0) {
                    candidate = nums[i];
                }
                count += nums[i] == candidate ? 1 : - 1;
            }
            return candidate;
        }
    }
}
