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
    static class SolutionDfs {
        public static List<String> removeInvalidParentheses(String s) {
            List<String> res = new ArrayList<>();
            char[] check = new char[] { '(', ')' };
            dfs(s, res, check, 0, 0);
            return res;
        }

        public static void dfs(String s, List<String> res, char[] check, int last_i, int last_j) {
            int count = 0;
            int i = last_i;
            while (i < s.length() && count >= 0) {

                if (s.charAt(i) == check[0]) { count++; }
                if (s.charAt(i) == check[1]) { count--; }
                i++;
            }

            if (count >= 0) {
                // no extra ')' is detected. We now have to detect extra '(' by reversing the string.
                String reversed = new StringBuffer(s).reverse().toString();
                // from left to right, count>=0 means '(' is not less than ')'. only in this way we check the                 // reversed string. when we check the reversed string, count>=0 means')' is not less than '(',               // so we could know '(' == ')', just add the string to the res.
                if (check[0] == '(') {dfs(reversed, res, new char[] { ')', '(' }, 0, 0);} else {
                    res.add(reversed);
                }

            } else {  // extra ')' is detected and we have to do something
                i -= 1; // 'i-1' is the index of abnormal ')' which makes count<0
                for (int j = last_j; j <= i; j++) {
                    // first is ')' or current is but previous one is not ')', because we need last ')'
                    if (s.charAt(j) == check[1] && (j == last_j || s.charAt(j - 1) != check[1])) {
                        dfs(s.substring(0, j) + s.substring(j + 1, s.length()), res, check, i, j);
                    }
                }
            }
        }
    }

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
