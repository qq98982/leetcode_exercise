package com.home.henry.string_02;

/**
 * 132. Palindrome Partitioning II
 *
 * Given a string s, partition s such that every substring of the partition is a palindrome.
 * Return the minimum cuts needed for a palindrome partitioning of s.
 *
 * Input: "aab" Output: 1
 * Explanation: The palindrome partitioning ["aa","b"] could be produced using 1 cut.
 */
public class L132_PalindromePartitioningII_27 {
    /**
     * DP的解法
     *
     * if charAt(left) == charAt(right) means s.substring(left, right + 1) is palindrome
     * then f[left - 1] + 1 = f[right], adding 1 because left and right substring need 1 cut
     */
    static class Solution {
        public int minCut(String s) {
            int[] f = new int[s.length()];
            for (int i = 0; i < s.length(); i++) {
                f[i] = i;
            }
            for (int i = 0; i < s.length(); i++) {
                search(s, f, i, i);
                search(s, f, i, i + 1);
            }
            return f[s.length() - 1];
        }

        private static void search(String s, int[] f, int left, int right) {
            while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
                if (left == 0) {
                    f[right] = 0;
                } else {
                    f[right] = Math.min(f[right], f[left - 1] + 1);
                }
                left--;
                right++;
            }
        }
    }
}
