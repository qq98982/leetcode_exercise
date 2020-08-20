package com.home.henry.string_02;

/**
 * 5. Longest Palindromic Substring
 * Input: "babad" Output: "bab"
 * Input: "cbbd" Output: "bb"
 * 这个用了Manacher算法, O(n)的复杂度, 其他的方法最少是O(n^2)
 */
public class L005_LongestPalindromicSubstring_024 {

    static class Solution {
        public String longestPalindrome(String s) {
            if (s == null || s.length() < 2) {return s;}
            char[] c = s.toCharArray();
            char[] helper = new char[c.length * 2 + 1];
            int index = 0;
            for (int i = 0; i != helper.length; i++) {
                if ((i & 1) == 0) {
                    helper[i] = '#';
                } else {
                    helper[i] = c[index++];
                }
            }
            int max = Integer.MIN_VALUE;
            int R = -1;
            int C = -1;
            int start = 0;
            int[] pArr = new int[helper.length];

            for (int i = 0; i != helper.length; i++) {
                pArr[i] = R > i ? Math.min(pArr[2 * C - i], R - i) : 1;
                while (i + pArr[i] < helper.length && i - pArr[i] > -1) {
                    if (helper[i + pArr[i]] == helper[i - pArr[i]]) {
                        pArr[i]++;
                    } else {
                        break;
                    }
                }
                if (i + pArr[i] > R) {
                    R = i + pArr[i];
                    C = i;
                }
                if (pArr[i] > max) {
                    max = pArr[i];
                    start = 2 * C - i;
                }
            }
            StringBuilder sb = new StringBuilder();
            for (int i = start - max + 2; i < start + max; i += 2) {
                sb.append(helper[i]);
            }
            return sb.toString();
        }
    }

}
