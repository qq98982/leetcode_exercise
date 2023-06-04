package com.home.henry.string_02;

import java.util.Arrays;

/**
 * 5. Longest Palindromic Substring
 *
 * Input: "babad" Output: "bab"
 * Input: "cbbd" Output: "bb"
 * 这个用了Manacher算法, O(n)的复杂度, 其他的方法最少是O(n^2)
 */
public class L005_LongestPalindromicSubstring_024 {

    public String longestPalindrome(String s) {
        // change s to an array with '#'s
        char[] ch = preHandle(s);
        int[] p = new int[ch.length];
        int C = -1, R = -1, start = 0, max = Integer.MIN_VALUE;
        for (int i = 0; i < ch.length; i++) {
            p[i] = R > i ? Math.min(p[2 * C - i], R - i) : 1;
            while (i - p[i] > -1 && i + p[i] < ch.length) {
                if (ch[i - p[i]] == ch[i + p[i]]) {
                    p[i]++;
                } else {
                    break;
                }
            }
            if (i + p[i] > R) {
                R = i + p[i];
                C = i;
            }
            if (p[i] > max) {
                max = p[i];
                start = i;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = start - max + 2; i < start + max; i += 2) {
            sb.append(ch[i]);
        }
        return sb.toString();
    }

    private static char[] preHandle(String s) {
        char[] c = s.toCharArray();
        char[] res = new char[c.length * 2 + 1];
        int index = 0;
        for (int i = 0; i != res.length; i++) {
            res[i] = (i % 2) == 0 ? '#' : c[index++];
        }
        return res;
    }

    private int getPalindromeLength(StringBuilder sb, int index, int length) {
        int st = index - length - 1;
        int end = index + length + 1;

        while (st >= 0 && end < sb.length()) {
            if (sb.charAt(st--) == sb.charAt(end++)) {
                length++;
            } else {
                break;
            }
        }
        return length;
    }

    public String longestPalindrome2(String s) {

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            sb.append('#');
            sb.append(s.substring(i, i + 1));
        }
        sb.append('#');

        int[] length = new int[sb.length()];
        Arrays.fill(length, 0);

        int center = 0;
        int rightBoundary = 0;
        int maxIndex = 0;

        for (int i = 1; i < sb.length(); i++) {
            int mirror = 2 * center - i;

            if (i < rightBoundary) {
                length[i] = Math.min(length[mirror], rightBoundary - i);
            }

            length[i] = getPalindromeLength(sb, i, length[i]);

            if (i + length[i] > rightBoundary) {
                center = i;
                rightBoundary = i + length[i];
            }

            if (length[maxIndex] < length[i]) {
                maxIndex = i;
            }
        }

        StringBuilder res = new StringBuilder();

        int start = maxIndex - length[maxIndex];
        int end = maxIndex + length[maxIndex];

        for (int i = start; i <= end; i++) {
            if (sb.charAt(i) != '#') {res.append(sb.substring(i, i + 1));}
        }

        return res.toString();
    }

    public String longestPalindrome3(String s) {
        if (s == null || s.length() == 0) return s;
        String res = "";
        boolean[][] dp = new boolean[s.length()][s.length()];
        int max = 0;
        for (int j = 0; j < s.length(); j++) {
            for (int i = 0; i <= j; i++) {
                dp[i][j] = s.charAt(i) == s.charAt(j) && ((j - i <= 2) || dp[i + 1][j - 1]);
                if (dp[i][j]) {
                    if (j - i + 1 > max) {
                        max = j - i + 1;
                        res = s.substring(i, j + 1);
                    }
                }
            }
        }
        return res;
    }

}
