package com.home.henry.math_03;

/**
 * 258. Add Digits
 *
 * Given a non-negative integer num, repeatedly add all its digits until the result has only one digit.
 * Input: 38 Output: 2
 * Explanation: The process is like: 3 + 8 = 11, 1 + 1 = 2.
 *              Since 2 has only one digit, return it.
 * Follow up: Could you do it without any loop/recursion in O(1) runtime?
 */
public class L258_AddDigits_005 {
    static class Solution {

        //用递归, 要使用[]
        public int addDigits(int num) {
            int[] res = {0};
            helper(res, num);
            return res[0];
        }
        void helper(int[] res, int num) {
            while (num != 0) {
                res[0] = res[0] + num % 10;
                num = num / 10;
            }
            if (res[0] > 9) {
                num = res[0];
                res[0] = 0;
                helper(res, num);
            }
        }

        // 要寻找规律
        public int addDigitsSec(int num) {
            if (num == 0){
                return 0;
            }
            if (num % 9 == 0){
                return 9;
            }
            else {
                return num % 9;
            }
        }
    }
}
