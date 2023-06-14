package com.home.henry.binary_search_08;

import java.util.Arrays;

/**
 * 1498. Number of Subsequences That Satisfy the Given Sum Condition
 *
 * You are given an array of integers nums and an integer target.
 *
 * Return the number of non-empty subsequences of nums such that the sum of the minimum
 * and maximum element on it is less or equal to target. Since the answer may be too large,
 * return it modulo 10^9 + 7.
 *
 * Input: nums = [3,5,6,7], target = 9 Output: 4
 * Explanation: There are 4 subsequences that satisfy the condition.
 * [3] -> Min value + max value <= target (3 + 3 <= 9)
 * [3,5] -> (3 + 5 <= 9)
 * [3,5,6] -> (3 + 6 <= 9)
 * [3,6] -> (3 + 6 <= 9)
 *
 * Input: nums = [3,3,6,8], target = 10 Output: 6
 * Explanation: There are 6 subsequences that satisfy the condition. (nums can have repeated numbers).
 * [3] , [3] , [3,3], [3,6] , [3,6] , [3,3,6]
 *
 * Input: nums = [2,3,3,4,6,7], target = 12 Output: 61
 * Explanation: There are 63 non-empty subsequences, two of them do not satisfy the condition ([6,7], [7]).
 * Number of valid subsequences (63 - 2 = 61).
 */
public class L1498_NumberOfSubsequencesThatSatisfyTheGivenSumCondition_025 {

    public int numSubseq(int[] nums, int target) {
        Arrays.sort(nums);
        int res = 0, left = 0, right = nums.length - 1, mod = (int) 1e9 + 7;
        int[] pows = new int[nums.length];
        pows[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            pows[i] = pows[i - 1] * 2 % mod;
        }
        while (left <= right) {
            if (nums[left] + nums[right] > target) {
                right--;
            } else {
                res = (res + pows[right - left++]) % mod;
            }
        }
        return res;
    }
}
