package com.home.henry.array_01;

import java.util.Stack;

/**
 * 852. Peak Index in a Mountain Array
 * 第一种是stack方法 O(n) 第二种是Binary Search方法O(logN)
 */
public class PeakIndexInAMountainArray_L852_020 {
    static class Solution {
        public int peakIndexInMountainArray(int[] A) {
            Stack<Integer> stack = new Stack<>();
            stack.push(0);
            int i = 1;
            while (!stack.isEmpty() && i < A.length) {
                int val = stack.pop();
                if (A[val] > A[i]) {
                    return i - 1;
                } else {
                    stack.push(i++);
                }
            }

            return stack.pop();
        }
    }

    static class SolutionBinarySearch {
        public int peakIndexInMountainArray(int[] A) {
            int lo = 0, hi = A.length - 1;
            while (lo < hi) {
                int mi = lo + (hi - lo) / 2;
                if (A[mi] < A[mi + 1]) {
                    lo = mi + 1;
                } else {
                    hi = mi;
                }
            }
            return lo;
        }
    }
}
