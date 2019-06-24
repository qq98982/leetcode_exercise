package com.home.henry.stack_pq_11;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * 215. Kth Largest Element in an Array
 */
public class KthLargestElementInAnArray_L215_010 {

    // O(NlogN) running time + O(1) memory
    public int findKthLargest(int[] nums, int k) {
        int N = nums.length;
        Arrays.sort(nums);
        return nums[N - k];
    }

    // // O(NlogK) running time + O(K) memory
    public int findKthLargestQueue(int[] nums, int k) {
        if (nums == null || nums.length == 0) {return -1;}
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int val : nums) {
            pq.offer(val);
            if (pq.size() > k) {
                pq.poll();
            }
        }
        return pq.peek();
    }
}
