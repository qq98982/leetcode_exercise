package com.home.henry.dp_06;

import java.util.Arrays;

/**
 * 300. Longest Increasing Subsequence
 * Given an unsorted array of integers, find the length of longest increasing subsequence.
 *
 * Example: Input: [10,9,2,5,3,7,101,18] Output: 4
 * Explanation: The longest increasing subsequence is [2,3,7,101], therefore the length is 4.
 * explanation in 9c dp video 4, nlogn的方法可以是下面这个, 也可以看zcy的书
 */
public class L300_LongestIncreasingSubsequence_015 {

    // O(n^2)
    static class SolutionDP {
        public static int lengthOfLIS(int[] nums) {
            if (nums == null || nums.length == 0) {
                return 0;
            }
            int[] f = new int[nums.length];
            Arrays.fill(f, 1);
            for (int i = 1; i < nums.length; i++) {
                for (int j = 0; j < i; j++) {
                    if (nums[i] > nums[j]) {
                        f[i] = Math.max(f[i], f[j] + 1);
                    }
                }
            }
            int max = f[0];
            for (int i = 1; i < nums.length; i++) {
                max = Math.max(f[i], max);
            }
            return max;
        }
    }

    // O(nlogn)
    static class SolutionBS {
        public static int lengthOfLIS(int[] nums) {
            int[] tails = new int[nums.length];
            int res = 0;
            for (int num : nums) {
                int i = 0, j = res;
                while (i != j) {
                    int mid = (i + j) / 2;
                    if (tails[mid] < num) {
                        i = mid + 1;
                    } else {
                        j = mid;
                    }
                }
                tails[i] = num;
                System.out.println(Arrays.toString(tails));
                if (i == res) {
                    res++;
                }
            }
            return res;
        }
    }

    public static void main(String[] args) {
        System.out.println(SolutionBS.lengthOfLIS(new int[] { 10, 9, 2, 5, 3, 7, 101, 18 }));
    }
}
