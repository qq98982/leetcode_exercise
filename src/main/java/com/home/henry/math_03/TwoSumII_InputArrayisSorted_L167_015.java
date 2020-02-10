package com.home.henry.math_03;

/**
 * 167. Two Sum II - Input array is sorted
 *
 * Given an array of integers that is already sorted in ascending order, find two numbers such that they
 * add up to a specific target number. The function twoSum should return indices of the two numbers such
 * that they add up to the target, where index1 must be less than index2.
 *
 * Input: numbers = [2,7,11,15], target = 9 Output: [1,2]
 * Explanation: The sum of 2 and 7 is 9. Therefore index1 = 1, index2 = 2.
 */
public class TwoSumII_InputArrayisSorted_L167_015 {

    static class Solution {
        public int[] twoSum(int[] numbers, int target) {
            // check low and high boundary
            int len = numbers.length;
            int[] res = new int[] { -1, -1 };
            // init low and high
            int start = 0, end = len - 1;
            if (start >= end) {return res;}
            if (numbers[len - 2] + numbers[len - 1] < target) {return res;}

            // while and check
            while (start + 1 < end) {
                if (numbers[start] + numbers[end] == target) {
                    return new int[] { start + 1, end + 1 };
                } else if (numbers[start] + numbers[end] < target) {
                    start++;
                } else {
                    end--;
                }
            }
            // return
            if (numbers[start] + numbers[end] != target) {
                return res;
            } else {
                return new int[] { start + 1, end + 1 };
            }
        }
    }
}
