package com.home.henry.string_02;

import java.util.ArrayList;
import java.util.List;

/**
 * 22. Generate Parentheses
 *
 *  Given n pairs of parentheses, write a function to generate all combinations of
 *  well-formed parentheses.
 *
 * For example, given n = 3, a solution set is:
 *
 * [
 *   "((()))",
 *   "(()())",
 *   "(())()",
 *   "()(())",
 *   "()()()"
 * ]
 */
public class GenerateParentheses_L022_034 {

    static class Solution {
        public List<String> generateParenthesis(int n) {
            List<String> res = new ArrayList<>();
            genResult(res, "", n, n);
            return res;
        }

        private void genResult(List<String> res, String prefix, Integer left, Integer right) {
            if (left == 0 && right == 0) {
                res.add(prefix);
            }
            if (left > 0) {
                genResult(res, prefix + "(", left - 1, right);
            }
            // 如果有"(()))", left=2,right=3这个情况,那么是不能再向后匹配的, 所以必须是要right>=left
            if (right > left) {
                genResult(res, prefix + ")", left, right - 1);
            }
        }
    }
}
