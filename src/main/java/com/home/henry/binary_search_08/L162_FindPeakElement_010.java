package com.home.henry.binary_search_08;

import java.util.Stack;

/**
 * 162. Find Peak Element
 * A peak element is an element that is greater than its neighbors.
 * Given an input array nums, where nums[i] ≠ nums[i+1], find a peak element and return its index.
 * The array may contain multiple peaks, in that case return the index to any one of the peaks is fine.
 * 后一种速度要好点, 但是没第一种好写
 */
class L162_FindPeakElement_010 {

    public int findPeakElement(int[] nums) {
        if (nums == null || nums.length == 0) {return Integer.MIN_VALUE;}
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        for (int i = 1; i < nums.length; i++) {
            int val = stack.peek();
            if (nums[i] > nums[val]) {
                stack.push(i);
            } else {
                return i - 1;
            }
        }
        return stack.pop();
    }

    public int findPeakElementBinarySearch(int[] nums) {
        if (nums == null || nums.length == 0) {return Integer.MIN_VALUE;}
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < nums[mid + 1]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        if (left == right || nums[left] > nums[left + 1]) {return left;}
        return right;
    }

}