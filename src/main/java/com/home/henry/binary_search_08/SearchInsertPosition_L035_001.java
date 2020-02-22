package com.home.henry.binary_search_08;

/**
 * 35. Search Insert Position
 *
 * Given a sorted array and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.
 * You may assume no duplicates in the array.
 */
public class SearchInsertPosition_L035_001 {

    public static int searchInsert(int[] nums, int target) {
        int start = 0, end = nums.length - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return start;
    }

    public static int searchInsert2(int[] nums, int target) {
        // unknown: target exist, if->index of target, if not->index less than target and great than target
        // data: sorted array, target
        // similar question: binary search to find number
        if (nums == null || nums.length == 0) {return -1;}
        if (target < nums[0]) {return 0;}
        if (target > nums[nums.length - 1]) {return nums.length;}
        int low = 0, high = nums.length - 1;
        while (low + 1 < high) {
            int mid = (high - low) / 2 + low;
            if (nums[mid] == target) {return mid;}
            else if (nums[mid] > target) {high = mid;}
            else {low = mid;}
        }
        return high;
    }

    public static void main(String[] args) {
        System.out.println(searchInsert2(new int[] { 1, 3, 5, 6 }, 2));
    }

}
