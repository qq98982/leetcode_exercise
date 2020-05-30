package com.home.henry.stack_pq_11;

import java.util.Stack;

/**
 * 768. Max Chunks To Make Sorted II
 *
 * This question is the same as "Max Chunks to Make Sorted" except the integers of the given array are not necessarily distinct, the input array could be up to length 2000, and the elements could be up to 10**8.
 *
 * Given an array arr of integers (not necessarily distinct), we split the array into some number of "chunks"
 * (partitions), and individually sort each chunk.  After concatenating them, the result equals the sorted array.
 *
 * What is the most number of chunks we could have made?
 *
 * Input: arr = [5,4,3,2,1] Output: 1
 * Explanation:
 * Splitting into two or more chunks will not return the required result.
 * For example, splitting into [5, 4], [3, 2, 1] will result in [4, 5, 1, 2, 3], which isn't sorted.
 *
 * Input: arr = [2,1,3,4,4] Output: 4
 * Explanation:
 * We can split into two chunks, such as [2, 1], [3, 4, 4].
 * However, splitting into [2, 1], [3], [4], [4] is the highest number of chunks possible.
 *
 * 单调栈, 和769相似, 这个没有重复元素, 代码一样
 */
public class MaxChunksToMakeSortedII_L768_004 {
    class Solution {
        public int maxChunksToSorted(int[] arr) {
            if (arr == null || arr.length == 0) {return 0;}
            Stack<Integer> stack = new Stack<>();
            for (int num : arr) {
                int largest = num;
                while (!stack.isEmpty() && stack.peek() > num) {
                    largest = Math.max(largest, stack.pop());
                }
                stack.push(largest);
            }
            int count = 0;
            while (!stack.isEmpty()) {
                stack.pop();
                count++;
            }
            return count;
        }
    }
}
