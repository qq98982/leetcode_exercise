package com.home.henry.others;

import java.util.ArrayList;
import java.util.List;

/**
 * Substring with K distinct characters
 *
 * https://leetcode.com/discuss/interview-question/330023/Amazon-or-OA-or-Most-common-word-and-Substring-with-K-distinct-characters
 * 
 * 谷歌的online题目, 加上另外一道题(Most common word), 要求在70 min中完成
 * Michelle has created a word game for her students. The word game begins with Michelle writing a string and
 * a number, K, on the board. The students have to ﬁnd the substrings of size K with K distinct characters.
 * Write an algorithm to help the students ﬁnd the correct answer. If the given string does not have K
 * distinct characters then output an empty list.
 * Input
 * The input to the function/method consists of two arguments -
 * inputStr, representing the string written by the teacher;
 * num , an integer representing the number, K, written by the teacher on the board.
 *
 * Output
 * Return distinct substrings of input string of size K with K distinct characters.
 *
 * Constraints 0 ≤  num  ≤ 26
 *
 * The input string consists of only lowercase letters of the English alphabet. Substrings are not
 * necessarily distinct.
 *
 * Examples
 * Input: inputStr = awaglknagawunagwkwagl num = 4
 *
 * Output:
 * {wagl, aglk, glkn, lkna, knag, gawu, awun, wuna, unag, nagw, agwk, kwag}
 *
 * Explanation:
 * Substrings in order are: wagl, aglk, glkn, lkna, knag, gawu, awun, wuna, unag, nagw, agwk, kwag, wagl
 * "wagl" is repeated twice, but is included in the output once.
 *
 * 思路是sliding window
 */
public class DistinctSubstringGoogle {
    static class Solution {
        List<String> disSubstring(String str, int num) {
            List<String> res = new ArrayList<>();
            if (str == null || str.length() == 0 || num > str.length()) {
                return res;
            }
            char[] charArray = str.toCharArray();
            int[] count = new int[26];
            int cnt = 0, mulCnt = 0;
            for (int i = 0; i < charArray.length; i++) {
                count[charArray[i] - 'a']++;
                cnt++;
                if (count[charArray[i] - 'a'] > 1) {
                    mulCnt++;
                }
                if (cnt > num) {
                    count[charArray[i - num] - 'a']--;
                    if (count[charArray[i - num] - 'a'] == 1) {
                        mulCnt--;
                    }
                    cnt--;
                }
                if (cnt == num && mulCnt == 0) {
                    res.add(str.substring(i - num + 1, i + 1));
                }
            }
            return res;
        }

    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        List<String> res = solution.disSubstring("awaglknagawunagwkwagl", 4);
        for (String s : res) {
            System.out.print(s + " ");
        }
    }
}
