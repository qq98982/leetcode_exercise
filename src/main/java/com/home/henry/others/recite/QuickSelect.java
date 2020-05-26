package com.home.henry.others.recite;

import java.util.Arrays;

/**
 * Quick Select
 *
 * nums contains duplicate numbers
 */
public class QuickSelect {
    static class Solution {
        public static int select(int[] nums, int k) {
            int start = 0, end = nums.length - 1;
            while (true) {
                int p = partition(nums, start, end);
                if (p == -1) {
                    return -1;
                }
                if (p + 1 == k) {
                    return nums[p];
                } else if (p + 1 > k) {
                    end = p - 1;
                } else {
                    start = p + 1;
                }
            }
        }

        private static int partition(int[] nums, int start, int end) {
            if (start >= nums.length || end < 0) {
                return -1;
            }
            if (start == end) {return start;}
            int num = nums[start];
            int i = start, j = end + 1;
            while (true) {
                while (nums[++i] <= num) {
                    if (i == end) {break;}
                }
                while (nums[--j] >= num) {
                    if (j == start) {break;}
                }
                if (i >= j) {break;}
                exch(nums, i, j);
            }
            exch(nums, start, j);
            return j;
        }

        private static void exch(int[] nums, int i, int j) {
            int tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
        }
    }

    public static void main(String[] args) {
        int[] arr = { 10, 9, 11, 12, 15, 8, 2, 7 };
        System.out.println(Arrays.toString(arr));
        System.out.println(Solution.select(arr, 22));
        System.out.println(Arrays.toString(arr));
    }
}
