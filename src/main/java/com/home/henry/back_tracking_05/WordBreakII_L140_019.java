package com.home.henry.back_tracking_05;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 140. Word Break II
 *
 * Given a non-empty string s and a dictionary wordDict containing a list of non-empty words, add spaces in s
 * to construct a sentence where each word is a valid dictionary word. Return all such possible sentences.
 *
 * The same word in the dictionary may be reused multiple times in the segmentation.
 * You may assume the dictionary does not contain duplicate words.
 *
 * Input: s = "catsanddog" wordDict = ["cat", "cats", "and", "sand", "dog"]
 * Output: [ "cats and dog", "cat sand dog" ]
 *
 * Input: s = "pineapplepenapple" wordDict = ["apple", "pen", "applepen", "pine", "pineapple"]
 * Output: [ "pine apple pen apple", "pineapple pen apple", "pine applepen apple" ]
 * Explanation: Note that you are allowed to reuse a dictionary word.
 *
 * Input: s = "catsandog" wordDict = ["cats", "dog", "sand", "and", "cat"]
 * Output: []
 */
public class WordBreakII_L140_019 {

    // 我们直接用递归的方法，先判断当前字符串在不在 wordDict 中，如果在的话就递归的去求剩余字符串的所有组成可能。
    // 直接使用 memoization 技术，将递归过程中求出来的解缓存起来，便于之后直接用。
    static class Solution {
        Map<Integer, List<String>> map = new HashMap<>();

        public List<String> wordBreak(String s, List<String> wordDict) {
            return helper(s, wordDict, 0);
        }

        private List<String> helper(String s, List<String> wordDict, int start) {
            // 如果map中有start这个index, 从map中返回
            if (map.containsKey(start)) {
                return map.get(start);
            }
            List<String> res = new ArrayList<>();
            if (start == s.length()) {
                res.add("");
            }
            for (int end = start + 1; end <= s.length(); end++) {
                String startToEndStr = s.substring(start, end);
                if (wordDict.contains(startToEndStr)) {
                    // 递归得到剩余字符串的所有组成可能，然后和当前字符串分别用空格连起来加到结果中
                    List<String> list = helper(s, wordDict, end);
                    for (String temp : list) {
                        res.add(startToEndStr + (temp.equals("") ? "" : " ") + temp);
                    }
                }
            }
            // 缓存结果
            map.put(start, res);
            return res;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println("[cat sand dog, cats and dog] : " +
                           solution.wordBreak("catsanddog",
                                              Arrays.asList("cat", "cats", "and", "sand", "dog")));
        Solution solution2 = new Solution();
        System.out.println("[pine apple pen apple, pine applepen apple, pineapple pen apple] : " + solution2
                .wordBreak("pineapplepenapple",
                           Arrays.asList("apple", "pen", "applepen", "pine", "pineapple")));
    }
}
