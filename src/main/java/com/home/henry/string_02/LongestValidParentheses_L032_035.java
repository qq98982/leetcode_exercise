package com.home.henry.string_02;

import java.util.Stack;

/**
 * 32. Longest Valid Parentheses
 *
 * Given a string containing just the characters '(' and ')', find the length of the longest valid (well-formed) parentheses substring.
 *
 * Input: "(()" Output: 2
 * Explanation: The longest valid parentheses substring is "()"
 *
 * Input: ")()())" Output: 4
 * Explanation: The longest valid parentheses substring is "()()"
 */
public class LongestValidParentheses_L032_035 {
    class Solution {
        public int longestValidParentheses(String s) {
            boolean[] valid = new boolean[s.length()];
            Stack<Integer> stack = new Stack<>();
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '(') {
                    stack.push(i);
                } else if (!stack.isEmpty()) {
                    valid[stack.pop()] = valid[i] = true;
                }
            }
            return longest(valid);
        }

        private int longest(boolean[] valid) {
            int max = 0, len = 0;
            for (boolean b : valid) {
                max = Math.max(max, len = b ? len + 1 : 0);
            }
            return max;
        }
    }
}
