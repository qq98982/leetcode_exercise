package com.home.henry.stack_pq_11;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

/**
 * 496. Next Greater Element I
 *
 * You are given two integer arrays nums1 and nums2 both of unique elements, where nums1 is a subset of nums2.
 * Find all the next greater numbers for nums1's elements in the corresponding places of nums2.
 * The Next Greater Number of a number x in nums1 is the first greater number to its right in nums2.
 * If it does not exist, return -1 for this number.
 *
 *
 * Input: nums1 = [4,1,2], nums2 = [1,3,4,2]
 * Output: [-1,3,-1]
 * Explanation:
 * For number 4 in the first array, you cannot find the next greater number for it in the second array, so output -1.
 * For number 1 in the first array, the next greater number for it in the second array is 3.
 * For number 2 in the first array, there is no next greater number for it in the second array, so output -1.
 *
 * Input: nums1 = [2,4], nums2 = [1,2,3,4]
 * Output: [3,-1]
 * Explanation:
 * For number 2 in the first array, the next greater number for it in the second array is 3.
 * For number 4 in the first array, there is no next greater number for it in the second array, so output -1.
 *
 * HashMap + Stack Solution
 * Use stack to store the index that the num stack in decreasing order
 * If num in stack < current num, pop the num and update the HashMap.
 * The HashMap store the index.
 * Time complexity: O(N)
 * Space complexity: O(N)
 */
public class L496_NextGreaterElementI_017 {

    /**
     * 这个题目感觉并不是easy，不是很容易想和写的
     * 在算法小抄上有个题目和这个类似，只有一个array，介绍的单调栈写法，容易很多
     */
    public static class Solution {
        public int[] nextGreaterElement(int[] nums1, int[] nums2) {
            if (nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0) return nums1;
            final int M = nums1.length, N = nums2.length;
            Map<Integer, Integer> map = new HashMap<>(N);
            Deque<Integer> stack = new ArrayDeque<>(N);
            for (int i = 0; i < N; i++) {
                while (!stack.isEmpty() && nums2[stack.peek()] < nums2[i]) {
                    map.put(nums2[stack.pop()], nums2[i]);
                }
                stack.push(i);
            }
            int[] res = new int[M];
            for (int j = 0; j < M; j++) {
                res[j] = map.getOrDefault(nums1[j], -1);
            }
            return res;
        }

    }

    public static void main(String[] args) {
        Solution s = new Solution();
        s.nextGreaterElement(new int[] {4,1,2,3,6}, new int[] {1,3,4,2,5,7,6});
    }
}
