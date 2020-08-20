package com.home.henry.math_03;

/**
 * 50. Pow(x, n)
 *
 * Implement pow(x, n), which calculates x raised to the power n (xn).
 *
 * Input: 2.00000, 10 Output: 1024.00000
 *
 * Input: 2.10000, 3 Output: 9.26100
 *
 * Input: 2.00000, -2 Output: 0.25000
 * Explanation: 2-2 = 1/22 = 1/4 = 0.25
 *
 * Note:
 * -100.0 < x < 100.0
 * n is a 32-bit signed integer, within the range [−231, 231 − 1]
 */
public class L050_Pow_X_010 {

    static class Solution {
        public double myPow(double x, int n) {
            if (x == 1 || n == 0) {return 1;}
            if (n == Integer.MIN_VALUE) {
                if (x == -1) {
                    return 1;
                } else {
                    return 0;
                }
            }
            if (n < 0) {
                n *= -1;
                x = 1 / x;
            }
            return (n % 2 == 0) ? myPow(x * x, n / 2) : x * myPow(x * x, n / 2);
        }
    }
}
