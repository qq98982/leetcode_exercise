package com.home.henry.math_03;

/**
 * 231. Power of Two
 *
 * Given an integer n, return true if it is a power of two. Otherwise, return false.
 *
 * An integer n is a power of two, if there exists an integer x such that n == 2x.
 *
 * Input: n = 1 Output: true
 * Input: n = 16 Output: true
 * Input: n = 3 Output: false
 */
public class L231_PowerOfTwo_017 {
    public boolean isPowerOfTwo(int n) {
        if (n == 1) {
            return true;
        } else if (n == 0) {
            return false;
        } else if (n % 2 == 1) {
            return false;
        } else {
            return isPowerOfTwo(n / 2);
        }
    }
}
