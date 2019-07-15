package com.home.henry.others;

import java.util.ArrayList;
import java.util.List;

/**
 * FB Phone screen
 * Question:
 * Add (insert) the mathematical operators + or - (plus or minus) before any of the digits in the decimal numeric string "123456789" such that the resulting mathematical expression adds up to a particular target sum. Return all possible combinations. https://rosettacode.org/wiki/Sum_to_100
 *
 * Example: 123 + 4 - 5 + 67 - 89 = 100
 * Similar 282, 282是典型的back tracking
 * 在这个题目里, 不用pre也可以的, 因为不涉及乘法
 */
public class SumToTarget_FB {

    static class Solution {
        List<String> sumToTarget(String str, int target) {
            List<String> res = new ArrayList<>();
            helper(res, "", str, target, 0, 0);
            return res;
        }

        private void helper(List<String> res, String path, String str, int target, int pos, long val) {
            if (pos == str.length()) {
                if (target == val) {
                    res.add(path);
                    return;
                }
            }

            for (int i = pos; i < str.length(); i++) {
                if (i != pos && str.charAt(pos) == '0') {break;}
                long cur = Long.parseLong(str.substring(pos, i + 1));
                if (pos == 0) {
                    helper(res, path + cur, str, target, i + 1, cur);
                } else {
                    helper(res, path + "+" + cur, str, target, i + 1, val + cur);
                    helper(res, path + "-" + cur, str, target, i + 1, val - cur);
                }
            }
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.sumToTarget("123456789", 100));
    }
}
