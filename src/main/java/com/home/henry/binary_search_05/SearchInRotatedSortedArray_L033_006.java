package com.home.henry.binary_search_05;

/**
 * 33. Search in Rotated Sorted Array
 * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
 * (i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]).
 * You are given a target value to search. If found in the array return its index, otherwise return -1.
 */
public class SearchInRotatedSortedArray_L033_006 {

    // 数组从任意位置劈开后，至少有一半是有序的，什么意思呢？
    // 比如 [ 4 5 6 7 1 2 3] ，从 7 劈开，左边是 [ 4 5 6 7] 右边是 [ 7 1 2 3]，左边是有序的。基于这个事实。
    // 我们可以先找到哪一段是有序的 (只要判断端点即可)，然后看 target 在不在这一段里，如果在，那么就把另一半丢弃。如果不在，那么就把这一段丢弃。
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {return -1;}
        int left = 0, right = nums.length - 1;
        // 如果这里是 <=, 则最后返回的是-1, 而不需要判断
        while (left < right) {
            int mid = (right - left) / 2 + left;
            if (nums[mid] == target) {return mid;}
            //左半段是有序的
            if (nums[left] <= nums[mid]) {
                //target 在这段里
                if (target >= nums[left] && target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
                //右半段是有序的
            } else {
                if (target > nums[mid] && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return nums[left] == target ? left : -1;
    }
}
