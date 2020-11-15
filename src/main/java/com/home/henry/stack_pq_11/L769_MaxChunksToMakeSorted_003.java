package com.home.henry.stack_pq_11;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 769. Max Chunks To Make Sorted
 *
 * Given an array arr that is a permutation of [0, 1, ..., arr.length - 1], we split the array into some number
 * of "chunks" (partitions), and individually sort each chunk.  After concatenating them, the result equals the
 * sorted array.
 *
 * What is the most number of chunks we could have made?
 *
 * Input: arr = [4,3,2,1,0]
 * Output: 1
 * Explanation:
 * Splitting into two or more chunks will not return the required result.
 * For example, splitting into [4, 3], [2, 1, 0] will result in [3, 4, 0, 1, 2], which isn't sorted.
 *
 * Input: arr = [1,0,2,3,4]
 * Output: 4
 * Explanation:
 * We can split into two chunks, such as [1, 0], [2, 3, 4].
 * However, splitting into [1, 0], [2], [3], [4] is the highest number of chunks possible.
 *
 * 单调递增栈最大个数就是结果
 */
public class L769_MaxChunksToMakeSorted_003 {

    public static class Solution {
        public static int maxChunksToSorted(int[] arr) {
            Deque<Integer> stack = new ArrayDeque<>();
            for (int num : arr) {
                int largest = num;
                while (!stack.isEmpty() && stack.peek() > num) {
                    largest = Math.max(largest, stack.pop());
                }
                stack.push(largest);
            }
            return stack.size();
        }
    }
}
