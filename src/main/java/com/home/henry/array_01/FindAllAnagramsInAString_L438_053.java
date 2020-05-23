package com.home.henry.array_01;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * 438. Find All Anagrams in a String
 *
 * Input: s: "cbaebabacd" p: "abc" Output: [0, 6]
 * The substring with start index = 0 is "cba", which is an anagram of "abc".
 * The substring with start index = 6 is "bac", which is an anagram of "abc".
 *
 * 这个题目其实是String类型的, 放在这里是因为这个是典型sliding window的解法
 * 和567非常像, 可以用同样的方法解
 *
 * 题意是找出p的permutation在s中的index, 返回index的list
 *
 * 解法2用的while方法
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
        public List<Integer> findAnagrams(String s, String p) {
            List<Integer> result = new LinkedList<>();
            if (p.length() > s.length()) {return result;}
            Map<Character, Integer> map = new HashMap<>();
            for (char c : p.toCharArray()) {
                map.put(c, map.getOrDefault(c, 0) + 1);
            }
            int counter = map.size();

            int start = 0, end = 0;

            while (end < s.length()) {
                char c = s.charAt(end);
                if (map.containsKey(c)) {
                    map.put(c, map.get(c) - 1);
                    if (map.get(c) == 0) {counter--;}
                }
                end++;

                while (counter == 0) {
                    char temp = s.charAt(start);
                    if (map.containsKey(temp)) {
                        map.put(temp, map.get(temp) + 1);
                        if (map.get(temp) > 0) {
                            counter++;
                        }
                    }
                    if (end - start == p.length()) {
                        result.add(start);
                    }
                    start++;
                }
            }
            return result;
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        SolutionWhile sw = new SolutionWhile();
        System.out.println("[0, 6] -> " + s.findAnagrams("cbaebabacd", "abc"));
        System.out.println("[0, 6] -> " + sw.findAnagrams("cbaebabacd", "abc"));
        System.out.println("[0, 1, 2] -> " + s.findAnagrams("abab", "ab"));
        System.out.println("[0, 1, 2] -> " + sw.findAnagrams("abab", "ab"));
        System.out.println("[3, 4, 6] -> " + s.findAnagrams("abaacbabc", "abc"));
        System.out.println("[3, 4, 6] -> " + sw.findAnagrams("abaacbabc", "abc"));
    }
}
