package com.home.henry.binary_search_08;

/**
 * 34. Find First and Last Position of Element in Sorted Array
 *
 * Given an array of integers nums sorted in ascending order, find the starting and ending position of a given target value.
 * Your algorithm's runtime complexity must be in the order of O(log n).
 * If the target is not found in the array, return [-1, -1].
 * 分别找出第一个数字和后面的数字, 体现了分块的思路, 另外这个题的关键点是找到边界, 相同并不能直接返回, 要继续找到边界
 * 这里使用了[left, right)的迭代写法, 因为大部分的人会使用这种方法, 其他的[left,right]也可以, 明确一种即可
 * left + 1 < right这种方法需要写额外判断, 另外不容易理解, 不推荐
 */
public class L034_FindFirstAndLastPositionOfElementInSortedArray_002 {

    public int[] searchRange(int[] nums, int target) {
        if (nums == null || nums.length == 0) {return new int[] { -1, -1 };}
        int start = findFirst(nums, target);
        if (start == -1) {return new int[] { -1, -1 };}
        int end = findLast(nums, target);
        return new int[] { start, end };
    }

    private int findFirst(int[] nums, int target) {
        int start = 0, end = nums.length;
        while (start < end) {
            int mid = (end - start) / 2 + start;
            if (nums[mid] < target) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        if (start < nums.length && nums[start] == target) {
            return start;
        }
        return -1;
    }

    private int findLast(int[] nums, int target) {
        int start = 0, end = nums.length;
        while (start < end) {
            int mid = (end - start) / 2 + start;
            if (nums[mid] > target) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        if (end > 0 && nums[end - 1] == target) {
            return end - 1;
        }
        return -1;
    }

    static class Solution {
        public int[] searchRange(int[] nums, int target) {
            int[] res = new int[]{-1, -1};
            if (nums == null || nums.length == 0) {return res;}
            if (target < nums[0] || target > nums[nums.length - 1]) {return res;}
            // unknown: first target, end target
            // data: sorted, maybe repeat nums in array, array length, array start and end
            // target, maybe target not exist
            // similar: binary search
            int start = findStart(nums, target);
            if (start == -1) {return res;}
            int end = findEnd(nums, target);
            return new int[]{start, end};
        }

        private static int findStart(int[] nums, int target) {
            int start = 0, end = nums.length - 1;
            while (start + 1 < end) {
                int mid = (end - start) / 2 + start;
                if (nums[mid] >= target) {
                    end = mid;
                } else {
                    start = mid;
                }
            }
            if (nums[start] == target) {return start;}
            else if (nums[end] == target) {return end;}
            else {return -1;}
        }

        private static int findEnd(int[] nums, int target) {
            int start = 0, end = nums.length - 1;
            while (start + 1 < end) {
                int mid = (end - start) / 2 + start;
                if (nums[mid] <= target) {
                    start = mid;
                } else {
                    end = mid;
                }
            }
            if (nums[end] == target) {return end;}
            else if (nums[start] == target) {return start;}
            else {return -1;}
        }
    }

}
