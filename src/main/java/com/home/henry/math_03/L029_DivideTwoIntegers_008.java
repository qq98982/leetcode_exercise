package com.home.henry.math_03;

/**
 * 29. Divide Two Integers
 */
public class L029_DivideTwoIntegers_008 {
    /**
     * 有四种情况:
     * 1, + -
     * 2, 越界
     * 3, = 0
     * 4, 正常
     * 注意ldivide中的while和if
     */
    static class Solution {

        public int divide(int dividend, int divisor) {

            int sign = 1;
            if ((dividend > 0 && divisor < 0) || (dividend < 0 && divisor > 0)) {sign = -1;}
            long ldivided = Math.abs((long) dividend);
            long ldivisor = Math.abs((long) divisor);
            if (ldivided < ldivisor || ldivided == 0) {return 0;}
            long lres = ldivide(ldivided, ldivisor);
            int res;
            if (lres > Integer.MAX_VALUE) {
                res = (sign == 1) ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            } else {
                res = (int) (sign * lres);
            }
            return res;
        }

        private long ldivide(long ldivided, long ldivisor) {
            if (ldivided < ldivisor) {return 0;}
            long sum = ldivisor;
            long mul = 1;
            // 如果sum + sum <= 没有这个=号, 会多次进入return中的divide方法. 时间和空间都是O(logn)
            // 没有=号, 运行是一样结果, 空间会比log n小
            while ((sum + sum) <= ldivided) {
                sum += sum;
                mul += mul;
            }
            return mul + ldivide(ldivided - sum, ldivisor);
        }
    }

}
