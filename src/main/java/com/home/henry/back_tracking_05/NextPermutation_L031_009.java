package com.home.henry.back_tracking_05;

import java.util.Arrays;

/**
 * 31. Next Permutation
 *
 * Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of
 * numbers. If such arrangement is not possible, it must rearrange it as the lowest possible order
 * (ie, sorted in ascending order).
 *
 * 1,2,3 → 1,3,2
 * 3,2,1 → 1,2,3
 * 1,1,5 → 1,5,1
 *
 * 这个主要是从后往前找出第一个first small, firstSmall = nums[i] < nums[i + 1]
 * 然后找出第一个比这个firstSmall大的数字
 * 交换这两个数字后, 将这个small后的数字全部反转(如果没有firstSmall, 那就是全部反转)
 * 1 2 7 4 3 1 firstSmall = 2, nums[firstSmall] = 2, firstLarge = 4, nums[firstLarge] = 3
 */
public class NextPermutation_L031_009 {

    // eg: 1 2 7 4 3 1
    static class Solution {
        public void nextPermutation(int[] nums) {
            if (nums == null || nums.length == 0) {return;}
            // 找到第一个不再递增的位置
            int firstSmall = -1;
            for (int i = nums.length - 2; i >= 0; i--) {
                if (nums[i] < nums[i + 1]) {
                    firstSmall = i;
                    // 找到了要break 2 < 7
                    // firstSmall = 1 nums[firstSmall]= 2
                    break;
                }
            }
            // 如果数组本来就是倒序的
            if (firstSmall == -1) {
                reverse(nums, 0, nums.length - 1);
                // 记得return
                return;
            }

            //找到刚好大于 nums[firstSmall]的位置
            // firstBig = 4 nums[firstBig] = 3
            int firstLarge = -1;
            for (int i = nums.length - 1; i >= 0; i--) {
                if (nums[i] > nums[firstSmall]) {
                    firstLarge = i;
                    // 3 > 2
                    // 找到了要break
                    break;
                }
            }
            // 1 2 7 4 3 1 -> 1 3 7 4 2 1
            swap(nums, firstSmall, firstLarge);
            // 需要reverse 1 3 (7 4 2 1)
            reverse(nums, firstSmall + 1, nums.length - 1);
            // 1 2 7 4 3 1 -> 1 3 1 2 4 7
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
        int[] numsSec = { 1, 2, 7, 4, 3, 1 };
        so.nextPermutation(numsSec);
        System.out.println(Arrays.toString(numsSec));
    }
}
