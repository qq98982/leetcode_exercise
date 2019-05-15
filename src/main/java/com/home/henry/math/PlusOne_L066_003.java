package com.home.henry.math;

/**
 * 66. Plus One
 *
 * Given a non-empty array of digits representing a non-negative integer, plus one to the integer.
 * The digits are stored such that the most significant digit is at the head of the list, and each element in the array contain a single digit.
 * You may assume the integer does not contain any leading zero, except the number 0 itself.
 * Input: [1,2,3] Output: [1,2,4] Explanation: The array represents the integer 123.
 * Input: [4,3,2,1] Output: [4,3,2,2] Explanation: The array represents the integer 4321.
 * 比较巧妙的是如果<9后++return, 否则设置为0, 注意还要继续走循环的, 这样就能完成任务
 */
public class PlusOne_L066_003 {
    static class Solution {
        public int[] plusOne(int[] digits) {
            if (digits == null || digits.length == 0 ) {return digits;}
            for (int i = digits.length - 1; i >= 0; i--) {
                if (digits[i] < 9) {
                    digits[i]++;
                    return digits;
                } else {
                    digits[i] = 0;
                }
            }
            int[] res = new int[digits.length + 1];
            for (int i = 0; i < digits.length; i++) {
                res[i + 1] = digits[i];
            }
            res[0] = 1;
            return res;
        }
    }
}
