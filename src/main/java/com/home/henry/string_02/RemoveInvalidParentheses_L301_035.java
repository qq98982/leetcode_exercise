package com.home.henry.string_02;

import java.util.ArrayList;
import java.util.List;

/**
 * 301. Remove Invalid Parentheses
 *
 * hard
 *
 * Remove the minimum number of invalid parentheses in order to make the input string
 * valid. Return all possible results.
 *
 * Note: The input string may contain letters other than the parentheses ( and ).
 *
 * Input: "()())()" Output: ["()()()", "(())()"]
 * Input: "(a)())()" Output: ["(a)()()", "(a())()"]
 * Input: ")(" Output: [""]
 */
public class RemoveInvalidParentheses_L301_035 {

    static class Solution {
        public static List<String> removeInvalidParentheses(String s) {
            List<String> output = new ArrayList<>();
            removeHelper(s, output, 0, 0, '(', ')');
            return output;
        }

        public static void removeHelper(String s, List<String> output, int iStart, int jStart, char openParen,
                                        char closedParen) {
            int numOpenParen = 0, numClosedParen = 0;
            for (int i = iStart; i < s.length(); i++) {
                if (s.charAt(i) == openParen) { numOpenParen++; }
                if (s.charAt(i) == closedParen) { numClosedParen++; }
                if (numClosedParen > numOpenParen) { // We have an extra closed paren we need to remove
                    for (int j = jStart; j <= i; j++) {
                        // Try removing one at each position, skipping duplicates
                        if (s.charAt(j) == closedParen && (j == jStart || s.charAt(j - 1) != closedParen)) {
                            // Recursion: iStart = i since we now have valid # closed parenthesis thru i. jStart = j prevents duplicates
                            removeHelper(s.substring(0, j) + s.substring(j + 1, s.length()), output, i, j,
                                         openParen, closedParen);
                        }
                    }
                    return; // Stop here. The recursive calls handle the rest of the string.
                }
            }
            // No invalid closed parenthesis detected. Now check opposite direction, or reverse back to original direction.
            String reversed = new StringBuilder(s).reverse().toString();
            if (openParen == '(') {
                removeHelper(reversed, output, 0, 0, ')', '(');
            } else {
                output.add(reversed);
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(Solution.removeInvalidParentheses("(a)())()"));
        System.out.println(Solution.removeInvalidParentheses("()())()"));
        System.out.println(Solution.removeInvalidParentheses(")("));
    }
}
