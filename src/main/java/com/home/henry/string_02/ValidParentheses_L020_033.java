package com.home.henry.string_02;

import java.util.Stack;

/**
 * 20. Valid Parentheses
 *
 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine
 * if the input string is valid.
 *
 * An input string is valid if:
 *
 *     Open brackets must be closed by the same type of brackets.
 *     Open brackets must be closed in the correct order.
 *
 * Note that an empty string is also considered valid.
 *
 * Input: "()" Output: true
 *
 * Input: "()[]{}" Output: true
 *
 * Input: "(]" Output: false
 *
 * Input: "([)]" Output: false
 *
 * Input: "{[]}" Output: true
 */
public class ValidParentheses_L020_033 {
    static class Solution {
        public boolean isValid(String s) {
            if (s == null || s.length() == 0) {return true;}
            Stack<Character> stack = new Stack<>();
            char[] ch = s.toCharArray();
            for (int i = 0; i < ch.length; i++) {
                if ('(' == ch[i]) {
                    stack.push(')');
                } else if ('[' == ch[i]) {
                    stack.push(']');
                } else if ('{' == ch[i]) {
                    stack.push('}');
                } else if (stack.isEmpty() || ch[i] != stack.pop()) {
                    return false;
                }
            }
            return stack.isEmpty();
        }
    }
}
