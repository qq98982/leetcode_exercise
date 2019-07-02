package com.home.henry.array_01;

/**
 * 268. Missing Number
 * 这个和448. Find All Numbers Disappeared in an Array相似, 但是做法很不同(应该是这个有0的关系)
 * 这个题有三种做法,XOR, BS, SUM, 其中SUM最简单
 */
public class MissingNumber_L268_046 {
    static class Solution {
        public int missingNumber(int[] nums) {
            long sum = nums[0];
            for (int i = 1; i < nums.length; i++) {
                sum = sum + nums[i];
            }
            return (int) (nums.length * (nums.length + 1) / 2 - sum);
        }
    }

    /**
     * The basic idea is to use XOR operation. We all know that a^b^b =a, which means two xor operations with
     * the same number will eliminate the number and reveal the original number.
     * In this solution, I apply XOR operation to both the index and value of the array. In a complete array
     * with no missing numbers, the index and value should be perfectly corresponding( nums[index] = index),
     * so in a missing array, what left finally is the missing number.
     */
    static class SolutionBit {
        public int missingNumber(int[] nums) {
            int xor = 0, i = 0;
            for (i = 0; i < nums.length; i++) {
                xor = xor ^ i ^ nums[i];
            }

            return xor ^ i;
        }
    }
}
