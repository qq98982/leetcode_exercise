package com.home.henry.stack_pq_11;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * 215. Kth Largest Element in an Array
 *
 * Find the kth largest element in an unsorted array. Note that it is the kth largest element in
 * the sorted order, not the kth distinct element.
 *
 * Input: [3,2,1,5,6,4] and k = 2 Output: 5
 *
 * Input: [3,2,3,1,2,4,5,5,6] and k = 4 Output: 4
 * Note:
 * You may assume k is always valid, 1 ≤ k ≤ array's length.
 *
 * quick select的思路是O(logn), pq是O(nlogn)
 */
public class KthLargestElementInAnArray_L215_010 {
    static class Solution {
        public static int findKthLargest(int[] nums, int k) {
            int start = 0, end = nums.length - 1;
            while (true) {
                int p = partition(nums, start, end);
                if (p + 1 == k) {
                    return nums[p];
                } else if (p + 1 > k) {
                    end = p - 1;
                } else {
                    start = p + 1;
                }
            }
        }

        private static int partition(int[] nums, int start, int end) {
            if (start == end) {return start;}
            int num = nums[start];
            int i = start, j = end + 1;
            while (true) {
                while (nums[++i] >= num) {
                    if (i == end) {break;}
                }
                while (nums[--j] <= num) {
                    if (j == start) {break;}
                }
                if (i >= j) {break;}
                exch(nums, i, j);
            }
            exch(nums, start, j);
            return j;
        }

        private static void exch(int[] nums, int i, int j) {
            int tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
        }
    }

    public static void main(String[] args) {
        System.out.println(Solution.findKthLargest(new int[] { 1 }, 1));
    }

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
