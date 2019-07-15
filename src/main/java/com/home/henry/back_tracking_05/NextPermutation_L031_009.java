package com.home.henry.back_tracking_05;

import java.util.Arrays;

/**
 * 31. Next Permutation
 * 这个主要是从后往前找出第一个first small, firstSmall = nums[i] < nums[i + 1]
 * 然后找出第一个比这个firstSmall大的数字
 * 交换这两个数字后, 将这个small后的数字全部反转(如果没有firstSmall, 那就是全部反转)
 * 1 2 7 4 3 1 firstSmall = 2, nums[firstSmall] = 2, firstLarge = 4, nums[firstLarge] = 3
 */
public class NextPermutation_L031_009 {

    static class Solution {
        public void nextPermutation(int[] nums) {
            if (nums == null || nums.length == 0) {return;}
            int firstSmall = -1;
            for (int i = nums.length - 2; i >= 0; i--) {
                if (nums[i] < nums[i + 1]) {
                    firstSmall = i;
                    break;
                }
            }
            if (firstSmall == -1) {
                reverse(nums, 0, nums.length - 1);
                return;
            }

            int firstLarge = -1;
            for (int i = nums.length - 1; i >= 0; i--) {
                if (nums[i] > nums[firstSmall]) {
                    firstLarge = i;
                    break;
                }
            }
            swap(nums, firstSmall, firstLarge);
            reverse(nums, firstSmall + 1, nums.length - 1);
            return;
        }

        private void swap(int[] nums, int start, int end) {
            int tmp = nums[start];
            nums[start] = nums[end];
            nums[end] = tmp;
        }

        private void reverse(int[] nums, int start, int end) {
            while (start < end) {
                swap(nums, start++, end--);
            }
        }
    }

    public static void main(String[] args) {
        Solution so = new Solution();
        int[] nums = { 1, 5, 2 };
        so.nextPermutation(nums);
        System.out.println(Arrays.toString(nums));
        int[] numsSec = {1, 2, 7, 4, 3, 1};
        so.nextPermutation(numsSec);
        System.out.println(Arrays.toString(numsSec));

    }
}
