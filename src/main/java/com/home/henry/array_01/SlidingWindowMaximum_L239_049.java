package com.home.henry.array_01;

import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;

/**
 * 239. Sliding Window Maximum
 *
 * Given an array nums, there is a sliding window of size k which is moving from the very left of the array to
 * the very right. You can only see the k numbers in the window. Each time the sliding window moves right by
 * one position. Return the max sliding window.
 * Input: nums = [1,3,-1,-3,5,3,6,7], and k = 3 Output: [3,3,5,5,6,7]
 * Could you solve it in linear time?
 *
 * We scan the array from 0 to n-1, keep "promising" elements in the deque. The algorithm is amortized O(n)
 * as each element is put and polled once
 * pq可以是O(nlogn)
 * 滑动窗口, 可以是O(n)
 */
public class SlidingWindowMaximum_L239_049 {
    static class Solution {
        public int[] maxSlidingWindow(int[] nums, int k) {
            if (nums == null || nums.length == 0) {
                return new int[0];
            }
            Deque<Integer> deque = new LinkedList<>();
            int[] res = new int[nums.length + 1 - k];
            for (int i = 0; i < nums.length; i++) {
                // remove numbers out of range k
                if (!deque.isEmpty() && deque.peekFirst() == i - k) {
                    deque.poll();
                }
                // remove smaller numbers in k range as they are useless
                // 如果队列中的数都小于nums[i],其留下就没有意义.因为如果nums[i]最大,接下来的的k-1个数
                // 要寻找最大的,所以除了nums[i],其他没有必要比较
                while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                    deque.pollLast();
                }
                // 每次进入循环,要加入一个数
                deque.offerLast(i);
                // 注意边界, 加入到返回中
                if ((i + 1) >= k && !deque.isEmpty()) {
                    res[i + 1 - k] = nums[deque.peek()];
                }
            }
            return res;
        }
    }

    /**
     * O(nlogn)
     */
    static class SolutionPQ {
        public int[] maxSlidingWindow(int[] nums, int k) {
            if (nums == null || nums.length == 0) {
                return new int[0];
            }
            // 注意pq的init方式, 这样peek出来是最大值, 否则不加reverse order, peek出来就是最小值
            PriorityQueue<Integer> heap = new PriorityQueue<>(k, Collections.reverseOrder());
            int[] res = new int[nums.length + 1 - k];
            // 先放入k个数字
            for (int i = 0; i < k; i++) {
                heap.offer(nums[i]);
            }
            // 赋值给res(peek出最大值), 然后删除nums[i], 加入nums[i + k](注意加入不超过array的length就可以)
            for (int i = 0; i < res.length; i++) {
                res[i] = heap.peek();
                heap.remove(nums[i]);
                if (i + k < nums.length) {
                    heap.offer(nums[i + k]);
                }
            }
            return res;
        }
    }
}
