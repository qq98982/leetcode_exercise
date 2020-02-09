package com.home.henry.math_03;

/**
 * 367. Valid Perfect Square
 *
 * Given a positive integer num, write a function which returns True if num is a perfect square else False.
 *
 * Note: Do not use any built-in library function such as sqrt.
 *
 * Input: 16 Output: true
 * Input: 14 Output: false
 * notice test cases: 2147483647 1
 * 1
 */
public class ValidPerfectSquare_L367_011 {
    static class Solution {
        public boolean isPerfectSquare(int num) {
            int low = 1, high = num, mid = (high - low) / 2 + low;
            while (low <= high) {
                if (mid * mid == num) {
                    return true;
                }
                // 因为有mid * mid overflow的问题, 所以需要处理一下
                if (mid > num / mid) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
                mid = (high - low) / 2 + low;
            }
            return false;
        }
    }
}
