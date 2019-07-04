package com.home.henry.array_01;

import java.util.ArrayList;
import java.util.List;

/**
 * 438. Find All Anagrams in a String
 * Input: s: "cbaebabacd" p: "abc"
 * Output: [0, 6]
 * The substring with start index = 0 is "cba", which is an anagram of "abc".
 * The substring with start index = 6 is "bac", which is an anagram of "abc".
 *
 * 这个题目其实是String类型的, 放在这里是因为这个是典型sliding window的解法
 * 和567非常像, 可以用同样的方法解
 *
 * 题意是找出p的permutation在s中的index, 返回index的list
 * 难度标记为简单, 应该是中等
 *
 * 解法2用的while方法
 * https://leetcode.com/problems/minimum-window-substring/discuss/26808/Here-is-a-10-line-template-that-can-solve-most-'substring'-problems
 * 参考这个地址中的ndec09的帖子, 和解法1思想类似, 但是思路很不相同
 */
public class FindAllAnagramsInAString_L438_053 {

    static class Solution {
        List<Integer> findAnagrams(String s, String p) {
            List<Integer> res = new ArrayList<>();
            if (s == null || p == null || p.length() > s.length()) {return res;}
            int sLen = s.length(), pLen = p.length();
            int[] count = new int[26];
            for (int i = 0; i < pLen; i++) {
                count[p.charAt(i) - 'a']++;
                count[s.charAt(i) - 'a']--;
            }
            if (countIsZero(count)) {res.add(0);}
            for (int i = pLen; i < sLen; i++) {
                count[s.charAt(i) - 'a']--;
                count[s.charAt(i - pLen) - 'a']++;
                if (countIsZero(count)) {
                    res.add(i - pLen + 1);
                }
            }
            return res;
        }

        private boolean countIsZero(int[] count) {
            for (int i = 0; i < count.length; i++) {
                if (count[i] != 0) {return false;}
            }
            return true;
        }
    }

    static class SolutionWhile {
        List<Integer> findAnagrams(String s, String p) {
            List<Integer> res = new ArrayList<>();
            int s1 = s.length(), p1 = p.length();
            if (p1 > s1) {return res;}
            int[] count = new int[26];
            int start = 0, end = 0, counter = 0;
            for (int i = 0; i < p.length(); i++) {
                count[p.charAt(i) - 'a']++;
            }
            while (end < s1) {
                char c1 = s.charAt(end);
                if (count[c1 - 'a'] > 0) {
                    counter++;
                }
                count[c1 - 'a']--;
                end++;
                while (counter == p.length()) {
                    char c2 = s.charAt(start);
                    if (count[c2 - 'a'] == 0) {
                        counter--;
                        res.add(start);
                    }
                    count[c2 - 'a']++;
                    start++;
                }
            }
            return res;
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        SolutionWhile sw = new SolutionWhile();
        System.out.println("[0, 6] -> " + s.findAnagrams("cbaebabacd", "abc"));
        System.out.println("[0, 6] -> " + sw.findAnagrams("cbaebabacd", "abc"));
        System.out.println("[0, 1, 2] -> " + s.findAnagrams("abab", "ab"));
        System.out.println("[0, 1, 2] -> " + sw.findAnagrams("abab", "ab"));
    }
}
