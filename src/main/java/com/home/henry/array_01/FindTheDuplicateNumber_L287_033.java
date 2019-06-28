package com.home.henry.array_01;

/**
 * 287. Find the Duplicate Number
 * 这个题目可以参考142的linked list loop问题(O(n)), 还可以用二分法做(O(nlogn))
 */
public class FindTheDuplicateNumber_L287_033 {

    static class Solution {
        public int findDuplicate(int[] nums) {
            int slow = 0, fast = 0;
            while (true) {
                fast = nums[nums[fast]];
                slow = nums[slow];
                if (fast == slow) { break; }
            }
            fast = 0;
            while (fast != slow) {
                fast = nums[fast];
                slow = nums[slow];
            }
            return fast;
        }
    }

    static class SolutionBS {
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
