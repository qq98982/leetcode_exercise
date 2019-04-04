package com.home.henry.binary_search_05;

/**
 * 154. Find Minimum in Rotated Sorted Array II
 * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
 * (i.e.,  [0,1,2,4,5,6,7] might become  [4,5,6,7,0,1,2]).
 * Find the minimum element. The array may contain duplicates.
 */
public class FindMinimumInRotatedSortedArrayII_L154_009 {

    public int findMin(int[] nums) {
        if (nums == null || nums.length == 0) {return Integer.MIN_VALUE;}
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == nums[right]) {
                // 这点比较重要
                right--;
            } else if (nums[mid] < nums[right]) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return nums[left];
    }

}
