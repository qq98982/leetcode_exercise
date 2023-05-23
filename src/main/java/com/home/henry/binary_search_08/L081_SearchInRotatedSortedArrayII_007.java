package com.home.henry.binary_search_08;

/**
 * 81. Search in Rotated Sorted Array II
 *
 * Medium
 *
 * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
 *
 * (i.e., [0,0,1,2,2,5,6] might become [2,5,6,0,0,1,2]).
 *
 * You are given a target value to search. If found in the array return true, otherwise return false.
 *
 * Input: nums = [2,5,6,0,0,1,2], target = 0 Output: true
 *
 * Input: nums = [2,5,6,0,0,1,2], target = 3 Output: false
 */
public class L081_SearchInRotatedSortedArrayII_007 {
    public boolean search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {return false;}

        // left, right
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            //mid
            int mid = (right - left) / 2 + left;
            // accelerate
            if (nums[mid] == target || nums[left] == target || nums[right] == target) {return true;}
            // if left == mid, it has duplicated number
            if (nums[left] == nums[mid]) {
                left++;
            } else if (nums[left] < nums[mid]) {
                // if left part is ascending
                if (target >= nums[left] && target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                // if other part is ascending
                if (target > nums[mid] && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return false;
    }

}

/**
 * 这个方法是用的start + 1 < end, 二分法，要考虑边界情况[1,1,3,1]
 */
class Solution {
    public boolean search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        int start = 0, end = nums.length - 1;
        while (start + 1 < end) {
            int mid = (end - start) / 2 + start;
            if (nums[mid] == target || nums[start] == target || nums[end] == target) {
                return true;
            }
            if (nums[start] == nums[mid] && nums[mid] == nums[end]) {
                start++;
                end--;
            } else if (nums[start] <= nums[mid]) {
                if (nums[start] <= target && target <= nums[mid]) {
                    end = mid;
                } else {
                    start = mid;
                }
            } else {
                if (target <= nums[end] && target >= nums[mid]) {
                    start = mid;
                } else {
                    end = mid;
                }
            }
        }
        if (nums[start] == target) {
            return true;
        }
        return nums[end] == target;
    }
}