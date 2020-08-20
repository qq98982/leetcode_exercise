package com.home.henry.binary_search_08;

import java.util.Stack;

/**
 * 852. Peak Index in a Mountain Array
 *
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
 * 第一种用stack实现, 较容易, 另一种用binary search, 第三个也是binary search
 */
public class L852_PeakIndexInAMountainArray_011 {

    public int peakIndexInMountainArrayStack(int[] A) {
        if (A == null || A.length < 3) {return Integer.MIN_VALUE;}
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        for (int i = 1; i < A.length; i++) {
            int val = stack.peek();
            if (A[i] > A[val]) {
                while (!stack.isEmpty()) {
                    stack.pop();
                }
                stack.push(i);
            } else {
                return i - 1;
            }
        }
        return stack.pop();
    }

    public int peakIndexInMountainArray(int[] A) {
        if (A == null || A.length < 3) {return Integer.MIN_VALUE;}
        int left = 0, right = A.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (A[mid] < A[mid + 1]) {
                // peak index is after mid.
                left = mid + 1;
            } else if (A[mid - 1] > A[mid]) {
                // peak index is before mid.
                right = mid;
            } else {
                // peak index is mid.
                return mid;
            }
        }
        return Integer.MIN_VALUE;
    }

    public int peakIndexInMountainArray3(int[] A) {
        int start = 0, end = A.length - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (A[mid] < A[mid + 1]) {
                start = mid;
            } else {
                end = mid;
            }
        }
        return A[start] > A[end] ? start : end;
    }
}
