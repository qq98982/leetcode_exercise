package com.home.henry.back_tracking_05;

import java.util.ArrayList;
import java.util.List;

/**
 * 17. Letter Combinations of a Phone Number
 */
public class L017_CombinationsOfAPhoneNumber_011 {
    static class Solution {
        private String[] mapping = new String[] {
                "0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"
        };

        public List<String> letterCombinations(String digits) {
            List<String> res = new ArrayList<>();
            if (digits == null || digits.length() == 0) {return res;}
            helper(res, digits, "", 0);
            return res;

        }

        private void helper(List<String> res, String digits, String s, int index) {
            if (index == digits.length()) {
                res.add(s);
                return;
            }
            String letters = mapping[digits.charAt(index) - '0'];
            for (int i = 0; i < letters.length(); i++) {
                helper(res, digits, s + letters.charAt(i), index + 1);
            }
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.letterCombinations("23"));
    }
}
