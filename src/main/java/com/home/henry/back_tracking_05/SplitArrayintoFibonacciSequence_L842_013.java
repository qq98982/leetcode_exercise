package com.home.henry.back_tracking_05;

import java.util.ArrayList;
import java.util.List;

/**
 * 842. Split Array into Fibonacci Sequence
 *
 * Given a string S of digits, such as S = "123456579", we can split it into a Fibonacci-like sequence [123, 456, 579].
 *
 * Formally, a Fibonacci-like sequence is a list F of non-negative integers such that:
 *
 *     0 <= F[i] <= 2^31 - 1, (that is, each integer fits a 32-bit signed integer type);
 *     F.length >= 3;
 *     and F[i] + F[i+1] = F[i+2] for all 0 <= i < F.length - 2.
 *
 * Also, note that when splitting the string into pieces, each piece must not have extra leading zeroes, except if the piece is the number 0 itself.
 *
 * Return any Fibonacci-like sequence split from S, or return [] if it cannot be done.
 *
 * Input: "123456579" Output: [123,456,579]
 *
 * Input: "11235813" Output: [1,1,2,3,5,8,13]
 *
 * Input: "112358130" Output: []
 * Explanation: The task is impossible.
 *
 * Input: "0123" Output: []
 * Explanation: Leading zeroes are not allowed, so "01", "2", "3" is not valid.
 *
 * Input: "1101111" Output: [110, 1, 111]
 * Explanation: The output [11, 0, 11, 11] would also be accepted.
 *
 * Note: 1 <= S.length <= 200,  S contains only digits.
 */
public class SplitArrayintoFibonacciSequence_L842_013 {
    static class Solution {
        public List<Integer> splitIntoFibonacci(String S) {
            List<Integer> res = new ArrayList<>();
            helper(res, S, null, null, 0);
            return res;
        }

        private static boolean helper(List<Integer> res, String s, Integer f1, Integer f2, Integer pos) {
            if (pos == s.length()) {
                return res.size() >= 3;
            }
            int num = 0, i = pos;
            do {
                int digit = s.charAt(i) - '0';
                int prev = num;
                num = num * 10 + digit;
                if ((num - digit) / 10 != prev) {return false;} // not equals due to overflow Integer
                if (isSeq(f1, f2, num)) {
                    res.add(num);
                    if (helper(res, s, f2, num, i + 1)) {
                        return true;
                    }
                    res.remove(res.size() - 1);
                }
                i++;
            } while (i < s.length() && s.charAt(pos) != '0');
            return false;
        }

        private static boolean isSeq(Integer f1, Integer f2, Integer num) {
            return f1 == null || f2 == null || f1 + f2 == num;
        }
    }
}
