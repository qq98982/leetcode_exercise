package com.home.henry.array_01;

import java.util.Stack;

/**
 * 852. Peak Index in a Mountain Array
 * Let's call an array A a mountain if the following properties hold:
 *
 * A.length >= 3
 * There exists some 0 < i < A.length - 1 such that A[0] < A[1] < ... A[i-1] < A[i] > A[i+1] > ... > A[A.length - 1]
 * Given an array that is definitely a mountain, return any i such that A[0] < A[1] < ... A[i-1] < A[i] > A[i+1] > ... > A[A.length - 1].
 *
 * Input: [0,1,0] Output: 1
 *
 * Input: [0,2,1,0] Output: 1
 *
 * 第一种是stack方法 O(n) 第二种是Binary Search方法O(logN), 第三种是start + 1 < end的用法
 */
public class L852_PeakIndexInAMountainArray_020 {
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

    static class SolutionBS {
        public int peakIndexInMountainArray(int[] A) {
            int start = 0, end = A.length - 1;
            while (start + 1 < end) {
                int mid = (end - start) / 2 + start;
                if (A[mid] < A[mid + 1]) {
                    start = mid;
                } else {
                    end = mid;
                }
            }
            return A[start] > A[end] ? start : end;
        }
    }
}
