package com.home.henry.string_02;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 30. Substring with Concatenation of All Words
 *
 * You are given a string, s, and a list of words, words, that are all of the same length. Find all starting
 * indices of substring(s) in s that is a concatenation of each word in words exactly once and without any
 * intervening characters.
 *
 * Input: s = "barfoothefoobarman", words = ["foo","bar"] Output: [0,9]
 * Explanation: Substrings starting at index 0 and 9 are "barfoo" and "foobar" respectively.
 * The output order does not matter, returning [9,0] is fine too.
 *
 * Input: s = "wordgoodgoodgoodbestword", words = ["word","good","best","word"] Output: []
 */
public class SubstringWithConcatenationOfAllWords_L030 {

    class Solution {
        public List<Integer> findSubstring(String s, String[] words) {
            List<Integer> res = new ArrayList<>();
            if (s == null || s.isEmpty() || words == null || words.length == 0) {return res;}
            if (s.length() < words.length * words[0].length()) {return res;}
            Map<String, Integer> map = new HashMap<>();
            for (String str : words) {
                map.put(str, map.getOrDefault(str, 0) + 1);
            }
            int n = words.length, m = words[0].length();
            for (int i = 0; i <= s.length() - n * m; i++) {
                int count = n, j = i;
                Map<String, Integer> tempMap = new HashMap<>(map);
                while (count > 0) {
                    String ss = s.substring(j, j + m);
                    if (tempMap.getOrDefault(ss, 0) < 1) {
                        break;
                    }
                    tempMap.put(ss, tempMap.get(ss) - 1);
                    count--;
                    j += m;
                }
                if (count == 0) {
                    res.add(i);
                }
            }
            return res;
        }
    }

}
