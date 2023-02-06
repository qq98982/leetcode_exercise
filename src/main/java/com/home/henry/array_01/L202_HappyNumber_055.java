package com.home.henry.array_01;

import java.util.HashSet;
import java.util.Set;

/**
 * 202. Happy Number
 *
 * Write an algorithm to determine if a number n is happy.
 *
 * A happy number is a number defined by the following process:
 *
 * Starting with any positive integer, replace the number by the sum of the squares of its digits.
 * Repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a
 * cycle which does not include 1.
 * Those numbers for which this process ends in 1 are happy.
 * Return true if n is a happy number, and false if not.
 *
 * Input: n = 19 Output: true
 * Explanation:
 * 1^2 + 9^2 = 82
 * 8^2 + 2^2 = 68
 * 6^2 + 8^2 = 100
 * 1^2 + 0^2 + 0^2 = 1
 *
 * Input: n = 2 Output: false
 */
public class L202_HappyNumber_055 {
    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        while (getNum(n) != 1) {
            n = getNum(n);
            if (!set.add(n)) {
                return false;
            }
        }
        return true;
    }
    int getNum(int n) {
        int res = 0;
        while (n != 0) {
            res += Math.pow(n % 10, 2);
            n /= 10;
        }
        return res;
    }
}
