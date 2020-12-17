package com.home.henry.dp_06;

/**
 * 10. Regular Expression Matching
 *
 * Given an input string (s) and a pattern (p), implement regular expression matching with support for '.' and '*'.
 *
 * '.' Matches any single character.
 * '*' Matches zero or more of the preceding element.
 * The matching should cover the entire input string (not partial).
 *
 * s could be empty and contains only lowercase letters a-z.
 * p could be empty and contains only lowercase letters a-z, and characters like . or *.
 *
 * Input: s = "aa" p = "a" Output: false
 * Explanation: "a" does not match the entire string "aa".
 *
 * Input: s = "aa" p = "a*" Output: true
 * Explanation: '*' means zero or more of the preceding element, 'a'. Therefore, by repeating 'a' once,
 * it becomes "aa".
 *
 * Input: s = "ab" p = ".*" Output: true
 * Explanation: ".*" means "zero or more (*) of any character (.)".
 *
 * Input: s = "aab" p = "c*a*b" Output: true
 * Explanation: c can be repeated 0 times, a can be repeated 1 time. Therefore, it matches "aab".
 *
 * Input: s = "mississippi" p = "mis*is*p*." Output: false
 */
public class L010_RegularExpressionMatching_012 {

    /*
    This Solution use 2D DP. beat 90% solutions, very simple.

    Here are some conditions to figure out, then the logic can be very straightforward.

    1, If p.charAt(j) == s.charAt(i) :  dp[i][j] = dp[i-1][j-1];
    2, If p.charAt(j) == '.' : dp[i][j] = dp[i-1][j-1];
    3, If p.charAt(j) == '*':
    here are two sub conditions:
           1   if p.charAt(j-1) != s.charAt(i) : dp[i][j] = dp[i][j-2]  //in this case, a* only counts as empty
           2   if p.charAt(i-1) == s.charAt(i) or p.charAt(i-1) == '.':
                          dp[i][j] = dp[i-1][j]    //in this case, a* counts as multiple a
                       or dp[i][j] = dp[i][j-1]   // in this case, a* counts as single a
                       or dp[i][j] = dp[i][j-2]   // in this case, a* counts as empty
     */
    static class Solution {
        public static boolean isMatch(String s, String p) {

            if (s == null || p == null) {
                return false;
            }
            boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
            dp[0][0] = true;
            for (int i = 0; i < p.length(); i++) {
                if (p.charAt(i) == '*' && dp[0][i - 1]) {
                    dp[0][i + 1] = true;
                }
            }
            for (int i = 0; i < s.length(); i++) {
                for (int j = 0; j < p.length(); j++) {
                    if (p.charAt(j) == '.') {
                        dp[i + 1][j + 1] = dp[i][j];
                    }
                    if (p.charAt(j) == s.charAt(i)) {
                        dp[i + 1][j + 1] = dp[i][j];
                    }
                    if (p.charAt(j) == '*') {
                        if (p.charAt(j - 1) != s.charAt(i) && p.charAt(j - 1) != '.') {
                            dp[i + 1][j + 1] = dp[i + 1][j - 1];
                        } else {
                            dp[i + 1][j + 1] = (dp[i + 1][j] || dp[i][j + 1] || dp[i + 1][j - 1]);
                        }
                    }
                }
            }
            return dp[s.length()][p.length()];
        }
    }

    public static void main(String[] args) {
        System.out.println("true -> " + Solution.isMatch("aa", "a*"));
        System.out.println("true -> " + Solution.isMatch("ab", ".*"));
        System.out.println("true -> " + Solution.isMatch("aab", "c*a*b"));
        System.out.println("false -> " + Solution.isMatch("aa", "a"));
        System.out.println("false -> " + Solution.isMatch("aa", "c**"));
        System.out.println("false -> " + Solution.isMatch("mississippi", "mis*is*p*."));
    }
}
