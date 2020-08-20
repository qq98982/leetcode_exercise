package com.home.henry.array_01;

/**
 * 81. Search in Rotated Sorted Array II
 *
 * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
 * (i.e., [0,0,1,2,2,5,6] might become [2,5,6,0,0,1,2]).
 * You are given a target value to search. If found in the array return true, otherwise return false.
 *
 * Input: nums = [2,5,6,0,0,1,2], target = 0 Output: true
 * Input: nums = [2,5,6,0,0,1,2], target = 3 Output: false
 *
 * Follow up:
 * This is a follow up problem to Search in Rotated Sorted Array, where nums may contain duplicates.
 * Would this affect the run-time complexity? How and why?
 */
public class L081_SearchInRotatedSortedArrayII_015 {
    static class Solution {
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

    static class Solution2 {
        // it may contains duplicate
        public boolean search(int[] nums, int target) {
            if (nums == null || nums.length == 0) {return false;}
            int start = 0, end = nums.length - 1;
            while (start + 1 < end) {
                int mid = start + (end - start) / 2;
                if (nums[mid] == target || nums[start] == target || nums[end] == target) {return true;}
                if (nums[start] == nums[mid] && nums[mid] == nums[end]) { // to avoid [1,1,3,1] case
                    start++;
                    end--;
                } else if (nums[start] <= nums[mid]) {// left part is sorted, mid is in left
                    if (nums[start] <= target && nums[mid] >= target) {
                        end = mid;
                    } else {
                        start = mid;
                    }
                } else { // right part is sorted
                    if (nums[end] >= target && nums[mid] <= target) {
                        start = mid;
                    } else {
                        end = mid;
                    }
                }
            }
            if (nums[start] == target || nums[end] == target) {return true;}
            return false;
        }
    }
}
