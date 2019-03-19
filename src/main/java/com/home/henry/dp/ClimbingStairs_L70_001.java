package com.home.henry.dp;

/**
 * You are climbing a stair case. It takes n steps to reach to the top.
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 * Input: 3 Output: 3
 */
public class ClimbingStairs_L70_001 {

    public int climbStairs(int n) {
        if (n <= 1) {
            return n;
        }
        int one = 1, two = 1, res = 0;
        for (int i = 2; i <= n; i++) {
            res = one + two;
            two = one;
            one = res;
        }
        return res;
    }

}
