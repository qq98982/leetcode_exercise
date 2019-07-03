package com.home.henry.array_01;

/**
 * 76. Minimum Window Substring
 *
 * Given a string S and a string T, find the minimum window in S which will contain all the characters in T in complexity O(n).
 * Input: S = "ADOBECODEBANC", T = "ABC" Output: "BANC"
 * Note: If there is no such window in S that covers all characters in T, return the empty string "".
 * If there is such window, you are guaranteed that there will always be only one unique minimum window in S.
 * Sliding window, 非常重要 这个题目根据模板做更好点
 */
public class MinimumWindowSubstring_L076_050 {

    static class Solution {
        public String minWindow(String s, String t) {
            int[] count = new int[128];
            for (char c : t.toCharArray()) {
                count[c]++;
            }

            int start = 0, end = 0, minStart = 0, minLen = Integer.MAX_VALUE, counter = t.length();
            while (end < s.length()) {
                char c1 = s.charAt(end);
                if (count[c1] > 0) {
                    counter--;
                }
                count[c1]--;
                end++;
                while (counter == 0) {
                    char c2 = s.charAt(start);
                    count[c2]++;
                    if (count[c2] > 0) {
                        counter++;
                        if (minLen > end - start) {
                            minLen = end - start;
                            minStart = start;
                        }
                    }
                    start++;
                }
            }
            return minLen == Integer.MAX_VALUE ? "" : s.substring(minStart, minStart + minLen);
        }
    }

}
