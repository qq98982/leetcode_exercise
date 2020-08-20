package com.home.henry.dp_06;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

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
    static class Solution {
        public static boolean isMatch(String s, String p) {
            return true;
        }
    }

    public static void main(String[] args) {
        Solution.isMatch("", "");
    }
}
