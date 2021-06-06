package com.home.henry.stack_pq_11;

import java.util.Stack;

/**
 * 503. Next Greater Element II
 *
 * Given a circular integer array nums (i.e., the next element of nums[nums.length - 1] is nums[0]),
 * return the next greater number for every element in nums.
 *
 * The next greater number of a number x is the first greater number to its traversing-order next
 * in the array, which means you could search circularly to find its next greater number.
 * If it doesn't exist, return -1 for this number.
 *
 *
 *
 * Input: nums = [1,2,1] Output: [2,-1,2]
 * Explanation: The first 1's next greater number is 2;
 * The number 2 can't find next greater number.
 * The second 1's next greater number needs to search circularly, which is also 2.
 *
 * Input: nums = [1,2,3,4,3] Output: [2,3,4,-1,4]
 *
 * 这个是下面的简单题目的数组循环版本，原理类似，使用了 % n的处理方式，也是处理循环的通用办法
 */
public class L503_NextGreaterElementII_018 {
    class Solution {
        public int[] nextGreaterElements(int[] nums) {
            int[] res = new int[nums.length];
            Stack<Integer> stack = new Stack<>();
            int n = nums.length;
            for (int i = nums.length * 2 - 1; i >= 0; i--) {
                while (!stack.isEmpty() && stack.peek() <= nums[i % n]) {
                    stack.pop();
                }
                res[i % n] = stack.isEmpty() ? -1 : stack.peek();
                stack.push(nums[i % n]);
            }
            return res;
        }
    }

    /**
     * 这个是简单版本的下一个更大元素，是算法小抄中的题目
     * [2,1,2,4,3] -> [4,2,4,-1,-1]
     */
    class SimpleNextGreaterElement {
        public int[] nextGreaterElementsSimple(int[] nums) {
            int[] res = new int[nums.length];
            Stack<Integer> stack = new Stack<>();
            // 倒着向stack里放
            for (int i = nums.length - 1; i >= 0; i--) {
                while (!stack.isEmpty() && stack.peek() <= nums[i]) {
                    // 小的数字出列
                    stack.pop();
                }
                res[i] = stack.isEmpty() ? -1 : stack.peek();
                // 进队列，后面接着比较
                stack.push(nums[i]);
            }
            return res;
        }
    }
}
