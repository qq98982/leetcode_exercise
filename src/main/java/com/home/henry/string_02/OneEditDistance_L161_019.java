package com.home.henry.string_02;

/**
 * 161. One Edit Distance
 *
 * Given two strings  s  and  t , determine if they are both one edit distance apart.
 *
 * Note:
 *
 * There are 3 possiblities to satisify one edit distance apart:
 *
 * Insert a character into  s  to get  t
 * Delete a character from  s  to get  t
 * Replace a character of  s  to get  t
 *
 * Input: _s_ = "ab", _t_ = "acb" Output: true
 * Explanation: We can insert 'c' into _s_  to get  _t._
 *
 * Input: _s_ = "cab", _t_ = "ad" Output: false
 * Explanation: We cannot get _t_ from _s_ by only one step.
 *
 * Input: _s_ = "1203", _t_ = "1213" Output: true
 * Explanation: We can replace '0' with '1' to get  _t._
 *
 * 对比两个字符串对应位置上的字符，如果遇到不同的时候，这时看两个字符串的长度关系，如果相等，则比较当前位置后的字串是否相同，
 * 如果s的长度大，那么比较s的下一个位置开始的子串，和t的当前位置开始的子串是否相同，反之如果t的长度大，则比较t的下一个位置开始的子串，
 * 和s的当前位置开始的子串是否相同。如果循环结束，都没有找到不同的字符，那么此时看两个字符串的长度是否相差1
 */
public class OneEditDistance_L161_019 {
    public static class Solution {
        public static boolean isOneEditDistance(String s, String t) {
            if (s == null || t == null) {return false;}
            if (Math.abs(s.length() - t.length()) > 1) {return false;}
            for (int i = 0; i < Math.min(s.length(), t.length()); i++) {
                if (s.charAt(i) != t.charAt(i)) {
                    if (s.length() > t.length()) {
                        return s.substring(i + 1).equals(t.substring(i));
                    } else if (s.length() < t.length()) {
                        return s.substring(i).equals(t.substring(i + 1));
                    } else {
                        return s.substring(i + 1).equals(t.substring(i + 1));
                    }
                }
            }
            return Math.abs(s.length() - t.length()) == 1;
        }
    }

    public static void main(String[] args) {
        assert Solution.isOneEditDistance("ab", "acb");
        assert !Solution.isOneEditDistance("cab", "ad");
        assert Solution.isOneEditDistance("1203", "1213");
    }
}
