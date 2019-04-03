package com.home.henry.binary_search_05;

/**
 * 704. Binary Search
 * 使用迭代的第二种写法
 */
public class BinarySearch_L704_003 {

    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {return -1;}
        int start = 0, end = nums.length;
        while (start < end) {
            int mid = (end - start) / 2 + start;
            if (nums[mid] < target) {
                start = mid + 1;
            } else if (nums[mid] > target) {
                end = mid;
            } else {
                return mid;
            }
        }
        return -1;
    }

}
