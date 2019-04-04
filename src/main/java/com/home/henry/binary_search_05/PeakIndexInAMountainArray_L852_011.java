package com.home.henry.binary_search_05;

import java.util.Stack;

/**
 * 852. Peak Index in a Mountain Array
 * 第一种用stack实现, 较容易, 另一种用binary search
 */
public class PeakIndexInAMountainArray_L852_011 {

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
}
