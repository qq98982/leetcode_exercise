package com.home.henry.binary_search_08;

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

    // 最常见方式
    public int search2(int[] nums, int target) {
        if (nums == null || nums.length == 0) {return -1;}
        int start = 0, end = nums.length - 1;
        while (start <= end) {
            int mid = (end - start) / 2 + start;
            if (nums[mid] < target) {
                start = mid + 1;
            } else if (nums[mid] > target) {
                end = mid - 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    // start + 1 < end 方式
    public int search3(int[] nums, int target) {
        if (nums == null || nums.length == 0
            || nums[0] > target || nums[nums.length - 1] < target) {return -1;}
        int start = 0, end = nums.length - 1;
        while (start + 1 < end) {
            int mid = (end - start) / 2 + start;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                start = mid;
            } else {
                end = mid;
            }
        }
        if (nums[start] == target) {return start;}
        else if (nums[end] == target) {return end;}
        else {return -1;}
    }

}
