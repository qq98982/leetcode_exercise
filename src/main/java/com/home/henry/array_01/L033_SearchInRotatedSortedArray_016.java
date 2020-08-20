package com.home.henry.array_01;

/**
 * 33. Search in Rotated Sorted Array
 *
 * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
 * (i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]).
 * You are given a target value to search. If found in the array return its index, otherwise return -1.
 * You may assume no duplicate exists in the array.
 * Your algorithm's runtime complexity must be in the order of O(log n).
 *
 * Input: nums = [4,5,6,7,0,1,2], target = 0 Output: 4
 * Input: nums = [4,5,6,7,0,1,2], target = 3 Output: -1
 *
 * 这个用的是binary search方法, 下面是两种解法, 推荐第二种(left + 1 < right)
 */
public class L033_SearchInRotatedSortedArray_016 {

    static class Solution {
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

    static class Solution2 {
        // at least ons part is sorted
        public static int search(int[] nums, int target) {
            if (nums == null || nums.length == 0) {
                return -1;
            }
            int start = 0, end = nums.length - 1;
            while (start + 1 < end) {
                int mid = (end - start) / 2 + start;
                if (nums[mid] == target) {return mid;}
                if (nums[start] < nums[mid]) {
                    // left part is sorted
                    if (nums[start] <= target && target <= nums[mid]) {
                        end = mid;
                    } else {
                        start = mid;
                    }
                } else {
                    // right part is sorted
                    if (nums[mid] <= target && target <= nums[end]) {
                        start = mid;
                    } else {
                        end = mid;
                    }
                }
            }
            if (nums[start] == target) {
                return start;
            }
            if (nums[end] == target) {
                return end;
            }
            return -1;
        }
    }

    public static void main(String[] args) {
        int[] nums = { 4, 5, 6, 7, 0, 1, 2 };
        System.out.println("4 -> " + Solution2.search(nums, 0));
        System.out.println("-1 -> " + Solution2.search(nums, 3));
        System.out.println("0 -> " + Solution2.search(new int[] { 1, 3, 5 }, 1));
        System.out.println("5 -> " + Solution2.search(new int[] { 4, 5, 6, 7, 0, 1, 2 }, 1));
        System.out.println("-1 -> " + Solution2.search(new int[] { 1, 3 }, 2));
    }
}
