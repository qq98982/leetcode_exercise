package com.home.henry.array_01;

/**
 * 287. Find the Duplicate Number
 * Given an array nums containing n + 1 integers where each integer is between 1 and n (inclusive), prove that
 * at least one duplicate number must exist. Assume that there is only one duplicate number, find the duplicate one.
 * <p>
 * Input: [1,3,4,2,2] Output: 2
 * <p>
 * Input: [3,1,3,4,2] Output: 3 Note:
 * <p>
 * You must not modify the array (assume the array is read only).
 * You must use only constant, O(1) extra space.
 * Your runtime complexity should be less than O(n2).
 * There is only one duplicate number in the array, but it could be repeated more than once.
 * 这个题目可以参考142的linked list loop问题(O(n)), 还可以用二分法做(O(nlogn))
 * 二分法中推荐start + 1 < end
 */
public class L287_FindTheDuplicateNumber_033 {

    static class Solution {
        public int findDuplicate(int[] nums) {
            int slow = 0, fast = 0;
            do {
                fast = nums[nums[fast]];
                slow = nums[slow];
            } while (fast != slow);
            fast = 0;
            while (fast != slow) {
                fast = nums[fast];
                slow = nums[slow];
            }
            return fast;
        }

    }

    static class SolutionBS {

        public int findDuplicate2(int[] nums) {
            int min = 0, max = nums.length - 1;
            while (min + 1 < max) {
                int mid = (max - min) / 2 + min;
                int count = 0;
                for (int i = 0; i < nums.length; i++) {
                    if (nums[i] <= mid) {
                        count++;
                    }
                }
                if (count > mid) {
                    max = mid;
                } else {
                    min = mid;
                }
            }
            return min + 1;
        }
        public int findDuplicate(int[] nums) {
            int min = 0, max = nums.length - 1;
            while (min < max) {
                int mid = (max - min) / 2 + min;
                int count = 0;
                for (int i = 0; i < nums.length; i++) {
                    if (nums[i] <= mid) {
                        count++;
                    }
                }
                if (count > mid) {
                    max = mid - 1;
                } else {
                    min = mid + 1;
                }
            }
            return min;
        }
    }
}
