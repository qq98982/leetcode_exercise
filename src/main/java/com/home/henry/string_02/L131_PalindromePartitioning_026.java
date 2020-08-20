package com.home.henry.string_02;

import java.util.ArrayList;
import java.util.List;

/**
 * 131. Palindrome Partitioning
 *
 * Given a string s, partition s such that every substring of the partition is a palindrome.
 *
 * Return all possible palindrome partitioning of s.
 *
 * Input: "aab" Output: [ ["aa","b"], ["a","a","b"] ]
 */
public class L131_PalindromePartitioning_026 {
    private static class Solution {

        List<List<String>> res = new ArrayList<>();

        public List<List<String>> partition(String s) {
            int[] p = manacher(s);
            backtrack(s, 0, p, new ArrayList<String>());
            return res;
        }

        private void backtrack(String s, int start, int[] p, List<String> list) {
            if (start == s.length()) {
                res.add(list);
                return;
            }
            int index = 2 * start + 1;
            for (int i = index; i < p.length; i++) {
                // len是这个字母最大palindrome的长度
                int len = p[i] - 1;
                int left = i - len + 1;
                // left是这段字符中的#的长度
                int diff = start - left / 2;
                // diff >= 0指的是当前的palindrome长度中, palindrome最左边的index不会比start小, 不会和start相交
                // 至少比start大一个#, 加上start前的, 就是start > left / 2
                // 如果相交了, 不会backtrack的
                if (diff >= 0) {
                    List<String> newList = new ArrayList<>(list);
                    newList.add(s.substring(start, start + len - diff * 2));
                    backtrack(s, start + len - diff * 2, p, newList);
                }
            }
        }
        private static int[] manacher(String s) {
            char[] ch = manaStr(s);
            int[] p = new int[ch.length];
            int R = -1, C = -1;
            for (int i = 0; i < p.length; i++) {
                p[i] = R > i ? Math.min(R - i, p[2 * C - i]) : 1;
                while (i + p[i] < p.length && i - p[i] > -1) {
                    if (ch[i + p[i]] == ch[i - p[i]]) {
                        p[i]++;
                    } else {
                        break;
                    }
                }
                if (R < i + p[i]) {
                    R = i + p[i];
                    C = i;
                }
            }
            return p;
        }
        private static char[] manaStr(String s) {
            int index = 0;
            char[] sh = s.toCharArray();
            char[] ch = new char[sh.length * 2 + 1];
            for (int i = 0; i < ch.length; i++) {
                ch[i] = (i % 2 == 0) ? '#' : sh[index++];
            }
            return ch;
        }
    }
}
