package com.home.henry.array_01;

/**
 * 153. Find Minimum in Rotated Sorted Array
 * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
 * (i.e.,  [0,1,2,4,5,6,7] might become  [4,5,6,7,0,1,2]).
 * Find the minimum element.
 */
public class FindMinimumInRotatedSortedArray_L153_017 {

    public int findMin(int[] nums) {
        if (nums == null || nums.length == 0) {return Integer.MIN_VALUE;}
        int left = 0, right = nums.length - 1;
        // 这里不能left <= right, 会出错
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return nums[left];
    }

}
